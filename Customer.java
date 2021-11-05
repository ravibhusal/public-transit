import java.io.*;
import java.util.*;

abstract class Customer {
    public String firstName;
    public String lastName;
    public String customerType;
    public String emailAddress;
    public String discount;
    public String mobilePhoneNumber;
    public String recommendedCard;

    public Customer(String firstName, String lastName, String customerType, 
                    String emailAddress,  String mobilePhoneNumber){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCustomerType(customerType);
        this.setEmailAddress(emailAddress);
        this.setMobilePhoneNumber(mobilePhoneNumber);
        this.setRecommendedCard("");
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getCustomerType(){
        return this.customerType;
    }

    public String getEmailAddress(){
        return this.emailAddress;
    }

    public String getMobilePhoneNumber(){
        return this.mobilePhoneNumber;
    }

    public String getRecommendedCard(){
        return this.recommendedCard;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setCustomerType(String customerType){
        this.customerType = customerType;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber){
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public void setRecommendedCard(String recommendedCard){
        this.recommendedCard = recommendedCard;
    }

    public void calculateFareAndGenerateRecommendation(float maxTripsPerWeekDay, float maxTripsPerWeekendDays, float maxTravelWeeksPerMonth){
    }

    public void calculateFare(float maxTripsPerWeekDay, float maxTripsPerWeekendDays, float maxTravelWeeksPerMonth, Map<String, Float> fareMap){
        float perDayWeekdayCost = fareMap.get("weekdaysPerTrip") * maxTripsPerWeekDay;
        if(perDayWeekdayCost > 10) {
            perDayWeekdayCost = 10;
        }

        float perDayWeekendCost = fareMap.get("weekendsPerTrip") * maxTripsPerWeekendDays;

        if(perDayWeekendCost > 10){
            perDayWeekendCost = 10;
        }

        float oneWeekCost = perDayWeekdayCost * 5 + perDayWeekendCost * 2;
        float monthlyCost = oneWeekCost * maxTravelWeeksPerMonth;

        float weeklyPassDiscountPercentage = fareMap.get("weeklyPassPercentage");

        float monthlyPassDiscountPercentage = fareMap.get("monthlyPassPercentage");

        float oneWeekCostAfterDiscount = oneWeekCost - (weeklyPassDiscountPercentage * oneWeekCost)/100;

        float monthlyCostAfterDiscount = monthlyCost - (monthlyPassDiscountPercentage * monthlyCost)/100;

        // please review this logic
        String recommendedCard = "";
        if(oneWeekCost > 50){
            recommendedCard = "PAYG card at " + monthlyCostAfterDiscount + "/month";
        }else if(oneWeekCost < 50){
            recommendedCard = "PAYG card at " + oneWeekCostAfterDiscount + "/week"; 
        }

        this.setRecommendedCard(recommendedCard);
    }
}