package ro.siit.javaOop2;

import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String id;

    public Logger logger = Logger.getLogger(App.class.getName());

    public Student(String firstName, String lastName, String gender, LocalDate dateOfBirth, String id) {

        if (firstName == "" || lastName == "") {
            logger.log(Level.SEVERE, "Incorrect format for First Name or/and Last Name");
            throw new IllegalArgumentException("Incorrect format for First Name or/and Last Name");
        } else {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        if (!(gender.contains("M") || gender.contains("m") || gender.contains("male") || gender.contains("F") || gender.contains("f") || gender.contains("female"))) {
            logger.log(Level.SEVERE, "Invalid gender format");
            throw new IllegalArgumentException("Invalid gender format");
        } else {
            this.gender = gender;
        }
        if (!((dateOfBirth.getYear() > (LocalDate.parse("1900-01-01").getYear())) || (dateOfBirth.getYear() < (LocalDate.parse("2004-01-01").getYear())))) {
            logger.log(Level.SEVERE, "Incorrect format for birthdate");
            throw new IllegalArgumentException("Incorrect format for birthdate");
        } else {
            this.dateOfBirth = dateOfBirth;
        }
        this.id = id;
    }

    public String getName() {
        return this.lastName + " " + this.firstName;
    }

    public String getId() {
        return this.id;
    }

    public String getGender() {
        return this.gender;
    }

    public int getAge() {
        Period period = Period.between(dateOfBirth, LocalDate.now());
        return period.getYears();
    }
}