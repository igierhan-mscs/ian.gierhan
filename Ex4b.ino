
/* YourDuino Ethernet Temperature/humidity Web Server
 Reads a DHT11 Sensor
 Outputs a web page with Temperature and Humidity
 terry@yourduino.com 
 
 Circuit:
 * Ethernet shield attached to pins 10, 11, 12, 13
 * DHT11 Sensor connected to Pin 7
 
 Based on code by David A. Mellis & Tom Igoe
 
 */
/*-----( Import needed libraries )-----*/
#include <SPI.h>
#include <Ethernet.h>
//#include <dht11.h>
#include <SimpleDHT.h>
#include <Wire.h>
#include <TimeLib.h>

/*-----( Declare Constants and Pin Numbers )-----*/
int pinDHT11 = 7;     // The Temperature/Humidity sensor
SimpleDHT11 dht11;
#define SENSORID 1035

// Enter a MAC address and IP address for your controller below.
// The IP address will be dependent on your local network:
byte mac[] = {
  0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };

/*-----( Declare objects )-----*/
IPAddress arduinoIp(192, 168, 1, 180);
IPAddress gateway(192, 168, 1, 1);
IPAddress subnet(255, 255, 255, 0);

IPAddress serverIp(204, 77, 50, 53);
int serverPort = 80;
char pageName[] = "/api/sensorreadings";

/*-----( Declare Variables )-----*/

// Initialize Ethernet client
EthernetClient client;
// Declare http Post request data
char json[71];  // Must be large enough to hold entire JSON payload
char jsonSearchStr[] = "\"dateTime\":\"";

#define delayMillis 10000UL
byte prevTempReading = 0;
unsigned long thisMillis = 0;
unsigned long lastMillis = 0;
// Stack readings to send to server
byte tempStack[50];
time_t timeStack[50];
int stackIndex = -1;

void setup()   /****** SETUP: RUNS ONCE ******/ 
{
  // Open serial communications and wait for port to open:
  Serial.begin(115200);
  
  // start the Ethernet connection and the server:
  if (Ethernet.begin(mac) == 0) {
    Serial.println("Failed to configure Ethernet using DHCP");
    // try to configure using IP address instead of DHCP:
    Ethernet.begin(mac, arduinoIp, gateway, subnet);
  }
  delay(1000);
}//--(end setup )---


void loop()   /*----( LOOP: RUNS OVER AND OVER AGAIN )----*/
{
  Ethernet.maintain();

  thisMillis = millis();
  if (thisMillis - lastMillis > delayMillis) {
    lastMillis = thisMillis;

    byte currTempReading = 0;
    byte currHumidReading = 0;
    int err = SimpleDHTErrSuccess;
    err = dht11.read(pinDHT11, &currTempReading, &currHumidReading, NULL);

    if ((currTempReading <= prevTempReading - 2) || (currTempReading >= prevTempReading + 2)) {
      if (stackIndex < 50) {
        stackIndex++;
        tempStack[stackIndex] = currTempReading;
        prevTempReading = currTempReading;
        if (timeStatus() == timeSet)
          timeStack[stackIndex] = now();
        else
          timeStack[stackIndex] = 0;  
      }

      byte postSucceeded = true;
      while (postSucceeded && stackIndex >= 0 ) {
        time_t t = timeStack[stackIndex];
        if (t == 0)
          sprintf(json, "{'SensorId':%d,'Value':%d}", SENSORID, (int) tempStack[stackIndex]); 
        else
          sprintf(json, "{'SensorId':%d,'Value':%d,'DateTime':'%04d-%02d-%02dT%02d:%02d:%02d'}", 
            SENSORID, (int) tempStack[stackIndex], year(t), month(t), day(t), hour(t), minute(t), second(t)); 
        Serial.println(json);
        postSucceeded = postPage(json);
        if (!postSucceeded)
          Serial.println(F("Fail "));
        else {
          Serial.println(F("Pass "));
          stackIndex--;
        }
      }  
    }
  }
  
} // END Loop

