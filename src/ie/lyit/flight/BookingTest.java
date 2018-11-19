package ie.lyit.flight;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BookingTest {
	
	private Booking b1;
	private Booking b2;

	@Before
	public void setUp() throws Exception {
		// default constructor
		b1 = new Booking();
		
		// Constructor with flights and one passenger in array list
		Flight f1 = new Flight("1", "Donegal", "Dublin", 19, 11, 2018, 12, 40, 15.99);
		Flight f2 = new Flight("2", "Dublin", "Cork", 18, 11, 2018, 10, 25, 14.99);
		ArrayList<Passenger> p1 = new ArrayList<>();
		p1.add(new Passenger("Mr", "Sean", "Toman", 19 ,12 ,1992, 2, true));
		b2 = new Booking(f1, f2, p1); // pass created flights and arraylist to booking constructor
	}

	@Test
	public void testBookingFlightFlightArrayListOfPassenger() {
		assertEquals(b2.getOutbound().getFlightNumber(), "1");
		assertEquals(b2.getInbound().getFlightNumber(), "2");
		assertEquals(b2.getPassengers().isEmpty(), false);
		assertEquals(b2.getPassengers().size(), 1);
	}

	@Test
	public void testSetOutbound() {
		b2.setOutbound(new Flight("3", "Belfast", "Dublin", 20, 11, 2018, 11, 30, 16.99));
		assertEquals(b2.getOutbound().getFlightNumber(), "3");
	}

	@Test
	public void testSetInbound() {
		b2.setInbound(new Flight("4", "Dublin", "London", 21, 11, 2018, 11, 45, 17.99));
		assertEquals(b2.getInbound().getFlightNumber(), "4");
	}

	@Test
	public void testSetPassengers() {
		ArrayList<Passenger> passTest = new ArrayList<>();
		passTest.add(new Passenger("Mr", "Ciaran", "Toman", 26, 7, 1989, 1, false));
		b2.setPassengers(passTest);
		assertEquals(b2.getPassengers().isEmpty(), false);
		assertEquals(b2.getPassengers().size(), 1);
	}

	@Test
	public void testSetTotalPrice() {
		b2.setTotalPrice();
		assertEquals(b2.getTotalPrice(), 30.98, 0);
	}

	@Test
	public void testToString() {
		System.out.println(b2);
	}

	@Test
	public void testFindPassenger() {
		Passenger p = new Passenger("Mr", "Sean", "Toman", 19, 12, 1992, 2, true);
		assertEquals(b2.findPassenger(p), true);
	}

	@Test
	public void testCalculatePrice() {
		b2.calculatePrice();
		assertEquals(b2.getTotalPrice(), 30.98, 0);
	}

}
