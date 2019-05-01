
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    private Movie movie;
    private String title;
    private int priceCode;

    @BeforeEach
    void setUp() {
        title = "Movietitle";
        priceCode = Movie.NEW_RELEASE;
        movie = new Movie(title, priceCode);
    }

    @Test
    void getPriceCode() {
        assertEquals(priceCode, movie.getPriceCode());
    }

    @Test
    void getTitle() {
        assertEquals(title, movie.getTitle());
    }

    @Test
    void setPriceCode() {
        movie.setPriceCode(priceCode);
        assertEquals(priceCode, movie.getPriceCode());
    }
}