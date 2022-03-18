package business;

import java.util.Locale;

public class Ex2fSample {
    private int i1;
    private int i2;
    private double d1;
    private double d2;
    private String s1;
    private String s2;

    public Ex2fSample() {
    }

    public Ex2fSample(int i1, int i2, double d1, double d2, String s1, String s2) {
        this.i1 = i1;
        this.i2 = i2;
        this.d1 = d1;
        this.d2 = d2;
        this.s1 = s1;
        this.s2 = s2;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    public int getI2() {
        return i2;
    }

    public void setI2(int i2) {
        this.i2 = i2;
    }

    public double getD1() {
        return d1;
    }

    public void setD1(double d1) {
        this.d1 = d1;
    }

    public double getD2() {
        return d2;
    }

    public void setD2(double d2) {
        this.d2 = d2;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    @Override
    public String toString() {
        return "Ex2fSample{" +
                "i1=" + i1 +
                ", i2=" + i2 +
                ", d1=" + d1 +
                ", d2=" + d2 +
                ", s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                '}';
    }

    // range test i1: 1 - 10
    public boolean test1() {
        if (this.i1 >= 1 && this.i1 <= 10)
            return true;
        return false;
    }

    // range test: i2 < i1 < d1
    public boolean test2() {
        if (this.i2 < i1 && this.i1 < d1)
            return true;
        return false;
    }

    // return smaller value: s1 or s2
    public String test3() {
        int result = s1.compareToIgnoreCase(s2);
        if (result < 0)
            return s1;
        else
            return s2;
    }

    // if d1 is out of range, return -1
    // if d2 is out of range, return -1
    // calculate regular pay
    // if d1 > 40, calculate overtime pay
    // return total pay
    public double test4() {
        if (d1 < 0 || d1 > 168)
            return -1;
        if (d2 < 7.87 || d2 > 99.99)
            return -1;
        if (d1 <= 40)
            return d1 * d2;
        else
            return (d1 * d2 + (d1 - 40) * d2 * 0.5);
    }

    // Same as test4() but use nested-if and only one return
    public double test5() {
        if (0 <= d1 && d1 <= 168 && 7.87 <= d2 && d2 <= 99.99) {
            if (d1 <= 40) return d1 * d2;
            return (d1 * d2 + (d1 - 40) * d2 * 0.5);
        } else {
            return -1;
        }
    }


    // if s1 is not null, use switch to determine if s1 is: aaaa, bbbb, or cccc
    public boolean test6() {
        if (s1 != null) {
            switch (s1.toLowerCase()) {
                case "aaaa":
                case "bbbb":
                case "cccc":
                    return true;
            }
        }return false;
    }
}
