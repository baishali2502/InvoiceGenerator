package com.bridgelabz.cabinvoicegenerator;

/**
 * @desc Invoice class represents the billing details for a customer including the total
 * number of rides, total fare, and average fare per ride.
 */
public class Invoice 
{
    private Customer customer;
    private int totalNumberOfRides;
    private double totalFare;
    private double averageFarePerRide;
    
    
    /**
     * @desc Gets the customer associated with the invoice.
     *
     * @return The customer associated with the invoice.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @desc Sets the customer associated with the invoice.
     *
     * @param customer The customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @desc Gets the total amount (total fare) for the invoice.
     *
     * @return The total amount (total fare) for the invoice.
     */
    public double getTotalAmount() {
        return customer.getTotalFare();  // Assuming the totalAmount is the same as the totalFare in your case
    }

    /**
     * @desc Sets the total amount (total fare) for the invoice.
     *
     * @param totalAmount The total amount (total fare) to set.
     */
    public void setTotalAmount(double totalAmount) {
        totalFare = customer.getTotalFare();
    }

    /**
     * @desc Gets the total number of rides for the invoice.
     *
     * @return The total number of rides for the invoice.
     */
    public int getTotalNumberOfRides() {
        return customer.getTotalNumberOfRides();
    }

    /**
     * @desc Sets the total number of rides for the invoice.
     *
     * @param totalNumberOfRides The total number of rides to set.
     */
    public void setTotalNumberOfRides(int totalNumberOfRides) {
        totalNumberOfRides = customer.getTotalNumberOfRides();
    }

    /**
     * @desc Gets the total fare for the invoice.
     *
     * @return The total fare for the invoice.
     */
    public double getTotalFare() {
        return customer.getTotalFare();
    }

    /**
     * @desc Sets the total fare for the invoice.
     *
     * @param totalFare The total fare to set.
     */
    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    /**
     * @desc Gets the average fare per ride for the invoice.
     *
     * @return The average fare per ride for the invoice.
     */
    public double getAverageFarePerRide() {
        return customer.getAverageFarePerRide();
    }

    /**
     * @desc Sets the average fare per ride for the invoice.
     *
     * @param averageFarePerRide The average fare per ride to set.
     */
    public void setAverageFarePerRide(double averageFarePerRide) {
        averageFarePerRide = customer.getAverageFarePerRide();
    }
}
