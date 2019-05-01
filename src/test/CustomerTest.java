
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;
    private String customerName;

    @BeforeEach
    void setUp() {
        customerName = "Testname";
        customer = new Customer(customerName);
    }

    @Test
    void addRental() {
        Rental rentalToAdd = new Rental(new Movie("Movie title", Movie.CHILDRENS), 3);
        customer.addRental(rentalToAdd);
        assertTrue(customer.getRentals().contains(rentalToAdd));
    }

    @Test
    void getName() {
        assertEquals(customerName, customer.getName());
    }

    @Test
    void statement() {
        // Test if contains name
        assertTrue(customer.statement().contains("for " + customerName));

        // Test if amount is correct
        customer.addRental(new Rental(new Movie("testmovie 1", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("testmovie 2", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("testmovie 3", Movie.NEW_RELEASE), 2));

        assertTrue(customer.statement().contains("\t" + "\t" + 3 + "\t" + 1.5 + "\n"));
        assertTrue(customer.statement().contains("\t" + "\t" + 2 + "\t" + 2.0 + "\n"));
        assertTrue(customer.statement().contains("\t" + "\t" + 2 + "\t" + 6.0 + "\n"));

        // Test if total amount is correct
        assertTrue(customer.statement().contains("Amount owed is " + 9.5));

        // Test if frequent renter points are correct
        assertTrue(customer.statement().contains("earned 4 frequent"));
    }
}