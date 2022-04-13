package business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorTest {
    Sensor sensor1;

    @BeforeEach
    void setUp () {
        sensor1 = new Sensor(1,1, "Air register");
        sensor1.addSensorReading(75.2f);
        sensor1.addSensorReading(73.4f);
        sensor1.addSensorReading(75.2f);
        sensor1.addSensorReading(73.4f);
        sensor1.addSensorReading(75.2f);
        sensor1.addSensorReading(73.4f);
        sensor1.addSensorReading(75.2f);
        sensor1.addSensorReading(73.4f);
        sensor1.addSensorReading(71.6f);
        sensor1.addSensorReading(73.4f);
        sensor1.addSensorReading(71.6f);
        sensor1.addSensorReading(73.4f);
        sensor1.addSensorReading(71.6f);
        sensor1.addSensorReading(73.4f);
        sensor1.addSensorReading(71.6f);
        sensor1.addSensorReading(73.4f);
        sensor1.addSensorReading(75.2f);
        sensor1.addSensorReading(77f);
        sensor1.addSensorReading(78.8f);
        sensor1.addSensorReading(80.6f);
        sensor1.addSensorReading(82.4f);
        sensor1.addSensorReading(84.2f);
        sensor1.addSensorReading(82.4f);
        sensor1.addSensorReading(84.2f);
        sensor1.addSensorReading(82.4f);
        sensor1.addSensorReading(84.2f);
        sensor1.addSensorReading(86f);
        sensor1.addSensorReading(87.8f);
        sensor1.addSensorReading(86f);
        sensor1.addSensorReading(84.2f);
        sensor1.addSensorReading(82.4f);
        sensor1.addSensorReading(80.6f);
        sensor1.addSensorReading(82.4f);
        sensor1.addSensorReading(80.6f);
        sensor1.addSensorReading(82.4f);
        sensor1.addSensorReading(80.6f);
        sensor1.addSensorReading(82.4f);
        sensor1.addSensorReading(80.6f);
        sensor1.addSensorReading(78.8f);
        sensor1.addSensorReading(77f);
        sensor1.addSensorReading(78.8f);
        sensor1.addSensorReading(77f);
        sensor1.addSensorReading(75.2f);
        sensor1.addSensorReading(77f);
        sensor1.addSensorReading(75.2f);
        sensor1.addSensorReading(73.4f);
        sensor1.addSensorReading(75.2f);
        sensor1.addSensorReading(73.4f);
        sensor1.addSensorReading(75.2f);
        sensor1.addSensorReading(73.4f);
    }

    @Test
    void minReading() {
        assertEquals(71.6f, this.sensor1.minReading());
    }

    @Test
    void maxReading() {
        assertEquals(87.8f, this.sensor1.maxReading());
    }

    @Test
    void avgReading() {
        assertEquals(77.83f, this.sensor1.avgReading());
    }
}