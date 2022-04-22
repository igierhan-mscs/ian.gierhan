package db;

import business.Apartment;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class ApartmentTextFile {
    private static Path apartmentsPath = Paths.get("Ex3d\\apartments.txt");;
    private static File apartmentsFile = apartmentsPath.toFile();;
    private static final String FIELD_SEP = "\t";

//    public ApartmentTextFile() {
//        this.apartmentsPath = Paths.get("Ex3d\\apartments.txt");
//        this.apartmentsFile = apartmentsPath.toFile();
//    }

    public static int saveAll(List<Apartment> apartments) {
        int count = 0;
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(apartmentsFile)))) {
            for (Apartment apt : apartments) {
                out.print(Integer.toString(apt.getApartmentId()) + FIELD_SEP);
                out.print(apt.getApartmentNum() + FIELD_SEP);
                out.print(Integer.toString(apt.getSquareFeet()) + FIELD_SEP);
                out.print(Integer.toString(apt.getBathrooms()) + FIELD_SEP);
                out.print(Double.toString(apt.getPrice()) + FIELD_SEP);
                out.println(apt.getUpdated() + FIELD_SEP);
            }
            count = apartments.size();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return count;
    }

    public static List<Apartment> getAll(List<Apartment> apartments) {
        if (Files.exists(apartmentsPath)) {
            try (BufferedReader in = new BufferedReader(
                    new FileReader(apartmentsFile))) {
                //Read apartments from file into ArrayList
                String line = in.readLine();
                while (line != null) {
                    String[] fields = line.split(FIELD_SEP);
                    int apartmentId = Integer.parseInt(fields[0]);
                    String apartmentNum = fields[1];
                    int squareFeet = Integer.parseInt(fields[2]);
                    int bathrooms = Integer.parseInt(fields[3]);
                    double price = Double.parseDouble(fields[4]);
                    LocalDateTime updated = LocalDateTime.parse(fields[5]);
                    apartments.add(new Apartment(apartmentId, apartmentNum, squareFeet, bathrooms, price, updated));
                    line = in.readLine();
                }
            }
            catch (IOException e) {
                System.out.println(e);
                return null;
            }
        }
        else {
            System.out.println(apartmentsPath.toAbsolutePath() + "doesn't exist.");
            return null;
        }
        return apartments;
    }

}
