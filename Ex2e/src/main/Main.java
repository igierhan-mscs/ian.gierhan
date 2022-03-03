package main;

import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        String result = "";

        result = person1.setPersonId(100);
        if (!result.equals("")) System.out.println(result);
        result = person1.setPersonId(1000);
        if (!result.equals("")) System.out.println(result);
        result = person1.setPersonId(101);
        if (!result.equals("")) System.out.println(result);

        result = person1.setFirstName("I");
        if (!result.equals("")) System.out.println(result);
        result = person1.setFirstName("Iiiiiiiiiiiiiiiiii");
        if (!result.equals("")) System.out.println(result);
        result = person1.setFirstName("Ian");
        if (!result.equals("")) System.out.println(result);

        result = person1.setLastName("G");
        if (!result.equals("")) System.out.println(result);
        result = person1.setLastName("Ggggggggggggggggggggggggggggggg");
        if (!result.equals("")) System.out.println(result);
        result = person1.setLastName("Gierhan");
        if (!result.equals("")) System.out.println(result);

        result = person1.setUserName("ian.");
        if (!result.equals("")) System.out.println(result);
        result = person1.setUserName("ian.ggggggggggggggggggggggggggg");
        if (!result.equals("")) System.out.println(result);
        result = person1.setUserName("Administrator");
        if (!result.equals("")) System.out.println(result);
        result = person1.setUserName("ian.gierhan");


        person1.setUpdated();

//        Person person2 = new Person(102, "Angela", "Barbariol", "angela.barbariol");

        System.out.println("Person Id:\t\t" + person1.getPersonId());
        System.out.println("First name:\t\t" + person1.getFirstName());
        System.out.println("Last name:\t\t" + person1.getLastName());
        System.out.println("User name:\t\t" + person1.getUserName());
        System.out.println("Date updated:\t" + person1.getUpdated());
        System.out.println();

/*        System.out.println("Person Id:\t\t" + person2.getPersonId());
        System.out.println("First name:\t\t" + person2.getFirstName());
        System.out.println("Last name:\t\t" + person2.getLastName());
        System.out.println("User name:\t\t" + person2.getUserName());
        System.out.println("Date updated:\t" + person2.getUpdated());
        System.out.println();

        Apartment apartment1 = new Apartment();
        apartment1.setApartmentId(1);
        apartment1.setApartmentNum("A1");
        apartment1.setLocation("Winona");
        apartment1.setSquareFeet(400);
        apartment1.setPrice(500.11);
        apartment1.setUpdated();

        Apartment apartment2 = new Apartment(2, "Red Wing", "B2", 450, 600.11);

        System.out.println(apartment1.toString());
        System.out.println();
        System.out.println(apartment2.toString());
        System.out.println();

        displayTotals(apartment1, apartment2);*/
    }

    public static void displayTotals(Apartment apartment1, Apartment apartment2) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        int totalSqrFeet = apartment1.getSquareFeet() + apartment2.getSquareFeet();
        double totalRevenue = apartment1.getPrice() + apartment2.getPrice();

        System.out.println("Total square feet:\t\t" + totalSqrFeet);
        System.out.println("Total monthly revenue:\t" + currency.format(totalRevenue));

    }
}
