import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValuesTest {
    Values values = null;

    @BeforeEach
    void setUp() {
        this.values = new Values();
    }

    @Test
    void sumCountWhile() {
        assertEquals(55, values.sumCountWhile());
    }

    @Test
    void sumCountDoWhile() {
        assertEquals(55, values.sumCountDoWhile());
    }

    @Test
    void sumCountFor() {
        assertEquals(55, values.sumCountFor());
    }

    @Test
    void sumCountValuesWhile() {
        assertEquals(815, values.sumCountValuesWhile());
    }

    @Test
    void sumCountValuesDoWhile() {
        assertEquals(815, values.sumCountValuesDoWhile());
    }

    @Test
    void sumCountValuesFor() {
        assertEquals(815, values.sumCountValuesFor());
    }

    @Test
    void sumFilteredValuesWhile() {
        assertEquals(658, values.sumFilteredValuesWhile());
    }

    @Test
    void sumFilteredValuesDoWhile() {
        assertEquals(658, values.sumFilteredValuesDoWhile());
    }

    @Test
    void sumFilteredValuesFor() {
        assertEquals(658, values.sumFilteredValuesFor());
    }
}