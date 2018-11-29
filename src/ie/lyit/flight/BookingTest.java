package ie.lyit.flight;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BookingTest {
	
	// Class to test
	private Booking b1;
	
	// variables needed to create booking object
	private Flight f1;
	private Flight f2;
	private ArrayList<Passenger> list1;

	// test passenger to add to array list and to test find passenger method
	private Passenger p1;
	
	@Before
	public void setUp() throws Exception {
		// test passenger
		p1 = new Passenger("Mr", "Sean", "Toman", 19, 12, 1992, 2, true);
		
		// Create two flights for Booking constructor
		f1 = new Flight("1", "Donegal", "Dublin", 19, 11, 2018, 12, 40, 15.99);
		f2 = new Flight("2", "Dublin", "Cork", 18, 11, 2018, 10, 25, 14.99);
		
		// Arralist with one passenger
		list1 = new ArrayList<>();
		list1.add(p1);
		
		b1 = new Booking(f1, f2, list1); // pass created flights and arraylist to create Booking object
	}

	@Test
	public void testBookingFlightFlightArrayListOfPassenger() {
		assertEquals(b1.getOutbound(), f1);
		assertEquals(b1.getInbound(), f2);
		assertEquals(b1.getPassengers(), list1);
		assertEquals(b1.getPassengers().isEmpty(), false);
		assertEquals(b1.getPassengers().size(), 1);
	}

	@Test
	public void testSetOutbound() {
		//assertEquals(b1.getOutbound().getFlightNumber(), "1");
		Flight f3 = new Flight("3", "Belfast", "Dublin", 20, 11, 2018, 11, 30, 16.99);
		b1.setOutbound(f3);
		assertEquals(b1.getOutbound(), f3);
	}

	@Test
	public void testSetInbound() {
		Flight f4 = new Flight("4", "Dublin", "London", 21, 11, 2018, 11, 45, 17.99);
		b1.setInbound(f4);
		assertEquals(b1.getInbound(), f4);
		//b1.setInbound(new Flight("4", "Dublin", "London", 21, 11, 2018, 11, 45, 17.99));
		//assertEquals(b1.getInbound().getFlightNumber(), "4");
	}

	@Test
	public void testSetPassengers() {
		ArrayList<Passenger> passTest = new ArrayList<>();
		passTest.add(new Passenger("Mr", "Ciaran", "Toman", 26, 7, 1989, 1, false));
		b1.setPassengers(passTest);
		assertEquals(b1.getPassengers(), passTest);
	}

	@Test
	public void testSetTotalPrice() {
		b1.setTotalPrice();
		assertEquals(b1.getTotalPrice(), 30.98, 0);
	}

	@Test
	public void testToString() {
		System.out.println(b1);
	}

	@Test
	public void testFindPassenger() {
		assertEquals(b1.findPassenger(p1), true);
	}

	@Test
	public void testCalculatePrice() {
		b1.calculatePrice();
		assertEquals(b1.getTotalPrice(), 30.98, 0);
	}

}
