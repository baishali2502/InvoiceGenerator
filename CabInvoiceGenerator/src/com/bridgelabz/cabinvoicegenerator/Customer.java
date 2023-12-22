package com.bridgelabz.cabinvoicegenerator;

/**
 * @desc Customer class represents a customer using the cab service, storing customer details,
 * associated cab, and ride statistics.
 */
public class Customer {
    private String customerId;
    private String name;
    private Cab cab;

    // Additional properties to track rides
    private int totalNumberOfRides;
    private double totalFare;
    private double averageFarePerRide;

    /**
     * @desc Constructor to initialize a Customer with the given customer ID and name.
     *
     * @param customerId The unique identifier for the customer.
     * @param name       The name of the customer.
     */
    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.totalNumberOfRides = 0;
        this.totalFare = 0;
        this.averageFarePerRide = 0;
    }

    /**
     * @desc Gets the customer ID.
     *
     * @return The customer ID.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @desc Sets the customer ID.
     *
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @desc Gets the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * @desc Sets the name of the customer.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @desc Gets the associated cab for the customer.
     *
     * @return The associated cab.
     */
    public Cab getCab() {
        return cab;
    }

    /**
     * @desc Sets the associated cab for the customer.
     *
     * @param cab The cab to set.
     */
    public void setCab(Cab cab) {
        this.cab = cab;
    }

    // Additional methods to update ride statistics

    /**
     * @desc Gets the total number of rides for the customer.
     *
     * @return The total number of rides.
     */
    public int getTotalNumberOfRides() {
        return totalNumberOfRides;
    }

    /**
     * @desc Sets the total number of rides for the customer.
     *
     * @param totalNumberOfRides The total number of rides to set.
     */
    public void setTotalNumberOfRides(int totalNumberOfRides) {
        this.totalNumberOfRides = totalNumberOfRides;
    }

    /**
     * @desc Gets the total fare spent by the customer.
     *
     * @return The total fare spent.
     */
    public double getTotalFare() {
        return totalFare;
    }

    /**
     * @desc Sets the total fare spent by the customer.
     *
     * @param totalFare The total fare to set.
     */
    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    /**
     * @desc Gets the average fare per ride for the customer.
     *
     * @return The average fare per ride.
     */
    public double getAverageFarePerRide() {
        return averageFarePerRide;
    }

    /**
     * @desc Sets the average fare per ride for the customer.
     *
     * @param averageFarePerRide The average fare per ride to set.
     */
    public void setAverageFarePerRide(double averageFarePerRide) {
        this.averageFarePerRide = averageFarePerRide;
    }
}