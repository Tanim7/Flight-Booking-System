/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Manager {
    ArrayList<Flight> flights = new ArrayList<>();
    ArrayList<Ticket> tickets=new ArrayList<>();


public void createFlights(){
    String[] x;
    Scanner scan1 = new Scanner(System.in);
    System.out.println("Enter the details of the flight in following order in one line:(Use comma to seperate the details)");
    System.out.println("Flight Number,origin,destination,departure time and date,capacity,original price");
    System.out.println("Example Input:1010,Dubai,Paris,30/1/2022 11:00 pm,50,3000");
    //Taking all input as String for ease
    String input =scan1.nextLine();
    x=input.split(",");
    
    //Converting String to Integer and Double where required
  flights.add(new Flight(Integer.parseInt(x[0]),x[1],x[2],x[3],Integer.parseInt(x[4]),Double.parseDouble(x[5]) ));
    
        System.out.println("The flight details are as follows:");
            System.out.println(flights.get(flights.size()-1));

}
public void displayAvailableFlights(String origin, String destination){
    String a, b;
    int s;
for (int i = 0; i < flights.size() ; i++){
     a= flights.get(i).getOrigin();
    b = flights.get(i).getDestination();
    s = flights.get(i).getNumberOfSeatsLeft();
    
    if((a.equals(origin)) && (b.equals(destination)) && (s>0)){
        System.out.println("Available flights:");
                System.out.println(flights.get(i));

    }
    else{
        System.out.println("No Available flights");
    }
}
}

public Flight getFlight(int flightNumber){
    
    for (int i = 0; i < flights.size(); i++) {
        if (flights.get(i).getFlightNumber() == flightNumber){
            return (flights.get(i));
        }
    }
        return null;
}

public void bookSeat(int flightNumber, Passenger p){
    
            if(getFlight(flightNumber) != null){
               if (getFlight(flightNumber).bookASeat()){
               double price = p.applyDiscount(getFlight(flightNumber).getOriginalPrice());
                
                Ticket a = new Ticket(p,getFlight(flightNumber),price);
                tickets.add(a);
                
                       System.out.println("Your flight has been booked");
                              System.out.println("ticket: " + a);
            }
            }
            else{
                System.out.println("Flight Doesnt exist");
            }
}
public void createFlights(Flight f){
        if (getFlight(f.getFlightNumber()) == null){
            flights.add(f);
        }else{ 
            System.out.println("This flight number exists already!");
        }
    }



public static void main(String[] args) {
        
        Manager emirates = new Manager();
        
        Flight f = new Flight(1, "Dubai", "Paris", "30/01/22 11:00 pm", 8, 3000);
        emirates.createFlights(f);
        
        Passenger member_1 = new Member("Member1", 30, 5); 
        Passenger member_2 = new Member("Member2", 25, 3); 
        Passenger member_3 = new Member("Member3", 15, 0);
        Passenger nonmember_1 = new NonMember("NonMember1", 40); 
        Passenger nonmember_2 = new NonMember("NonMember2", 30); 
        Passenger nonmember_3 = new NonMember("NonMember2", 22); 
        
        emirates.createFlights();
        
         emirates.bookSeat(1, member_1);
         emirates.bookSeat(1, member_2);
         emirates.bookSeat(3, member_3);
         emirates.displayAvailableFlights("Dubai", "Paris");
         emirates.bookSeat(1, nonmember_1);
         emirates.bookSeat(2, nonmember_2);
         emirates.bookSeat(3, nonmember_3);
         emirates.displayAvailableFlights("Dubai", "Paris");
    }
}
