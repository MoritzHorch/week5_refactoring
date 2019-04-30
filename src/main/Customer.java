package main;

import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + getTotalAmount() + "\n";
        }
        //add footer lines
        result += "Amount owed is " + getTotalAmount() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private double getTotalAmount() {
        double charge = 0;
        Enumeration enum_rentals = rentals.elements();

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            charge += each.getCharge();
        }
        return charge;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentals_enum = rentals.elements();
        while (rentals_enum.hasMoreElements()) {
            Rental each = (Rental) rentals_enum.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }



}
    