public class RentalTransaction {
    private String transactionId;
    private Vehicle vehicle;
    private Customers customer; // Added customer field
    private int days;
    private double totalCost;

    // Constructor
    public RentalTransaction(String transactionId, Vehicle vehicle, Customers customer, int days, double totalCost) {
        this.transactionId = transactionId;
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.totalCost = totalCost;
    }

    // Getter methods
    public String getTransactionId() {
        return transactionId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customers getCustomer() {
        return customer; // Return the customer associated with the transaction
    }

    public int getDays() {
        return days;
    }

    public double getTotalCost() {
        return totalCost;
    }

    // Method to get transaction details as a string
    public String getTransactionDetails() {
        return String.format("Transaction ID: %s\nVehicle: %s\nCustomer: %s\nRental Days: %d\nTotal Cost: %.2f",
                transactionId, vehicle.getModel(), customer.getName(), days, totalCost);
    }
}
