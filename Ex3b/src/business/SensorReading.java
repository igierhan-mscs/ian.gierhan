package business;

import java.time.LocalDateTime;

public class SensorReading {
    private int sensorReadingId;
    private int sensorId;
    private LocalDateTime dateTime;
    private float value;

    public SensorReading(int sensorReadingId, int sensorId, float value) {
        this.sensorReadingId = sensorReadingId;
        this.sensorId = sensorId;
        this.dateTime = LocalDateTime.now();
        this.value = value;
    }

    public int getSensorReadingId() { return sensorReadingId; }

    public int getSensorId() { return sensorId; }

    public LocalDateTime getDateTime() { return dateTime; }

    public float getValue() { return value; }
}