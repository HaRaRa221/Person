import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PersonTest {
    Person p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        p1 = new Person("00000A", "Bob", "Tester1", "Mr.", 1955);
        p2= new Person("00000B", "Sally", "Tester2", "Ms.", 1975);
        Person.setIDseed(0);
        p3 = new Person("Bob", "Tester3", "Dr.", 1960);
        p4 = new Person("Sally", "Tester3", "Mrs.", 1965);
        p5 = new Person("Fred", "Tester5", "Phd.", 1970);
        p6 = new Person("Cindy", "Tester6", "Dr.", 1975);

    }

    @Test
    void getIDseed() {
        assertEquals(4, Person.getIDseed());
    }

    @Test
    void setID() {
        p1.setID("00000B");
        assertEquals("00000B", p1.getID());
    }

    @Test
    void setfName() {
        p1.setfName("Sally");
        assertEquals("Sally", p1.getfName());
    }

    @Test
    void setlName() {
        p1.setlName("Tester2");
        assertEquals("Tester2", p1.getlName());
    }

    @Test
    void setTitle() {
        p1.setTitle("Dr.");
        assertEquals("Dr.", p1.getTitle());
    }

    @Test
    void setYOB() {
        p1.setYOB(1975);
        assertEquals(1975, p1.getYOB());
    }

    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
        p1.setID("00000B");
        p1.setfName("Sally");
        p1.setlName("Tester2");
        p1.setTitle("Ms.");
        p1.setYOB(1975);
        assertEquals(true, p1.equals(p2));
    }
}