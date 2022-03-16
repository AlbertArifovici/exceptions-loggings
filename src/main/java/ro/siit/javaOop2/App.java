package ro.siit.javaOop2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class App {
    static final Logger logger = Logger.getLogger(App.class.getName());
    List<Student> students = new ArrayList<Student>();

    public void addStudent(Student student) {
        try {
            students.add(student);
        } catch (IllegalArgumentException e) {
            //nothing to do
        } catch (IndexOutOfBoundsException e) {
            //nothing to do
        }
    }

    public void deleteStudent(String id) {
        if (id == "") {
            throw new IllegalArgumentException("Argument ID is empty");
        } else {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId().equals(id)) {
                    students.remove(i);
                }
            }
        }
    }

    public List<Student> retrieveStudentsByAge(int age) {
        List<Student> tempList = new ArrayList<Student>();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAge() == age) {
                tempList.add(students.get(i));
            }
        }
        return tempList;
    }

    public static void main(String[] args) {
        logger.info("Started app");
        App Lib = new App();
        Student studentA = new Student("Albert", "Arifovici", "M", LocalDate.parse("2001-07-23"), "5010723123456");
        Student studentB = new Student("Elias", "Arifovici", "M", LocalDate.parse("2001-07-24"), "5010724123456");
        Lib.addStudent(studentA);
        Lib.addStudent(studentB);
        System.out.println(studentA.getName()); //SHOULD PRINT Arifovici Albert
        System.out.println(studentB.getName()); //SHOULD PRINT Arifovici Elias
        Lib.deleteStudent("5010723123456"); //SHOULD DELETE Arifovici Albert
        List<Student> arr = Lib.retrieveStudentsByAge(20);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).getName()); //SHOULD PRINT Arifovici Elias
        }
        logger.info("Finished app");
    }
}