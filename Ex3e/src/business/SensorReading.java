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

    public SensorReading(int sensorReadingId, int sensorId, LocalDateTime dateTime, float value) {
        this.sensorReadingId = sensorReadingId;
        this.sensorId = sensorId;
        this.dateTime = dateTime;
        this.value = value;
    }

    public int getSensorReadingId() {
        return sensorReadingId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" +
                "sensorReadingId=" + sensorReadingId +
                ", sensorId=" + sensorId +
                ", dateTime=" + dateTime +
                ", value=" + value +
                "}";
    }

    public String toJson() {
        return "{" +
                "\"sensorReadingId\":" + sensorReadingId +
                ",\"sensorId\":" + sensorId +
                ",\"dateTime\":\"" + dateTime +
                "\",\"value\":" + value +
                "}";
    }
}