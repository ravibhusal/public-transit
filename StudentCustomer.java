import java.io.*;
import java.util.*;

public class StudentCustomer extends Customer{
    private String schoolName;

    public static final Map<String, Double> fareMap = new HashMap<String, Double>();

    static {
        fareMap.put("payGWeekdaysPerTrip", 2.00);
        fareMap.put("payGWeekendsPerTrip", 1.20);
    }
    public StudentCustomer(String firstName, String lastName, String customerType, String emailAddress, int discount, String mobilePhoneNumber, String schoolName){
        super(firstName, lastName, customerType, emailAddress, discount, mobilePhoneNumber);
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

    public void calculateFareAndGenerateRecommendation(double maxTripsPerWeekDay, double maxTripsPerWeekendDays, double maxTravelWeeksPerMonth){
        this.calculateFare(maxTripsPerWeekDay, maxTripsPerWeekendDays, maxTravelWeeksPerMonth, fareMap);
    }

    public String toString(){
        String text = this.getFirstName() + " " + this.getLastName() + ", " + this.getCustomerType() + " " + this.getSchoolName() + ", " + this.getEmailAddress()
                        + ", " + this.getMobilePhoneNumber() + ", " + this.getRecommendedCard();
        
        return text;
    }
}