package com.bridgelabz.cabinvoicegenerator;
import java.util.*;

/**
 * @desc RideRepository class manages a collection of rides and provides methods to add rides
 * and retrieve rides based on user ID.
 */
public class RideRepository {
    private List<Ride> rides;

    /**
     * @desc Constructor to initialize a RideRepository with an empty list of rides.
     */
    public RideRepository() {
        this.rides = new ArrayList<>();
    }

    /**
     * @desc Adds a ride to the repository.
     *
     * @param ride The ride to add to the repository.
     * 
     * @return void
     */
    public void addRide(Ride ride) {
        rides.add(ride);
    }

    /**
     * @desc Retrieves a list of rides for a specific user based on their user ID.
     *
     * @param userId The unique identifier of the user.
     * 
     * @return A list of rides for the specified user.
     */
    public List<Ride> getRidesByUserId(String userId) {
        List<Ride> userRides = new ArrayList<>();
        for (Ride ride : rides) {
            if (ride.getUserId().equals(userId)) {
                userRides.add(ride);
            }
        }
        return userRides;
    }
}
