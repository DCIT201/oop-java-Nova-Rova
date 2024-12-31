import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RentalHistory {
    // List to hold RentalTransaction objects
    private List<RentalTransaction> transactions;

    // Constructor to initialize the list
    public RentalHistory() {
        transactions = new ArrayList<>(); // Initialize the list
    }

    // Method to add a transaction to the list
    public void addTransaction(RentalTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null.");
        }
        transactions.add(transaction); // Add the rental transaction to the list
    }

    // Method to remove a transaction from the list
    public void removeTransaction(RentalTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null.");
        }
        if (!transactions.remove(transaction)) {
            System.out.println("Transaction not found in the history.");
        }
    }

    // Method to print out the transaction history
    public void printTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No rental history.");
        } else {
            StringBuilder history = new StringBuilder("Rental History:\n");
            for (RentalTransaction transaction : transactions) {
                history.append(transaction.getTransactionDetails()).append("\n");
            }
            System.out.println(history.toString());
        }
    }

    // Getter for transactions (returns an unmodifiable view of the list)
    public List<RentalTransaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
