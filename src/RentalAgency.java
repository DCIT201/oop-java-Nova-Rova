import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> vehicles; // List of vehicles
    private List<RentalTransaction> transactions; // List of rental transactions

    // Constructor to initialize the list of vehicles and transactions
    public RentalAgency() {
        vehicles = new ArrayList<>(); // Initialize the vehicles list
        transactions = new ArrayList<>(); // Initialize the transactions list
    }

    // Method to add a vehicle to the agency
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle); // Add vehicle to the list
    }

    // Method to check if a vehicle is available for rental
    public boolean isVehicleAvailable(Vehicle vehicle) {
        return vehicle.isAvailableForRental(); // Check if the vehicle is available
    }

    // Method to rent a vehicle to a customer
    public RentalTransaction rentVehicle(Customers customer, Vehicle vehicle, int days) {
        if (isVehicleAvailable(vehicle) && !customer.isOverDuePayment()) {
            // Calculate the total rental cost
            double totalCost = vehicle.calculateRentalCost(days);

            // Create a unique transaction ID (you can use a more sophisticated ID generator if needed)
            String transactionId = "T" + (transactions.size() + 1);

            // Create a new RentalTransaction
            RentalTransaction transaction = new RentalTransaction(transactionId, vehicle, customer, days, totalCost);
            transactions.add(transaction); // Add transaction to the list

            // Mark the vehicle as rented
            vehicle.setIsAvailable(false); // Vehicle is no longer available for rental

            // Update customer's rental history
            customer.rentVehicle(transaction); // Add the transaction to the customer's rental history

            return transaction;
        } else {
            System.out.println("Vehicle is not available or customer has overdue payments.");
            return null;
        }
    }

    // Method to return a rented vehicle
    public void returnVehicle(Customers customer, Vehicle vehicle, RentalTransaction transaction) {
        if (transaction != null && transaction.getVehicle().equals(vehicle)) {
            // Mark the vehicle as available again
            vehicle.setIsAvailable(true);

            // Remove the rental transaction from the agency's records
            transactions.remove(transaction);

            // Update the customer's rental history
            customer.getRentalHistory().removeTransaction(transaction); // Use getRentalHistory() here
        }
    }


    // Method to get a list of all rental transactions
    public List<RentalTransaction> getAllTransactions() {
        return transactions;
    }

}
