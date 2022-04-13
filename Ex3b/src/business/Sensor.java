package business;

public class Sensor {
    private int sensorId;
    private int roomId;
    private int sensorTypeId;
    private String description;
    private SensorReading[] sensorReadings = new SensorReading[50];

    private static int nextSensorId = 101;   // Simulate database-assigned id
    private int nextSensorReadingIndex = 0;   // index of next SensorReading


    public Sensor(int roomId, int sensorTypeId, String description) {
        this.sensorId = nextSensorId++;
        this.roomId = roomId;
        this.sensorTypeId = sensorTypeId;
        this.description = description;
    }

    public int getSensorId() { return sensorId; }

    public int getRoomId() { return roomId; }

    public void setRoomId(int roomId) { this.roomId = roomId; }

    public int getSensorTypeId() { return sensorTypeId; }

    public void setSensorTypeId(int sensorTypeId) { this.sensorTypeId = sensorTypeId; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public void addSensorReading(float value) {
        this.sensorReadings[nextSensorReadingIndex] =
                new SensorReading(nextSensorReadingIndex + 1001, this.sensorId, value);
        nextSensorReadingIndex++;
    }

    public float minReading() {
        float min = sensorReadings[0].getValue();
        for (int i = 0; i < sensorReadings.length; i++) {
            if (sensorReadings[i].getValue() < min)
                min = sensorReadings[i].getValue();
        }
        min = Math.round(min * 10.0f) / 10.0f;
        return min;
    }

    public float maxReading() {
        float max = sensorReadings[0].getValue();
        for (int i = 0; i < sensorReadings.length; i++) {
            if (sensorReadings[i].getValue() > max)
                max = sensorReadings[i].getValue();
        }
        max = Math.round(max * 10.0f) / 10.0f;
        return max;
    }

    public float avgReading() {
        float avg = 0.0f;
        for (int i = 0; i < sensorReadings.length; i++) {
            avg += sensorReadings[i].getValue();
        }
        avg = avg / sensorReadings.length;
        avg =  Math.round(avg * 100.0f) / 100.0f;
        return avg;
    }

}
