import java.io.*;
import java.util.*;

public class RegularCustomer extends Customer{
    private String rewardNumber;

    public static final Map<String, Double> fareMap = new HashMap<String, Double>();

    static {
        fareMap.put("payGWeekdaysPerTrip", 3.00);
        fareMap.put("payGWeekendsPerTrip", 2.00);
    }

    public RegularCustomer(String firstName, String lastName, String customerType, String emailAddress, int discount, String mobilePhoneNumber, String rewardNumber){
        super(firstName, lastName, customerType, emailAddress, discount, mobilePhoneNumber);
        this.setRewardNumber(rewardNumber);
    }

    public Map getFareMap(){
        return this.fareMap;
    }

    public String getRewardNumber(){
        return this.rewardNumber;
    }

    public void setRewardNumber(String rewardNumber){
        this.rewardNumber = rewardNumber;
    }

    public void calculateFareAndGenerateRecommendation(double maxTripsPerWeekDay, double maxTripsPerWeekendDays, double maxTravelWeeksPerMonth){
        this.calculateFare(maxTripsPerWeekDay, maxTripsPerWeekendDays, maxTravelWeeksPerMonth, fareMap);
    }

    public String toString(){
        String text = this.getFirstName() + " " + this.getLastName() + ", " + this.getCustomerType() + " " + this.getRewardNumber() + ", " + this.getEmailAddress()
                        + ", " + this.getMobilePhoneNumber() + ", " + this.getRecommendedCard();
        
        return text;
    }
}