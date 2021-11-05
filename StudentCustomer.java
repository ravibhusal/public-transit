import java.io.*;
import java.util.*;

public class StudentCustomer extends Customer{
    private String schoolName;

    public static final Map<String, Float> fareMap = new HashMap<String, Float>();

    static {
        fareMap.put("weekdaysPerTrip", 2.00f);
        fareMap.put("weekendsPerTrip", 1.20f);
        fareMap.put("weeklyPassPercentage", 15.00f);
        fareMap.put("monthlyPassPercentage", 15.00f);
    }
    public StudentCustomer(String firstName, String lastName, String customerType, String emailAddress, String mobilePhoneNumber, String schoolName){
        super(firstName, lastName, customerType, emailAddress, mobilePhoneNumber);
        this.setSchoolName(schoolName);
    }

    public String getSchoolName(){
        return this.schoolName;
    }

    public Map getFareMap(){
        return fareMap;
    }

    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    // @override
    public void calculateFareAndGenerateRecommendation(float maxTripsPerWeekDay, float maxTripsPerWeekendDays, float maxTravelWeeksPerMonth){
        this.calculateFare(maxTripsPerWeekDay, maxTripsPerWeekendDays, maxTravelWeeksPerMonth, fareMap);
    }

    public String toString(){
        String text = this.getFirstName() + " " + this.getLastName() + ", " + this.getCustomerType() + " " + this.getSchoolName() + ", " + this.getEmailAddress()
                        + ", " + this.getMobilePhoneNumber() + ", " + this.getRecommendedCard();
        
        return text;
    }
}