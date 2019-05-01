
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
        assertTrue(customer.statement().startsWith("Rental Record for " + customer.getName()) && customer.statement().endsWith("frequent renter points"));
    }
}