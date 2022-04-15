import business.Values;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValuesTest {
    Values values = null;

    @BeforeEach
    void setUp() {
        this.values = new Values();
    }

    @Test
    void calcTotal() {
        assertEquals(3891.4f, this.values.calcTotal());
    }

    @Test
    void calcMin() {
        assertEquals(71.6f, this.values.calcMin());
    }

    @Test
    void calcMax() {
        assertEquals(87.8f, this.values.calcMax());
    }

    @Test
    void calcAvg() {
        assertEquals(77.83f, this.values.calcAvg());
    }
}