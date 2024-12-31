public class Truck extends Vehicle {

    private double maxLoadCapacity; // Truck-specific feature


    private int numberOfSeats;
    private boolean gpsEnabled;
    private boolean airConditioningEnabled;
    private boolean towEnabled;
    private boolean  offRoadEnabled;
    // Constructor with additional feature
    public Truck(String vehicleId, String model, double baseRentalRate, boolean isAvailable,
                 String color, double maxLoadCapacity, boolean gpsEnabled,
                 boolean airConditioningEnabled, boolean towEnabled, boolean offRoadEnabled) {
        super(vehicleId, model, baseRentalRate, isAvailable, color);
        if (maxLoadCapacity <= 0) {
            throw new IllegalArgumentException("Max load capacity must be greater than 0.");
        }
        this.maxLoadCapacity = maxLoadCapacity;
        this.gpsEnabled = gpsEnabled;
        this.airConditioningEnabled = airConditioningEnabled;
        this.towEnabled = towEnabled;
        this.offRoadEnabled = offRoadEnabled;


    }

    public void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats <2 ) {
            throw new IllegalArgumentException("Number of seats cannot be less than 2.");
        }
        this.numberOfSeats = numberOfSeats;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isGpsEnabled() {
        return gpsEnabled;
    }
    public boolean isAirConditioningEnabled() {
        return airConditioningEnabled;
    }
    public boolean isTowEnabled() {
        return towEnabled;
    }
    public boolean isOffRoadEnabled() {
        return offRoadEnabled;
    }


    public double getMaxLoadCapacity() {
        return maxLoadCapacity;
    }
    public void setGpsEnabled(boolean gpsEnabled) {
        this.gpsEnabled = gpsEnabled;
    }
    public void setAirConditioningEnabled(boolean airConditioningEnabled) {
        this.airConditioningEnabled = airConditioningEnabled;
    }

    public void setTowEnabled(boolean towEnabled) {
        this.towEnabled = towEnabled;
    }
    public void setOffRoadEnabled(boolean offRoadEnabled) {
        this.offRoadEnabled = offRoadEnabled;
    }


    public void setMaxLoadCapacity(double maxLoadCapacity) {
        if (maxLoadCapacity <= 0) {
            throw new IllegalArgumentException("Max load capacity must be greater than 0.");
        }
        this.maxLoadCapacity = maxLoadCapacity;

    }

    // Override abstract method to calculate rental cost
    @Override
    public double calculateRentalCost(int days) {
        double totalCost = getBaseRentalRate() * days;

        if (maxLoadCapacity > 1000) {
            totalCost += 50;
        }
        if(gpsEnabled){
            totalCost += 30;
        }
         if (airConditioningEnabled) {
             totalCost += 50;
         }
         if (towEnabled) {
             totalCost += 20;
         }
         if (offRoadEnabled) {
             totalCost += 50;
         }

        return totalCost;
    }


    // Override abstract method to check availability
    @Override
    public boolean isAvailableForRental() {
        return isAvailable() && !isRented(); // Corrected logic
    }
    public boolean isAvailableForRental(double requiredLoadCapacity) {
        return isAvailable() && !isRented() && requiredLoadCapacity <= getMaxLoadCapacity();
    }


    // Add a toString method for better representation
    @Override
    public String toString() {
        return String.format("Truck [ID=%s, Model=%s, Color=%s, Base Rate=%.2f, Max Load Capacity=%.2f, Available=%b]",
                getVehicleId(), getModel(), getColor(), getBaseRentalRate(), maxLoadCapacity, isAvailable());
    }
}


