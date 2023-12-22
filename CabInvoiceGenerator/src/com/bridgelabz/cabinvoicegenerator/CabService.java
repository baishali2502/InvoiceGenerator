package com.bridgelabz.cabinvoicegenerator;
import java.util.*;


/**
 * @desc CabService class handles the booking of cabs, registering customers,
 *       adding rides, and generating invoices for a cab service.
 */
public class CabService
{
	private Map<String, Customer> customers;
	private List<Invoice> invoices;
	private RideRepository rideRepository;

	/**
	 * @desc Constructor for CabService class.
	 *
	 * @param rideRepository The repository to manage rides.
	 * 
	 */
	public CabService(RideRepository rideRepository) 
	{
		this.customers = new HashMap<>();
		this.invoices = new ArrayList<>();
		this.rideRepository = rideRepository;
	}

	/**
	 * @desc Registers a new customer in the cab service.
	 *
	 * @param customer The customer to be registered.
	 * 
	 * @return void
	 */
	public void registerCustomer(Customer customer) 
	{
		customers.put(customer.getCustomerId(), customer);
	}

	/**
	 * @desc Books a cab for a customer.
	 *
	 * @param customer The customer booking the cab. cab The cab to be booked.
	 * 
	 * @return void
	 */
	public void bookCab(Customer customer, Cab cab) 
	{
		customer.setCab(cab);
	}

	/**
	 * @desc Adds a ride for a customer and generates an invoice based on the ride
	 *       details.
	 *
	 * @param userId  The user ID associated with the ride. 
	 *        distanceTraveled  The distance traveled during the ride (in kilometers).
	 *        timeInMinutes  The duration of the ride (in minutes). 
	 *        rideType  The type of ride (NORMAL or PREMIUM).
	 * 
	 * @return void
	 */
	public void addRide(String userId, double distanceTraveled, int timeInMinutes, RideType rideType) 
	{
        Ride ride = new Ride(userId, distanceTraveled, timeInMinutes, rideType);
        rideRepository.addRide(ride);

        Customer customer = getCustomerByUserId(userId);

        if (customer != null) {
            Invoice invoice = generateInvoice(customer,distanceTraveled,timeInMinutes ,rideType);

            invoices.add(invoice);
            
            updateCustomerStatistics(customer, ride, invoice);
        }
    }
	/**
     * @desc Updates customer statistics based on the ride and invoice.
     *
     * @param customer The customer associated with the ride.
     *        ride     The ride details.
     *        invoice  The generated invoice.
     */
	private void updateCustomerStatistics(Customer customer, Ride ride, Invoice invoice) 
	{
	    // Update total number of rides and total fare for the customer
	    customer.setTotalNumberOfRides(customer.getTotalNumberOfRides() + 1);
	    customer.setTotalFare(customer.getTotalFare());

	    // Update average fare per ride for the customer
	    if (customer.getTotalNumberOfRides() > 0) {
	    	
	        customer.setAverageFarePerRide((customer.getTotalFare())/ customer.getTotalNumberOfRides());
	    }

	    // Update total number of rides and total fare for the customer's cab
	    Cab cab = customer.getCab();
	    cab.setTotalNumberOfRides(cab.getTotalNumberOfRides() + 1);
	    cab.setTotalFare(cab.getTotalFare());

	    // Update average fare per ride for the customer's cab
	    if (cab.getTotalNumberOfRides() > 0) {
	        cab.setAverageFarePerRide((cab.getTotalFare()) / cab.getTotalNumberOfRides());
	    }
	}

	/**
	 * @desc Generates an invoice for a ride based on the ride details.
	 *
	 * @param customer The customer associated with the ride. ride The ride details
	 *                 including distance, time, and ride type.
	 * @return An invoice for the ride.
	 */
	public Invoice generateInvoice(Customer customer, double distanceTraveled, int timeInMinutes, RideType rideType) {
	    double costPerKilometer=0;
	    double costPerMinute=0;
	    double minimumFare=0;

	    if (rideType == RideType.PREMIUM) {
	        costPerKilometer = 15;
	        costPerMinute = 2;
	        minimumFare = 20;
	    } else {
	        costPerKilometer = 10;  // Default rates for normal rides
	        costPerMinute = 1;
	        minimumFare = 5;
	    }

	    double totalAmount = Math.max(distanceTraveled * costPerKilometer + timeInMinutes * costPerMinute, minimumFare);
	    customer.setTotalFare(totalAmount);
	    Invoice invoice = new Invoice();
	    invoice.setCustomer(customer);
	    invoice.setTotalAmount(totalAmount);

	    return invoice;
	}



	/**
	 * @desc Retrieves a customer based on the user ID.
	 *
	 * @param userId The user ID for which to retrieve the customer.
	 * @return The customer associated with the given user ID, or null if not found.
	 */
	public Customer getCustomerByUserId(String userId) 
	{
		return customers.get(userId);
	}
	
}
