import java.io.*;
import java.util.*;

abstract class Customer {
    public String firstName;
    public String lastName;
    public String customerType;
    public String emailAddress;
    public int discount;
    public String mobilePhoneNumber;
    public String recommendedCard;

    public Customer(String firstName, String lastName, String customerType, 
                    String emailAddress, int discount, String mobilePhoneNumber){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCustomerType(customerType);
        this.setEmailAddress(emailAddress);
        this.setDiscount(discount);
        this.setMobilePhoneNumber(mobilePhoneNumber);
        this.setRecommendedCard("***NO ORDER***");
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

    public int getDiscount(){
        return this.discount;
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

    public void setDiscount(int discount){
        this.discount = discount;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber){
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public void setRecommendedCard(String recommendedCard){
        this.recommendedCard = recommendedCard;
    }

    public void calculateFareAndGenerateRecommendation(double maxTripsPerWeekDay, double maxTripsPerWeekendDays, double maxTravelWeeksPerMonth){
    }

    public void calculateFare(double maxTripsPerWeekDay, double maxTripsPerWeekendDays, double maxTravelWeeksPerMonth, Map<String, Double> fareMap){
        double payGPerDayWeekdayCost = fareMap.get("payGWeekdaysPerTrip") * maxTripsPerWeekDay;
        if(payGPerDayWeekdayCost > 10) {
            payGPerDayWeekdayCost = 10;
        }

        double payGPerDayWeekendCost = fareMap.get("payGWeekendsPerTrip") * maxTripsPerWeekendDays;

        if(payGPerDayWeekendCost > 10){
            payGPerDayWeekendCost = 10;
        }

        double payGtotalWeekCost = payGPerDayWeekdayCost * 5 + payGPerDayWeekendCost * 2;

        double payGtotalMonthCost = payGtotalWeekCost * maxTravelWeeksPerMonth;

        // please review this logic
        String recommendedCard = "";

        if(payGtotalMonthCost > 100){
            recommendedCard = "Monthly pass at " + (payGtotalMonthCost - (this.discount * payGtotalMonthCost)/100)  + "/month";
        }else if(payGtotalMonthCost < 100){
            if(payGtotalWeekCost > 50){
                recommendedCard = "Weekly pass at " + (payGtotalWeekCost - (this.discount * payGtotalWeekCost)/100)  + "/week";
            }else if(payGtotalWeekCost < 50){
                recommendedCard = "PAYG card at " + payGtotalWeekCost + "/week";
            }
        }
        this.setRecommendedCard(recommendedCard);
    }
}