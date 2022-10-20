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
public class Member extends Passenger{
    private int yearsOfMembership;
    public Member(String name, int age, int yearsOfMembership){
        super(name,age);
        this.yearsOfMembership=yearsOfMembership;
    }

    @Override
    public double applyDiscount(double p){
        double disct;
        if(yearsOfMembership>5){
            disct=0.5;
        }
        else if(yearsOfMembership>1 && yearsOfMembership<=5){
            disct=0.9;
        }
        
        else disct=1;

        double price= p*disct;
                return price;
    }
}
