package ro.siit.javaOop2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.time.LocalDate;
import java.util.List;

public class AppTest
{
    @Test
    public void testCorrectAge()
    {
        Student student = new Student("Arifovici", "Albert", "M", LocalDate.parse("2001-07-23"), "5010723123456");
        assertEquals(20,student.getAge());
    }
    @Test
    public void testCorrectName()
    {
        Student student = new Student("Arifovici", "Albert", "M", LocalDate.parse("2001-07-23"), "5010723123456");
        assertEquals("Albert Arifovici",student.getName());
    }
    @Test
    public void testCorrectGender() {

        Student student = new Student("Arifovici", "Albert", "M", LocalDate.parse("2001-07-23"), "5010723123456");
        assertEquals("M", student.getGender());
    }
    @Test
    public void testRetrieveStudentsByAge() {
        Student student1 = new Student("Arifovici", "Albert", "M", LocalDate.parse("2001-07-23"), "5010723123456");
        Student student2 = new Student("Arifovici", "Albert", "M", LocalDate.parse("2008-07-23"), "5080723123456");
        App Lib = new App();
        Lib.addStudent(student1);
        Lib.addStudent(student2);
        List<Student> arr = Lib.retrieveStudentsByAge(20);
        assertEquals("Albert Arifovici", arr.get(0).getName());
    }

}