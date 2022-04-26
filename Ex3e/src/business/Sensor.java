package business;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sensor {
    private int sensorId;
    private int roomId;
    private int sensorTypeId;
    private String description;
    private ArrayList<SensorReading> sensorReadings = new ArrayList<SensorReading>();

    private static int nextSensorId = 101;     // Simulate database-assigned id
    private int nextSensorReadingIndex = 0;  // index of next SensorReading

    public Sensor(int roomId, int sensorTypeId, String description) {
        this.sensorId = nextSensorId++;
        this.roomId = roomId;
        this.sensorTypeId = sensorTypeId;
        this.description = description;
    }

    public int getSensorId() {
        return sensorId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(int sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addSensorReading(float value) {
        this.sensorReadings.add(
                new SensorReading(nextSensorReadingIndex + 1001, this.sensorId, value));
        nextSensorReadingIndex++;
    }

    public void addSensorReading(float value, LocalDateTime dateTime) {
        this.sensorReadings.add(
                new SensorReading(nextSensorReadingIndex + 1001, this.sensorId, dateTime, value));
        nextSensorReadingIndex++;
    }

    public ArrayList<SensorReading> getSensorReadings() {
        return sensorReadings;
    }
}
