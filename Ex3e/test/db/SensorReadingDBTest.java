package db;

import business.Sensor;
import business.SensorReading;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SensorReadingDBTest {
    Sensor sensor1;

    @BeforeEach
    void setUp () {
        sensor1 = new Sensor(1, 1, "Air register");
        sensor1.addSensorReading(70.0f, LocalDateTime.of(2020, 01, 01, 0, 0, 0));
        sensor1.addSensorReading(72.2f, LocalDateTime.of(2020, 01, 01, 0, 0, 2));
        sensor1.addSensorReading(74.4f, LocalDateTime.of(2020, 01, 01, 0, 0, 4));
        sensor1.addSensorReading(76.6f, LocalDateTime.of(2020, 01, 01, 0, 0, 6));
        sensor1.addSensorReading(78.8f, LocalDateTime.of(2020, 01, 01, 0, 0, 8));
    }

    @Test
    void saveAll() {
        assertEquals(5, SensorReadingDB.saveAll(sensor1.getSensorReadings()));
    }

    @Test
    void getAll() {
        assertEquals(5, SensorReadingDB.getAll(new ArrayList<SensorReading>()).size());
    }
}