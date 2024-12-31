public class Cars extends Vehicle {

    private int numberOfSeats;
    private boolean hasGps;
    private boolean airConditioningEnabled;
    private boolean towEnabled;
    private boolean  offRoadEnabled;

    // Constructor with additional fields
    public Cars(String vehicleId, String model, double baseRentalRate,
                boolean isAvailable, String color, int numberOfSeats, boolean hasGps,
            boolean airConditioningEnabled, boolean towEnabled, boolean offRoadEnabled){
        super(vehicleId, model, baseRentalRate, isAvailable, color);
        if (numberOfSeats <= 0) {
            throw new IllegalArgumentException("Number of seats must be greater than 0.");
        }
        this.numberOfSeats = numberOfSeats;
        this.hasGps = hasGps;
        this.airConditioningEnabled = airConditioningEnabled;
        this.towEnabled = towEnabled;
        this.offRoadEnabled = offRoadEnabled;
    }

    // Getters and setters for additional fields
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats <= 0) {
            throw new IllegalArgumentException("Number of seats must be greater than 0.");
        }
        this.numberOfSeats = numberOfSeats;
    }

    public boolean hasGps() {
        return hasGps;
    }

    public void setHasGps(boolean hasGps) {
        this.hasGps = hasGps;
    }
    public boolean isAirConditioningEnabled() {
        return airConditioningEnabled;
    }
    public void setAirConditioningEnabled(boolean airConditioningEnabled) {
        this.airConditioningEnabled = airConditioningEnabled;
    }
    public boolean isTowEnabled() {
        return towEnabled;
    }
    public void setTowEnabled(boolean towEnabled) {
        this.towEnabled = towEnabled;
    }
    public boolean isOffRoadEnabled() {
        return offRoadEnabled;
    }
    public void setOffRoadEnabled(boolean offRoadEnabled) {
        this.offRoadEnabled = offRoadEnabled;
    }


    // Override abstract methods
    @Override
    public double calculateRentalCost(int days) {
        double totalCost = getBaseRentalRate() * days;
        if (hasGps) {
            totalCost += 10 * days; // Add $10/day if GPS is included
        }
        return totalCost;
    }

    public double calculateRentalCost(int days, double discount) {
        double baseCost = calculateRentalCost(days);
        return baseCost - discount;
    }


    @Override
    public boolean isAvailableForRental() {
        return isAvailable() && !isRented();
    }

    @Override
    public String toString() {
        return String.format("Car [ID=%s, Model=%s, Color=%s, Seats=%d, GPS=%b, Base Rate=%.2f]",
                getVehicleId(), getModel(), getColor(), numberOfSeats, hasGps, getBaseRentalRate());
    }
}
