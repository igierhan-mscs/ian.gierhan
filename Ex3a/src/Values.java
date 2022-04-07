public class Values {
    private int values[] = {87, 99, 46, 75, 50, 88, 100, 85, 111, 74, -1, 79, 90};
    private int index = -1;

    public void resetIndex() { this.index = -1; }

    public int getNext() {
        index++;
        return values[index];
    }

    public int sumCountWhile() {
        int sum = 0;
        int i = 1;
        while (i <= 10) {
            sum += i;
            i++;
        }

        return sum;
    }

    public int sumCountDoWhile() {
        int sum = 0;
        int i = 1;
        do {
            sum += i;
            i++;
        } while (i <= 10);

        return sum;
    }

    public int sumCountFor() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }

        return sum;
    }

    public int sumCountValuesWhile() {
        resetIndex();
        int sum = 0;
        int i = 1;
        while (i <= 10) {
            int value = getNext();
            sum += value;
            i++;
        }

        return sum;
    }

    public int sumCountValuesDoWhile() {
        resetIndex();
        int sum = 0;
        int i = 1;
        do {
            int value = getNext();
            sum += value;
            i++;
        } while (i <= 10);

        return sum;
    }

    public int sumCountValuesFor() {
        resetIndex();
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            int value = getNext();
            sum += value;
        }

        return sum;
    }

    public int sumFilteredValuesWhile() {
        resetIndex();
        int sum = 0;
        int value = getNext();
        while (value != -1) {
            if (value >= 50 && value <= 100)
                sum += value;
                value = getNext();
        }

        return sum;
    }

    public int sumFilteredValuesDoWhile() {
        resetIndex();
        int sum = 0;
        int value = getNext();
        do {
            if (value >= 50 && value <= 100)
            sum += value;
            value = getNext();
        } while (value != -1);

        return sum;
    }

    public int sumFilteredValuesFor() {
        resetIndex();
        int sum = 0;
        for (int value = getNext(); value != -1; value = getNext()) {
            if (value >= 50 && value <= 100)
            sum += value;
        }

        return sum;
    }

}
