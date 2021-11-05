import java.io.*;
import java.util.*;

public class ElderlyCustomer extends Customer{
    private String birthYear;

    public static final Map<String, Float> fareMap = new HashMap<String, Float>();

    static {
        fareMap.put("weekdaysPerTrip", 1.80f);
        fareMap.put("weekendsPerTrip", 1.00f);
        fareMap.put("weeklyPassPercentage", 20.00f);
        fareMap.put("monthlyPassPercentage", 20.00f);
    }

    public ElderlyCustomer(String firstName, String lastName, String customerType, String emailAddress, String mobilePhoneNumber, String birthYear){
        super(firstName, lastName, customerType, emailAddress, mobilePhoneNumber);
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

    public void calculateFareAndGenerateRecommendation(float maxTripsPerWeekDay, float maxTripsPerWeekendDays, float maxTravelWeeksPerMonth){
        this.calculateFare(maxTripsPerWeekDay, maxTripsPerWeekendDays, maxTravelWeeksPerMonth, fareMap);
    }

    public String toString(){
        String text = this.getFirstName() + " " + this.getLastName() + ", " + this.getCustomerType() + " " + this.getBirthYear() + ", " + this.getEmailAddress()
                        + ", " + this.getMobilePhoneNumber() + ", " + this.getRecommendedCard();
        
        return text;
    }
}