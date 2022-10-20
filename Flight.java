/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author ASUS
 */
public class Flight {
    int flightNumber;
    String origin;
    String destination;
    String departureTime;
    int capacity;
    double originalPrice;
    int numberOfSeatsLeft;
      public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice) {
         this.flightNumber=flightNumber;
         this.origin=origin;
         this.destination=destination;
         this.departureTime=departureTime;
         this.capacity=capacity;
         this.originalPrice=originalPrice;
         this.numberOfSeatsLeft=capacity;
         if(origin.equals(destination) == true) {
             throw new IllegalArgumentException("Error: Destination cannot be the same as Origin."); 
         }
         if(capacity <0 || flightNumber<0 || originalPrice<0) {
             throw new IllegalArgumentException("Error: Invalid Data."); 
         }
  }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }

    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
    public boolean bookASeat(){
        if (numberOfSeatsLeft>0){
            numberOfSeatsLeft--;
            return true;
        }
        else{
        return false;
    }
    }
    @Override
    public String toString(){
        return "Flight "+flightNumber+", "+origin+" to "+destination+", "+departureTime+", original price: "+originalPrice+"$. \n";
    }
    
}
