import java.util.List;

public class Customers {
    private String name;
    private int age;
    private String customerId;
    private String phone;
    private String driversLicense;
    private boolean rentedVehicle;
    private boolean overDuePayment;
    private RentalHistory rentalHistory; // Add RentalHistory object to store transactions

    // Constructor
    public Customers(String name, int age, String customerId, String phone, String driversLicense, boolean rentedVehicle, boolean overDuePayment) {
        if(age < 18) {
            throw new IllegalArgumentException("Your age must be at least 18");
        }
        if(phone.length() < 10) {
            throw new IllegalArgumentException("Phone number must be 10 digits long");
        }
        if(driversLicense.isEmpty()) {
            throw new IllegalArgumentException("No drivers license provided");
        }

        this.name = name;
        this.age = age;
        this.customerId = customerId;
        this.phone = phone;
        this.driversLicense = driversLicense;
        this.rentedVehicle = rentedVehicle;
        this.overDuePayment = overDuePayment;
        this.rentalHistory = new RentalHistory(); // Initialize rental history
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }

    public boolean isRentedVehicle() {
        return rentedVehicle;
    }

    public void setRentedVehicle(boolean rentedVehicle) {
        this.rentedVehicle = rentedVehicle;
    }

    public boolean isOverDuePayment() {
        return overDuePayment;
    }

    public void setOverDuePayment(boolean overDuePayment) {
        this.overDuePayment = overDuePayment;
    }



    // Rental history access and update
    public void rentVehicle(RentalTransaction transaction) {
        if (overDuePayment) {
            System.out.println("Customer has overdue payments. Cannot rent vehicle.");
        } else {
            this.rentedVehicle = true; // Mark the customer as having rented a vehicle
            rentalHistory.addTransaction(transaction); // Add transaction to rental history
            System.out.println("Vehicle rented successfully.");
        }
    }

    public void returnVehicle(RentalTransaction transaction) {
        if (!rentedVehicle) {
            System.out.println("Customer has not rented a vehicle.");
        } else {
            this.rentedVehicle = false; // Mark the customer as having returned the vehicle
            System.out.println("Vehicle returned successfully.");
        }
    }

    // Check eligibility (based on overdue payments)
    public String checkEligibility() {
        if (overDuePayment) {
            return "Not Eligible (Overdue payment)";
        } else {
            return "Eligible";
        }
    }

    // Rental history display method
    public void printRentalHistory() {
        rentalHistory.printTransactionHistory(); // Print all transactions from rental history
    }

    // Get customer details
    public String getCustomerDetails() {
        return String.format("Customer Info: \nName: %s\nAge: %d\nID: %s\nPhone: %s\nDriver's License: %s\nRented Vehicle: %b",
                name, age, customerId, phone, driversLicense, rentedVehicle);
    }

    public RentalHistory getRentalHistory() {
        return rentalHistory;
    }


}

