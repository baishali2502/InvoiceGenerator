package com.bridgelabz.cabinvoicegenerator;

/**
 * Ride class represents a ride taken by a user, storing information such as
 * user ID, distance traveled, time in minutes, and ride type.
 */
public class Ride 
{
	private String userId;
	private double distanceTraveled;
	private int timeInMinutes;
	private RideType rideType;

	/**
	 * @desc Constructor to initialize a Ride with user ID, distance traveled, time in
	 *       minutes, and ride type.
	 *
	 * @param userId           The unique identifier for the user.
	 *        distanceTraveled The distance traveled during the ride (in
	 *                         kilometers).
	 *        timeInMinutes    The duration of the ride (in minutes).
	 *        rideType         The type of ride (NORMAL or PREMIUM).
	 */
	public Ride(String userId, double distanceTraveled, int timeInMinutes, RideType rideType) {
		this.userId = userId;
		this.distanceTraveled = distanceTraveled;
		this.timeInMinutes = timeInMinutes;
		this.rideType = rideType;
	}

	/**
	 * @desc Gets the user ID associated with the ride.
	 *
	 * @return The user ID associated with the ride.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @desc Gets the distance traveled during the ride.
	 *
	 * @return The distance traveled during the ride (in kilometers).
	 */
	public double getDistanceTraveled() {
		return distanceTraveled;
	}

	/**
	 * @desc Gets the duration of the ride.
	 *
	 * @return The duration of the ride (in minutes).
	 */
	public int getTimeInMinutes() {
		return timeInMinutes;
	}

	/**
	 * @desc Gets the type of ride (NORMAL or PREMIUM).
	 *
	 * @return The type of ride (NORMAL or PREMIUM).
	 */
	public RideType getRideType() {
		return rideType;
	}
}
