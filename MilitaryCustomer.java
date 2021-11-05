import java.io.*;
import java.util.*;

public class MilitaryCustomer extends Customer{
    private String militaryBranch;

    public static final Map<String, Float> fareMap = new HashMap<String, Float>();

    static {
        fareMap.put("weekdaysPerTrip", 2.00f);
        fareMap.put("weekendsPerTrip", 1.20f);
        fareMap.put("weeklyPassPercentage", 15.00f);
        fareMap.put("monthlyPassPercentage", 15.00f);
    }

    public MilitaryCustomer(String firstName, String lastName, String customerType, String emailAddress, String mobilePhoneNumber, String militaryBranch){
        super(firstName, lastName, customerType, emailAddress, mobilePhoneNumber);
        this.setMilitaryBranch(militaryBranch);
    }

    public String getMilitaryBranch(){
        return this.militaryBranch;
    }

    public void setMilitaryBranch(String militaryBranch){
        this.militaryBranch = militaryBranch;
    }

    public void calculateFareAndGenerateRecommendation(float maxTripsPerWeekDay, float maxTripsPerWeekendDays, float maxTravelWeeksPerMonth){
        this.calculateFare(maxTripsPerWeekDay, maxTripsPerWeekendDays, maxTravelWeeksPerMonth, fareMap);
    }

    public String toString(){
        String text = this.getFirstName() + " " + this.getLastName() + ", " + this.getCustomerType() + " " + this.getMilitaryBranch() + ", " + this.getEmailAddress()
                        + ", " + this.getMobilePhoneNumber() + ", " + this.getRecommendedCard();
        
        return text;
    }
}