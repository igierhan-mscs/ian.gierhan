package business;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SensorReadingTest {

    @org.junit.jupiter.api.Test
    void toJson() {
        SensorReading sr = new SensorReading(1001, 101,
                LocalDateTime.of(2020, 01, 01, 0, 0, 0), 88.8f);
        assertEquals("{\"sensorReadingId\":1001,\"sensorId\":101,\"dateTime\":\"2020-01-01T00:00\",\"value\":88.8}", sr.toJson());
    }
}