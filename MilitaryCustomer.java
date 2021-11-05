import java.io.*;
import java.util.*;

public class MilitaryCustomer extends Customer{
    private String militaryBranch;

    public static final Map<String, Double> fareMap = new HashMap<String, Double>();

    static {
        fareMap.put("payGWeekdaysPerTrip", 2.00);
        fareMap.put("payGWeekendsPerTrip", 1.20);
    }

    public MilitaryCustomer(String firstName, String lastName, String customerType, String emailAddress, int discount,  String mobilePhoneNumber, String militaryBranch){
        super(firstName, lastName, customerType, emailAddress, discount, mobilePhoneNumber);
        this.setMilitaryBranch(militaryBranch);
    }

    public String getMilitaryBranch(){
        return this.militaryBranch;
    }

    public void setMilitaryBranch(String militaryBranch){
        this.militaryBranch = militaryBranch;
    }

    public void calculateFareAndGenerateRecommendation(double maxTripsPerWeekDay, double maxTripsPerWeekendDays, double maxTravelWeeksPerMonth){
        this.calculateFare(maxTripsPerWeekDay, maxTripsPerWeekendDays, maxTravelWeeksPerMonth, fareMap);
    }

    public String toString(){
        String text = this.getFirstName() + " " + this.getLastName() + ", " + this.getCustomerType() + " " + this.getMilitaryBranch() + ", " + this.getEmailAddress()
                        + ", " + this.getMobilePhoneNumber() + ", " + this.getRecommendedCard();
        
        return text;
    }
}