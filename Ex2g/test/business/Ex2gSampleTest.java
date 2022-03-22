package business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex2gSampleTest {

    @Test
    void getI1() {
        Ex2gSample obj1 = new Ex2gSample(0, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        int result = obj1.getI1();
        assertEquals(0, result);
    }

    @Test
    void getI2() {
        Ex2gSample obj1 = new Ex2gSample(0, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        int result = obj1.getI2();
        assertEquals(2, result);
    }

    @Test
    void getD1() {
        Ex2gSample obj1 = new Ex2gSample(0, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        double result = obj1.getD1();
        assertEquals(3.0, result);
    }

    @Test
    void getD2() {
        Ex2gSample obj1 = new Ex2gSample(0, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        assertEquals(4.0, obj1.getD2());
    }

    @Test
    void getS1() {
        Ex2gSample obj1 = new Ex2gSample(0, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        assertEquals("Aaaa", obj1.getS1());
    }

    @Test
    void getS2() {
        Ex2gSample obj1 = new Ex2gSample(0, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        assertEquals("Bbbb", obj1.getS2());
    }

    @Test
    void test1_BelowRange() {
        Ex2gSample obj1 = new Ex2gSample(0, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        assertFalse(obj1.test1(), "Testing i1 below valid range.");
    }

    @Test
    void test1_WithinRange1() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        assertTrue(obj1.test1(), "Testing i1 = lowest value in range.");
    }

    @Test
    void test1_WithinRange10() {
        Ex2gSample obj1 = new Ex2gSample(10, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        assertTrue(obj1.test1(), "Testing i1 = highest value in range.");
    }

    @Test
    void test1_AboveRange() {
        Ex2gSample obj1 = new Ex2gSample(11, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        assertFalse(obj1.test1(), "Testing i1 = above valid range.");
    }

    @Test
    void test2_BelowRange() {
        Ex2gSample obj1 = new Ex2gSample(1, 1, 3.0, 4.0, "Aaaa", "Bbbb");
        assertFalse(obj1.test2(), "Testing i1 below valid range.");
    }

    @Test
    void test2_WithinRange2() {
        Ex2gSample obj1 = new Ex2gSample(2, 1, 3.0, 4.0, "Aaaa", "Bbbb");
        assertTrue(obj1.test2(), "Testing i1 = lowest value in range.");
    }

    @Test
    void test2_AboveRange3() {
        Ex2gSample obj1 = new Ex2gSample(3, 1, 3.0, 4.0, "Aaaa", "Bbbb");
        assertFalse(obj1.test2(), "Testing i1 = above valid range.");
    }

    @Test
    void test3_S1EqualsAaaa() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 3.0, 4.0, "Aaaa", "Bbbb");
        assertEquals("Aaaa", obj1.test3());
    }

    @Test
    void test3_EqualsBbbb() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 3.0, 4.0, "Bbbb", "Bbbb");
        assertEquals("Bbbb", obj1.test3());
    }

    @Test
    void test3_S1EqualsBbb() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 3.0, 4.0, "Bbb", "Bbbb");
        assertEquals("Bbb", obj1.test3());
    }

    @Test
    void test3_S1EqualsC() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 3.0, 4.0, "C", "Bbbb");
        assertEquals("Bbbb", obj1.test3());
    }

    @Test
    void test3_EqualsBbbb_() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 3.0, 4.0, "Bbbb ", "Bbbb");
        assertEquals("Bbbb", obj1.test3());
    }

    @Test
    void test3_Equals99_100() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 3.0, 4.0, "99", "100");
        assertEquals("100", obj1.test3());
    }

    @Test
    void test4_EqualsNeg1() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 0, 7.50, "Aaaa", "Bbbb");
        assertEquals(-1, obj1.test4());
    }

    @Test
    void test4_D1Equals168() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 168, 7.50, "Aaaa", "Bbbb");
        assertEquals(-1, obj1.test4());
    }

    @Test
    void test4_D2Equals100() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 40.0, 100, "Aaaa", "Bbbb");
        assertEquals(obj1.test4(), -1);
    }

    @Test
    void test4_D2Equals10() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 40.0, 10, "Aaaa", "Bbbb");
        assertEquals(obj1.test4(), 400);
    }

    @Test
    void test5_EqualsNeg1() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 0, 7.50, "Aaaa", "Bbbb");
        assertEquals(obj1.test5(), -1);
    }

    @Test
    void test5_D1Equals168() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 168.1, 7.50, "Aaaa", "Bbbb");
        assertEquals(obj1.test5(), -1);
    }

    @Test
    void test5_D1Equals40() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 40, 7.50, "Aaaa", "Bbbb");
        assertEquals(obj1.test5(), -1);
    }

    @Test
    void test5_D2Equals100() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 40, 100, "Aaaa", "Bbbb");
        assertEquals(obj1.test5(), -1);
    }

    @Test
    void test5_Equals400() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 40, 10, "Aaaa", "Bbbb");
        assertEquals(obj1.test5(), 400);
    }

    @Test
    void test5_Equals550() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 50, 10, "Aaaa", "Bbbb");
        assertEquals(obj1.test5(), 550);
    }

    @Test
    void test6_S1EqualsNull() {
        Ex2gSample obj1 = new Ex2gSample();
        assertFalse(obj1.test6());
    }

    @Test
    void test6_S1EqualsNotNull() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 3.0, 4.0, "", "Bbbb");
        assertFalse(obj1.test6());
    }

    @Test
    void test6_S1Equals_dddd() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 3.0, 4.0, "dddd", "Bbbb");
        assertFalse(obj1.test6());
    }

    @Test
    void test6_S1Equals_aaaa() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 3.0, 4.0, "aaaa", "Bbbb");
        assertTrue(obj1.test6());
    }

    @Test
    void test6_S1Equals_cccc() {
        Ex2gSample obj1 = new Ex2gSample(1, 2, 3.0, 4.0, "cccc", "Bbbb");
        assertTrue(obj1.test6());
    }
}
