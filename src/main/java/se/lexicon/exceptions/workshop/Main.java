package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.Exceptions.DuplicateNameException;
import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

    public static void main(String[] args) {

        try {
            List<String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
            List<String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();
            List<String> lastNames = CSVReader_Writer.getLastNames();

            NameService nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);

            System.out.println("\n -----------------------------------------\n");

            Person test = nameService.getNewRandomPerson();
            System.out.println(test);

            System.out.println("\n -----------------------------------------\n");

            try {
                nameService.addLastName("Juansson");
                System.out.println("Last name added successfully.");
            } catch (DuplicateNameException e) {
                System.err.println("Error: " + e.getMessage());
            }


            try {
                nameService.addMaleFirstName("John");
                System.out.println("First name added successfully.");
            } catch (DuplicateNameException e) {
                System.err.println("Error: " + e.getMessage());
            }


            try {
                nameService.addFemaleFirstName("Johanna");
                System.out.println("First name added successfully.");
            } catch (DuplicateNameException e) {
                System.err.println("Error: " + e.getMessage());
            }

            System.out.println(CSVReader_Writer.getMaleFirstNames());

            System.out.println("\n -----------------------------------------\n");

            System.out.println(CSVReader_Writer.getFemaleFirstNames());

            System.out.println("\n -----------------------------------------\n");

            System.out.println(CSVReader_Writer.getLastNames());

            System.out.println("\n -----------------------------------------\n");



        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}


