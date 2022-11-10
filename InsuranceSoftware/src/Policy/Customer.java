package Policy;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
    String firstName,lastName,city;
    int phoneNR;
    Policy policy;
    ArrayList<String> risks;

    public Customer(){

    }

    public Customer(String firstName, String lastName, String city, int phoneNR, Policy policy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.phoneNR = phoneNR;
        this.policy = policy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getPhoneNR() {
        return phoneNR;
    }

    public Policy getPolicy() {
        return policy;
    }

    @Override
    public String toString() {
        return  "First Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nCity: " + city +
                "\n"+policy;
    }
}
