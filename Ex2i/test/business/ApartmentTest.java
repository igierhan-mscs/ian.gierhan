package business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentTest {
    Apartment apt = null;

    @BeforeEach
    void setUp() {
        this.apt = new Apartment();
    }

    @Test
    void setApartmentIdBelowRange() {
        assertNotEquals(this.apt.setApartmentId(99), "");
    }

    @Test
    void setApartmentIdMinimum() {
        assertEquals(this.apt.setApartmentId(100), "");
    }

    @Test
    void setApartmentIdMaximum() {
        assertEquals(this.apt.setApartmentId(199), "");
    }

    @Test
    void setApartmentAboveRange() {
        assertNotEquals(this.apt.setApartmentId(200), "");
    }

    @Test
    void setApartmentNumNull() {
        assertNotEquals(this.apt.setApartmentNum(null), "");
    }

    @Test
    void setApartmentNumEmptyString() {
        assertNotEquals(this.apt.setApartmentNum(""), "");
    }

    @Test
    void setApartmentNumMinLength() {
        assertEquals(this.apt.setApartmentNum("1"), "");
    }

    @Test
    void setApartmentNumMaxLength() {
        assertEquals(this.apt.setApartmentNum("1111"), "");
    }

    @Test
    void setApartmentNumTooLong() {
        assertNotEquals(this.apt.setApartmentNum("11111"), "");
    }

    @Test
    void setSquareFeetTooSmall() {
        assertNotEquals(this.apt.setSquareFeet(199), "");
    }

    @Test
    void setSquareFeetMinimum() {
        assertEquals(this.apt.setSquareFeet(200), "");
    }

    @Test
    void setSquareFeetMaximum() {
        assertEquals(this.apt.setSquareFeet(2000), "");
    }

    @Test
    void setSquareFeetTooLarge() {
        assertNotEquals(this.apt.setSquareFeet(2001), "");
    }

    @Test
    void setBathroomsToLow() {
        assertNotEquals(this.apt.setBathrooms(0), "");
    }

    @Test
    void setBathroomsMinimum() {
        assertEquals(this.apt.setBathrooms(1), "");
    }

    @Test
    void setBathroomsMaximum() {
        assertEquals(this.apt.setBathrooms(3), "");
    }

    @Test
    void setBathroomsToHigh() {
        assertNotEquals(this.apt.setBathrooms(4), "");
    }

    @Test
    void setPriceSmallApt() {
        this.apt.setSquareFeet(200);
        this.apt.setBathrooms(1);
        this.apt.setPrice();
        assertEquals(this.apt.getPrice(), 320.0);
    }

    @Test
    void setPriceMediumSmallApt() {
        this.apt.setSquareFeet(400);
        this.apt.setBathrooms(1);
        this.apt.setPrice();
        assertEquals(this.apt.getPrice(), 560.0);
    }

    @Test
    void setPriceMediumLargeApt() {
        this.apt.setSquareFeet(600);
        this.apt.setBathrooms(2);
        this.apt.setPrice();
        assertEquals(this.apt.getPrice(), 820.0);
    }

    @Test
    void setPriceLargeApt() {
        this.apt.setSquareFeet(1000);
        this.apt.setBathrooms(3);
        this.apt.setPrice();
        assertEquals(this.apt.getPrice(), 1200.0);
    }

    @Test
    void getAdministrator() {
        Person person = new Person(101, "First Name", "Last Name", "User Name");
        this.apt.setAdministrator(person);
        assertEquals(this.apt.getAdministrator().getPersonId(), 101);
    }

    @Test
    void getRenter() {
        Person person = new Person(101, "First Name", "Last Name", "User Name");
        this.apt.setRenter(person);
        assertEquals(this.apt.getRenter().getPersonId(), 101);
    }
}