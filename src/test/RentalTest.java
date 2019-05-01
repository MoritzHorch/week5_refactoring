

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class RentalTest {
    private Rental rental;
    private Movie movie;
    private int daysRented = 3;

    @BeforeEach
    void setUp() {
        movie = new Movie("Movietitle", Movie.NEW_RELEASE);
        rental = new Rental(movie, daysRented);
    }

    @Test
    void getDaysRented() {
        assertEquals(daysRented, rental.getDaysRented());
    }

    @Test
    void getMovie() {
        assertEquals(movie, rental.getMovie());
    }
}