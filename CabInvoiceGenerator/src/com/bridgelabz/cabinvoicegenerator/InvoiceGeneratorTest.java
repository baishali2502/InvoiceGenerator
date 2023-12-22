package com.bridgelabz.cabinvoicegenerator;

import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

/*@desc:These test cases cover generating invoices for normal and premium rides, 
 *      handling multiple rides, 
 *      and ensuring that the correct details are present in the generated invoices.
 *      
*/
public class InvoiceGeneratorTest {

	/**
	 * @desc Test generating an invoice for a normal ride.
	 * @params CabService, RideRepository, InvoiceGenerator, Customer, Cab
	 * @return The generated invoice should have the correct customer, total amount,
	 *         and other details.
	 */
	@Test
	public void testGenerateInvoicesForNormalRide() {
		// Arrange
		RideRepository rideRepository = new RideRepository();
		CabService cabService = new CabService(rideRepository);
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator(rideRepository, cabService);

		Customer customer = new Customer("user123", "John Doe");
		Cab cab = new Cab("cab123", "Driver1");
		cabService.registerCustomer(customer);
		cabService.bookCab(customer, cab);

		// Act
		cabService.addRide("user123", 10.0, 30, RideType.NORMAL);
		List<Invoice> invoices = invoiceGenerator.generateInvoicesByUserId("user123");

		// Assert
		assertEquals(1, invoices.size());
		Invoice invoice = invoices.get(0);
		assertEquals(customer, invoice.getCustomer());

		assertEquals(10.0 * 10 + 30 * 1, invoice.getTotalAmount(), 0.01);

	}

	/**
	 * @desc Test generating an invoice for a premium ride.
	 * @params CabService, RideRepository, InvoiceGenerator, Customer, Cab
	 * @return The generated invoice should have the correct customer, total amount,
	 *         and other details.
	 */
	@Test
	public void testGenerateInvoicesForPremiumRide() {
		// Arrange
		RideRepository rideRepository = new RideRepository();
		CabService cabService = new CabService(rideRepository);
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator(rideRepository, cabService);

		Customer customer = new Customer("user456", "Harry Doe");
		Cab cab = new Cab("cab456", "Driver2");
		cabService.registerCustomer(customer);
		cabService.bookCab(customer, cab);

		// Act
		cabService.addRide("user456", 10.0, 15, RideType.PREMIUM);
		List<Invoice> invoices = invoiceGenerator.generateInvoicesByUserId("user456");

		// Assert
		assertEquals(1, invoices.size());
		Invoice invoice = invoices.get(0);
		assertEquals(customer, invoice.getCustomer());

		assertEquals(180.0, invoice.getTotalAmount(), 0.01);
	}

	/**
	 * @desc Test generating invoices for multiple rides.
	 * @params CabService, RideRepository, InvoiceGenerator, Customer, Cab
	 * @return The generated invoices should have the correct customers, total
	 *         amounts, and other details.
	 */
	@Test
	public void testGenerateInvoicesForMultipleRides() {
		// Arrange
		RideRepository rideRepository = new RideRepository();
		CabService cabService = new CabService(rideRepository);
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator(rideRepository, cabService);

		Customer customer = new Customer("user789", "Bob Johnson");
		Cab cab = new Cab("cab789", "Driver3");
		cabService.registerCustomer(customer);
		cabService.bookCab(customer, cab);

		// Act
		cabService.addRide("user789", 8.0, 15, RideType.NORMAL);
		cabService.addRide("user789", 12.0, 20, RideType.PREMIUM);
		List<Invoice> invoices = invoiceGenerator.generateInvoicesByUserId("user789");

		// Assert
		assertEquals(2, invoices.size());

	}

	/**
	 * @desc Test generating invoices when there are no rides.
	 * @params CabService, RideRepository, InvoiceGenerator, Customer, Cab
	 * @return No invoices should be generated.
	 */
	@Test
	public void testGenerateInvoicesForNoRides() {
		// Arrange
		RideRepository rideRepository = new RideRepository();
		CabService cabService = new CabService(rideRepository);
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator(rideRepository, cabService);

		Customer customer = new Customer("user000", "Alice Doe");
		Cab cab = new Cab("cab000", "Driver4");
		cabService.registerCustomer(customer);
		cabService.bookCab(customer, cab);

		// Act
		List<Invoice> invoices = invoiceGenerator.generateInvoicesByUserId("user000");

		// Assert
		assertEquals(0, invoices.size());
	}

}
