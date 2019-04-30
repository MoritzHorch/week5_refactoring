package main;

class Rental {
    private Movie movie;
    private int daysRented;
    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }

    private double getCharge() {
        double charge = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                charge += 2;
                if (each.getDaysRented() > 2)
                    charge += (each.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                charge += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                charge += 1.5;
                if (each.getDaysRented() > 3)
                    charge += (each.getDaysRented() - 3) * 1.5;
                break;
            default:
                charge = 0;
                break;
        }
        return charge;
    }
}