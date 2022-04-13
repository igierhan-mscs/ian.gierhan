package business;

public class Values {
    private float[] values = {
            75.2f, 73.4f, 75.2f, 73.4f, 75.2f, 73.4f, 75.2f, 73.4f, 71.6f, 73.4f,
            71.6f, 73.4f, 71.6f, 73.4f, 71.6f, 73.4f, 75.2f, 77f, 78.8f, 80.6f,
            82.4f, 84.2f, 82.4f, 84.2f, 82.4f, 84.2f, 86f, 87.8f, 86f, 84.2f,
            82.4f, 80.6f, 82.4f, 80.6f, 82.4f, 80.6f, 82.4f, 80.6f, 78.8f, 77f,
            78.8f, 77f, 75.2f, 77f, 75.2f, 73.4f, 75.2f, 73.4f, 75.2f, 73.4f};

    public float calcTotal() {
        float total = 0.0f;
        for (int i = 0; i < values.length; i++) {
            total += values[i];
        }
        total = Math.round(total * 10.0f) / 10.0f;
        return total;
    }

    public float calcMin() {
        float min = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] < min)
            min = values[i];
        }
        min = Math.round(min * 10.0f) / 10.0f;
        return min;
    }

    public float calcMax() {
        float max = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max)
                max = values[i];
        }
        max = Math.round(max * 10.0f) / 10.0f;
        return max;
    }

    public float calcAvg() {
        float avg = 0.0f;
        for (int i = 0; i < values.length; i++) {
            avg += values[i];
        }
        avg = avg / values.length;
        avg =  Math.round(avg * 100.0f) / 100.0f;
        return avg;
    }
}
