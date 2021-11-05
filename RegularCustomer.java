import java.io.*;
import java.util.*;

public class RegularCustomer extends Customer{
    private String rewardNumber;

    public static final Map<String, Float> fareMap = new HashMap<String, Float>();
    public static final Map<String, Float> discountedFareMap = new HashMap<String, Float>();

    static {
        fareMap.put("weekdaysPerTrip", 3.00f);
        fareMap.put("weekendsPerTrip", 2.00f);
        fareMap.put("weeklyPassPercentage", 0.00f);
        fareMap.put("monthlyPassPercentage", 0.00f);
    }

    static {
        discountedFareMap.put("weekdaysPerTrip", 2.50f);
        discountedFareMap.put("weekendsPerTrip", 1.50f);
        discountedFareMap.put("weeklyPassPercentage", 5f);
        discountedFareMap.put("monthlyPassPercentage", 5f);
    }

    public RegularCustomer(String firstName, String lastName, String customerType, String emailAddress, String mobilePhoneNumber, String rewardNumber){
        super(firstName, lastName, customerType, emailAddress, mobilePhoneNumber);
        this.setRewardNumber(rewardNumber);
    }

    public Map getFareMap(){
        Map fMap = this.getRewardNumber() == "NA" ? this.fareMap : this.discountedFareMap;
        return fMap;
    }

    public String getRewardNumber(){
        return this.rewardNumber;
    }

    public void setRewardNumber(String rewardNumber){
        this.rewardNumber = rewardNumber;
    }

    public void calculateFareAndGenerateRecommendation(float maxTripsPerWeekDay, float maxTripsPerWeekendDays, float maxTravelWeeksPerMonth){
        this.calculateFare(maxTripsPerWeekDay, maxTripsPerWeekendDays, maxTravelWeeksPerMonth, fareMap);
    }

    public String toString(){
        String text = this.getFirstName() + " " + this.getLastName() + ", " + this.getCustomerType() + " " + this.getRewardNumber() + ", " + this.getEmailAddress()
                        + ", " + this.getMobilePhoneNumber() + ", " + this.getRecommendedCard();
        
        return text;
    }
}