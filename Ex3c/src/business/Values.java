package business;
import java.util.ArrayList;

public class Values {
    private ArrayList<Float> values = new ArrayList<>();
    
    public Values() {
        values.add(75.2f);
        values.add(73.4f);
        values.add(75.2f);
        values.add(73.4f);
        values.add(75.2f);
        values.add(73.4f);
        values.add(75.2f);
        values.add(73.4f);
        values.add(71.6f);
        values.add(73.4f);
        values.add(71.6f);
        values.add(73.4f);
        values.add(71.6f);
        values.add(73.4f);
        values.add(71.6f);
        values.add(73.4f);
        values.add(75.2f);
        values.add(77f);
        values.add(78.8f);
        values.add(80.6f);
        values.add(82.4f);
        values.add(84.2f);
        values.add(82.4f);
        values.add(84.2f);
        values.add(82.4f);
        values.add(84.2f);
        values.add(86f);
        values.add(87.8f);
        values.add(86f);
        values.add(84.2f);
        values.add(82.4f);
        values.add(80.6f);
        values.add(82.4f);
        values.add(80.6f);
        values.add(82.4f);
        values.add(80.6f);
        values.add(82.4f);
        values.add(80.6f);
        values.add(78.8f);
        values.add(77f);
        values.add(78.8f);
        values.add(77f);
        values.add(75.2f);
        values.add(77f);
        values.add(75.2f);
        values.add(73.4f);
        values.add(75.2f);
        values.add(73.4f);
        values.add(75.2f);
        values.add(73.4f);
    }

    public float calcTotal() {
        float total = 0.0f;
        for (int i = 0; i < values.size(); i++) {
            total += values.get(i);
        }
        total = Math.round(total * 10.0f) / 10.0f;
        return total;
    }

    public float calcMin() {
        float min = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) < min)
            min = values.get(i);
        }
        min = Math.round(min * 10.0f) / 10.0f;
        return min;
    }

    public float calcMax() {
        float max = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) > max)
                max = values.get(i);
        }
        max = Math.round(max * 10.0f) / 10.0f;
        return max;
    }

    public float calcAvg() {
        float avg = 0.0f;
        for (int i = 0; i < values.size(); i++) {
            avg += values.get(i);
        }
        avg = avg / values.size();
        avg =  Math.round(avg * 100.0f) / 100.0f;
        return avg;
    }
}
