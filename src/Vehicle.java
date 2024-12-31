
public abstract class Vehicle {
    // Private encapsulated fields
    private final String vehicleId; // Made final to avoid change
    private final String model; // Made final  to avoid change
    private double baseRentalRate;
    private boolean isAvailable;
    private final String color; // Made final to avoid change
    private boolean rented;

    // Constructor with validation
    public Vehicle(String vehicleId, String model, double baseRentalRate, boolean isAvailable, String color) {
        if (vehicleId == null || vehicleId.isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or empty.");
        }
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be positive.");
        }
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = isAvailable;
        this.color = color;
        this.rented = false;
    }

    // Getters and setters with validation
    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be positive.");
        }
        this.baseRentalRate = baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
    public String getColor() {
        return color;
    }

    // Abstract methods for rental calculation
    /**
     * Calculate the total rental cost based on the number of rental days.
     *
     * @param days Number of days the vehicle is rented.
     * @return Total rental cost.
     */
    public abstract double calculateRentalCost(int days);

    /**
     * Check if the vehicle is available for rental.
     *
     * @return True if available, false otherwise.
     */
    public abstract boolean isAvailableForRental();
}