/*-----( Declare User-written Functions )-----*/
// --------------------------------- postPage()  ---------------------------------
// ---------------------- Performs http Post of json payload ---------------------
byte postPage(char* json)
{
  int inChar;
  char timeChArr[35];
  bool serverTimeFound = false;
  Serial.println("postPage() connecting...");

  if (client.connect(serverIp, serverPort)) {
    Serial.println("postPage() connected");

    // send http header
    client.println("POST /propertymonitor/api/sensorreadings HTTP/1.1");
    client.println("Host: 192.168.1.180"); // Don't change. Leave set to server address.
    client.println("User-Agent: Arduino/uno ethernet");
    client.println("Connection: close");
    client.println("Content-Type: application/json");
    client.print("Content-Length: ");
    client.println(strlen(json));// number of bytes in the payload
    client.println();// important: need an empty line here
    // send payload
    client.println(json);
  }
  else
  {
    Serial.println(F("postPage() connect failed"));
    return 0;
  }

  int connectLoop = 0;

  while(client.connected())
  {
    int jsonSearchIndex = 0;
    int jsonSearchStrLen = strlen(jsonSearchStr);
    //char jsonSearchStr[] = "\"dateTime\":\"";

    int timeIndex = 0;
    while(client.available())
    {
      inChar = client.read();
      Serial.write(inChar);
      if (jsonSearchIndex < jsonSearchStrLen) {           // if jsonSearchStr hasn't been found
        if (inChar == jsonSearchStr[jsonSearchIndex])     //if inChar matches next char in jsonSearchStr
          jsonSearchIndex++;
        else
          jsonSearchIndex = 0;
      }
      else {
        if (!serverTimeFound && inChar != '"') {
          timeChArr[timeIndex] = inChar;
          timeIndex++;    
        }
        else {
          timeChArr[timeIndex] = '\0';
          serverTimeFound = true;
        }
      }
      connectLoop = 0;
    }

    delay(1);
    connectLoop++;
    if(connectLoop > 10000)
    {
      Serial.println();
      Serial.println(F("Timeout"));
      client.stop();
    }
  }

  Serial.println();
  Serial.println(F("disconnecting."));
  client.stop();
  
  String timeStr(timeChArr);
  setTime(                              // Set Arduino's time
    timeStr.substring(11, 13).toInt(),  // hours
    timeStr.substring(14, 16).toInt(),  // minutes
    timeStr.substring(17, 19).toInt(),  // seconds
    timeStr.substring(8, 10).toInt(),   // day
    timeStr.substring(5, 7).toInt(),    // month
    timeStr.substring(0, 4).toInt());   // year
    
  return 1;
}

////
////Celsius to Fahrenheit conversion
//double Fahrenheit(double celsius)
//{
//  return 1.8 * celsius + 32;
//}
//
////Celsius to Kelvin conversion
//double Kelvin(double celsius)
//{
//  return celsius + 273.15;
//}
//
//// dewPoint function NOAA
//// reference: http://wahiduddin.net/calc/density_algorithms.htm 
//double dewPoint(double celsius, double humidity)
//{
//  double A0= 373.15/(273.15 + celsius);
//  double SUM = -7.90298 * (A0-1);
//  SUM += 5.02808 * log10(A0);
//  SUM += -1.3816e-7 * (pow(10, (11.344*(1-1/A0)))-1) ;
//  SUM += 8.1328e-3 * (pow(10,(-3.49149*(A0-1)))-1) ;
//  SUM += log10(1013.246);
//  double VP = pow(10, SUM-3) * humidity;
//  double T = log(VP/0.61078);   // temp var
//  return (241.88 * T) / (17.558-T);
//}
//
//// delta max = 0.6544 wrt dewPoint()
//// 5x faster than dewPoint()
//// reference: http://en.wikipedia.org/wiki/Dew_point
//double dewPointFast(double celsius, double humidity)
//{
//  double a = 17.271;
//  double b = 237.7;
//  double temp = (a * celsius) / (b + celsius) + log(humidity/100);
//  double Td = (b * temp) / (a - temp);
//  return Td;
//}
///* ( THE END ) */
