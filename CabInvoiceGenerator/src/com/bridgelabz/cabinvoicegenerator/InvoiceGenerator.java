package com.bridgelabz.cabinvoicegenerator;
import java.util.*;

/**
 * @desc InvoiceGenerator class is responsible for generating invoices based on the rides
 * stored in the RideRepository using the CabService.
 */
public class InvoiceGenerator {
    private RideRepository rideRepository;
    private CabService cabService;

    /**
     * @desc Constructor to initialize the InvoiceGenerator with a RideRepository and CabService.
     *
     * @param rideRepository The repository containing ride data.
     *        cabService     The service managing cabs and customers.
     */
    public InvoiceGenerator(RideRepository rideRepository, CabService cabService) {
        this.rideRepository = rideRepository;
        this.cabService = cabService;
    }

    /**
     * @desc Generates a list of invoices for a specific user based on their rides.
     *
     * @param userId The unique identifier of the user.
     * 
     * @return A list of invoices for the specified user.
     */
    public List<Invoice> generateInvoicesByUserId(String userId) {
        List<Invoice> userInvoices = new ArrayList<>();
        List<Ride> userRides = rideRepository.getRidesByUserId(userId);

        for (Ride ride : userRides) {
            Customer customer = cabService.getCustomerByUserId(userId);
            if (customer != null) {
                Invoice invoice = cabService.generateInvoice(customer, ride.getDistanceTraveled(), ride.getTimeInMinutes(),ride.getRideType());
                userInvoices.add(invoice);
            }
        }

        return userInvoices;
    }
}
