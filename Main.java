
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String []args) throws Exception{
        CustomerFile customerFile = new CustomerFile("testfiles/newcustomers.txt", "testfiles/orders.txt");
        customerFile.printCustomersAndTheirOrderRecommendations();
    }
}