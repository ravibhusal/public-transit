import java.io.*;
import java.util.*;

public class CustomerFile {
    private Customer customers[];
    private int numberOfCustomers;
    private String customerFileName;

    private int numberOfOrders;
    private String ordersFileName;
    private ArrayList<String> ordersWithoutCustomers = new ArrayList<String>();

    public CustomerFile(String customerFileName, String ordersFileName){
        this.setCustomerFileName(customerFileName);
        this.setOrdersFileName(ordersFileName);
    }

    public void printCustomersAndTheirOrderRecommendations() throws Exception{
        processCustomersFromFile();
        processOrdersAndCalculateFare();
        printToFile();
    }

    public void setCustomerFileName(String customerFileName){
        this.customerFileName = customerFileName;
    }

    public void setOrdersFileName(String ordersFileName){
        this.ordersFileName = ordersFileName;
    }

    public void addCustomersToCustomerArray(int locationInArray, Customer customer){
        this.customers[locationInArray] = customer;
    }

    public void processCustomersFromFile() throws Exception{
        try {
            File customersFile = new File(this.customerFileName);
            FileReader fileReader = new FileReader(customersFile);
            BufferedReader reader = new BufferedReader(fileReader);

            int numberOfCustomers = Integer.parseInt(reader.readLine());
            this.customers = new Customer[numberOfCustomers];
            int lineIndex = 0;
            int customerIndex = 0;
            String line;
            String firstName = "";
            String lastName = "";
            String customerType= "";
            String customAttribute= "";
            String emailAddress = "";
            String mobilePhoneNumber = "";

            while ((line = reader.readLine()) != null) {
                // System.out.println(line);
                lineIndex++;
                if(lineIndex == 1){
                    firstName = line;
                }
                else if(lineIndex == 2){
                    lastName = line;
                }
                else if(lineIndex == 3){
                    customerType = line;
                }
                else if(lineIndex == 4){
                    customAttribute = line;
                }
                else if(lineIndex == 5){
                    emailAddress = line;
                }
                else if(lineIndex == 6){
                    mobilePhoneNumber = line;
                    lineIndex = 0;
                    if (customerType.equals("Regular")){
                        RegularCustomer customer = new RegularCustomer(firstName, lastName, customerType, emailAddress, mobilePhoneNumber, customAttribute);
                        addCustomersToCustomerArray(customerIndex, customer);
                    }else if(customerType.equals("Student")){
                        StudentCustomer customer = new StudentCustomer(firstName, lastName, customerType, emailAddress, mobilePhoneNumber, customAttribute);
                        addCustomersToCustomerArray(customerIndex, customer);
                    }else if(customerType.equals("Military")){
                        MilitaryCustomer customer = new MilitaryCustomer(firstName, lastName, customerType, emailAddress, mobilePhoneNumber, customAttribute);
                        addCustomersToCustomerArray(customerIndex, customer);
                    }else if(customerType.equals("Senior")){
                        ElderlyCustomer customer = new ElderlyCustomer(firstName, lastName, customerType, emailAddress, mobilePhoneNumber, customAttribute);
                        addCustomersToCustomerArray(customerIndex, customer);
                    }
                    customerIndex++;
                }
            }
            fileReader.close();

        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void processOrdersAndCalculateFare() throws Exception{
        try {
            File ordersFile = new File(this.ordersFileName);
            FileReader fileReader = new FileReader(ordersFile);
            BufferedReader reader = new BufferedReader(fileReader);

            int numberOfOrders = Integer.parseInt(reader.readLine());

            int lineIndex = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                List<String> orderInfo = Arrays.asList(line.split(" "));
                Boolean customerFound = false;
                String lastName, mobilePhoneNumber;
                Float maxTripsPerWeekDay, maxTripsPerWeekendDays, maxTravelWeeksPerMonth;

                lastName = orderInfo.get(0);
                mobilePhoneNumber = orderInfo.get(1);
                maxTripsPerWeekDay = Float.parseFloat(orderInfo.get(2));
                maxTripsPerWeekendDays = Float.parseFloat(orderInfo.get(3));
                maxTravelWeeksPerMonth = Float.parseFloat(orderInfo.get(4));
                System.out.println(this.customers);
                for(Customer customer : this.customers){
                    if(customer.getLastName() == lastName || customer.getMobilePhoneNumber() == mobilePhoneNumber){
                        customerFound = true;
                        customer.calculateFareAndGenerateRecommendation(maxTripsPerWeekDay, maxTripsPerWeekendDays, maxTravelWeeksPerMonth);
                        break;
                    }
                }

                if(!customerFound){
                    this.ordersWithoutCustomers.add(lastName + " " + mobilePhoneNumber);
                }
            }
            fileReader.close();

        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void printToFile() throws Exception{
        StringBuilder content = new StringBuilder();


        for(Customer customer : this.customers){
            content.append(customer.toString());
            content.append("\n");
        }

        for(String orderWithoutCustomer : this.ordersWithoutCustomers){
            content.append(orderWithoutCustomer);
            content.append("\n");
        }

        try {
            FileWriter writer = new FileWriter("testfiles/customerorders.txt");  
            BufferedWriter buffer = new BufferedWriter(writer);  
            buffer.write(content.toString());  
            buffer.close();  
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}