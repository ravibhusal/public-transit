import java.io.*;
import java.util.*;

public class ElderlyCustomer extends Customer{
    private String birthYear;

    public static final Map<String, Double> fareMap = new HashMap<String, Double>();

    static {
        fareMap.put("payGWeekdaysPerTrip", 1.80);
        fareMap.put("payGWeekendsPerTrip", 1.00);
    }

    public ElderlyCustomer(String firstName, String lastName, String customerType, String emailAddress, int discount, String mobilePhoneNumber, String birthYear){
        super(firstName, lastName, customerType, emailAddress, discount, mobilePhoneNumber);
        this.setBirthYear(birthYear);
    }

    public String getBirthYear(){
        return this.birthYear;
    }

    public Map getFareMap(){
        return fareMap;
    }

    public void setBirthYear(String birthYear){
        this.birthYear = birthYear;
    }

    public void calculateFareAndGenerateRecommendation(double maxTripsPerWeekDay, double maxTripsPerWeekendDays, double maxTravelWeeksPerMonth){
        this.calculateFare(maxTripsPerWeekDay, maxTripsPerWeekendDays, maxTravelWeeksPerMonth, fareMap);
    }

    public String toString(){
        String text = this.getFirstName() + " " + this.getLastName() + ", " + this.getCustomerType() + " " + this.getBirthYear() + ", " + this.getEmailAddress()
                        + ", " + this.getMobilePhoneNumber() + ", " + this.getRecommendedCard();
        
        return text;
    }
}