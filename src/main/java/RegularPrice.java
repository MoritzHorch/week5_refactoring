
public class RegularPrice implements Price {
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    public double getCharge(int daysRented) {
        if (daysRented > 3) {
            return (daysRented - 3) * 2;
        }

        return 2;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
