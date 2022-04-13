package ui;

import business.Sensor;
import business.Values;

public class Main {
    public static void main(String[] args) {
        Values values = new Values();

        System.out.println("Total = \t\t" + values.calcTotal());
        System.out.println("Minimum value = \t" + values.calcMin());
        System.out.println("Maximum value = \t" + values.calcMax());
        System.out.println("Average value = \t" + values.calcAvg());

        Sensor sensor1 = new Sensor(1,1, "Air register");

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

        System.out.println("Minimum sensor reading = \t" + sensor1.minReading());
        System.out.println("Maximum sensor reading = \t" + sensor1.maxReading());
        System.out.println("Average sensor reading = \t" + sensor1.avgReading());
    }
}
