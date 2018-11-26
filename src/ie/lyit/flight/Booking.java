package ie.lyit.flight;

import java.util.ArrayList;

public class Booking {
	
	private Flight outbound;
	private Flight inbound;
	private ArrayList<Passenger> passengers;
	private double totalPrice;
	
	private static int count = 0;
	
	public Booking() {
		this.outbound = new Flight();
		this.inbound = new Flight();
		this.passengers = new ArrayList<Passenger>();
		this.totalPrice = 0;
		count++;
	}
	
	public Booking(Flight outbound, Flight inbound, ArrayList<Passenger> passengers) {
		this.outbound = outbound;
		this.inbound = inbound;
		this.passengers = passengers;
		calculatePrice();
		count++;
	}
	
	public void setOutbound(Flight outbound) {
		this.outbound = outbound;
	}
	
	public void setInbound(Flight inbound) {
		this.inbound = inbound;
	}
	
	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	public void setTotalPrice() {
		calculatePrice();
	}
	
	public Flight getOutbound() {
		return outbound;
	}
	
	public Flight getInbound() {
		return inbound;
	}
	
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public int getCount() {
		return count;
	}
	
	@Override
	public String toString() {
		return "Outbound: " + outbound 
				+ ", Inbound: " + inbound 
				+ ", No Passengers: " + passengers.size() 
				+ ", Total Price: " + totalPrice
				+ ", No Bookings: " + count;
	}
	
	@Override
	public boolean equals(Object obj) {
		Booking b;
		if(obj instanceof Booking)
			b = (Booking) obj;
		else
			return false;
		
		return this.outbound.equals(b.getOutbound()) && this.inbound.equals(b.getInbound());
	}
	
	public boolean findPassenger(Passenger p) {
		return passengers.contains(p);
	}
	
	public double calculatePrice() {
		totalPrice = (outbound.getPrice() + inbound.getPrice()) * passengers.size();
		return totalPrice;
	}
}
