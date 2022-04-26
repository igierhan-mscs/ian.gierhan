package db;

import business.SensorReading;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class SensorReadingDB {
//        private static Path sensorReadingsPath = Paths.get("Ex3e\\SensorReadings.json");
        private static Path sensorReadingsPath = Paths.get("SensorReadings.json");
        private static File sensorReadingsFile = sensorReadingsPath.toFile();
        private static final String FIELD_SEP = "\t";


        public static int saveAll(List<SensorReading> sensorReadings) {
            int count = 0;
            try (PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(sensorReadingsFile)))) {
                out.println("{\"sensorReadings\":[");
                for (SensorReading sr : sensorReadings) {
                    if (count > 0) out.println(",");
                    out.print(sr.toJson());
                    count++;
                }
                out.println("]}");
            }
            catch (IOException e) {
                System.out.println(e);
            }
            return count;
        }

        public static List<SensorReading> getAll(List<SensorReading> sensorReadings) {
            if (Files.exists(sensorReadingsPath)) {
                try (BufferedReader in = new BufferedReader(
                        new FileReader(sensorReadingsFile))) {
                    //Read sensorReadings from file into ArrayList
                    String line = in.readLine();
                    if (line != null) line = in.readLine();
                    while (line != null) {
                        // Parse sensorReadingId
                        int beginIndex = line.indexOf("\"sensorReadingId\":") + 18;
                        int endIndex = line.indexOf(",", beginIndex);
                        String val = line.substring(beginIndex, endIndex);
                        int sensorReadingId = Integer.parseInt(val);
                        // Parse sensorId
                        beginIndex = line.indexOf("\"sensorId\":") + 11;
                        endIndex = line.indexOf(",", beginIndex);
                        val = line.substring(beginIndex, endIndex);
                        int sensorId = Integer.parseInt(val);
                        // Parse dateTime
                        beginIndex = line.indexOf("\"dateTime\":\"") + 12;
                        endIndex = line.indexOf("\",", beginIndex);
                        val = line.substring(beginIndex, endIndex);
                        LocalDateTime dateTime = LocalDateTime.parse(val);
                        // Parse value
                        beginIndex = line.indexOf("\"value\":") + 8;
                        endIndex = line.indexOf("}", beginIndex);
                        val = line.substring(beginIndex, endIndex);
                        float value = Float.parseFloat(val);

                        sensorReadings.add(new SensorReading(sensorReadingId, sensorId, dateTime, value));
                        line = in.readLine();
                    }
                }
                catch (IOException e) {
                    System.out.println(e);
                    return null;
                }
            }
            else {
                System.out.println(sensorReadingsPath.toAbsolutePath() + "doesn't exist.");
                return null;
            }
            return sensorReadings;
        }
}
