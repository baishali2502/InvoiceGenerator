package com.bridgelabz.cabinvoicegenerator;
import java.util.*;

public class Main {

	public static void main(String[] args) 
	{
        // Create instances of necessary classes
        RideRepository rideRepository = new RideRepository();
        CabService cabService = new CabService(rideRepository);
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(rideRepository, cabService);

        // Register a customer
        Customer tom = new Customer("user345", "Tom Holland");
        cabService.registerCustomer(tom);

        // Book a cab for the customer
        Cab cab = new Cab("cab345", "Driver2");
        cabService.bookCab(tom, cab);

        // Add some rides for the customer
        cabService.addRide("user345", 5.0, 20, RideType.NORMAL);
       
        // Generate and display invoices for the customer
        List<Invoice> invoices1 = invoiceGenerator.generateInvoicesByUserId("user345");
       
        // Displaying the generated invoices
        for (Invoice invoice : invoices1 ) {

            System.out.println("Invoice for Customer: " + invoice.getCustomer().getName());
            System.out.println("Total Amount: " + invoice.getTotalAmount());
            System.out.println("Total Number of Rides: " + invoice.getTotalNumberOfRides());
            System.out.println("Average Fare per Ride: " + invoice.getAverageFarePerRide());
            System.out.println("-----");
        }
     
    }

}
