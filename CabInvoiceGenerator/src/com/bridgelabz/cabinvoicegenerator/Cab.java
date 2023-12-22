package com.bridgelabz.cabinvoicegenerator;

/**
 * Cab class represents a taxi cab with information such as cab ID, driver name,
 * total number of rides, total fare, and average fare per ride.
 */
public class Cab {
    private String cabId;
    private String driverName;
    private int totalNumberOfRides;
    private double totalFare;
    private double averageFarePerRide;

    /**
     * Constructor to initialize a Cab with the given cab ID and driver name.
     *
     * @param cabId      The unique identifier for the cab.
     * @param driverName The name of the cab driver.
     */
    public Cab(String cabId, String driverName) {
        this.cabId = cabId;
        this.driverName = driverName;
        this.totalNumberOfRides = 0;
        this.totalFare = 0;
        this.averageFarePerRide = 0;
    }

    /**
     * Gets the cab ID.
     *
     * @return The cab ID.
     */
    public String getCabId() {
        return cabId;
    }

    /**
     * Sets the cab ID.
     *
     * @param cabId The cab ID to set.
     */
    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    /**
     * Gets the driver name.
     *
     * @return The driver name.
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * Sets the driver name.
     *
     * @param driverName The driver name to set.
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * Gets the total number of rides.
     *
     * @return The total number of rides.
     */
    public int getTotalNumberOfRides() {
        return totalNumberOfRides;
    }

    /**
     * Sets the total number of rides.
     *
     * @param totalNumberOfRides The total number of rides to set.
     */
    public void setTotalNumberOfRides(int totalNumberOfRides) {
        this.totalNumberOfRides = totalNumberOfRides;
    }

    /**
     * Gets the total fare earned by the cab.
     *
     * @return The total fare earned.
     */
    public double getTotalFare() {
        return totalFare;
    }

    /**
     * Sets the total fare earned by the cab.
     *
     * @param totalFare The total fare earned to set.
     */
    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    /**
     * Gets the average fare per ride for the cab.
     *
     * @return The average fare per ride.
     */
    public double getAverageFarePerRide() {
        return averageFarePerRide;
    }

    /**
     * Sets the average fare per ride for the cab.
     *
     * @param averageFarePerRide The average fare per ride to set.
     */
    public void setAverageFarePerRide(double averageFarePerRide) {
        this.averageFarePerRide = averageFarePerRide;
    }
}
