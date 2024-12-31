public class Motorcycle extends Vehicle {
    private  boolean sidecart = false;
    private  boolean gps = false;
    private  boolean helmet= false;
    private  boolean suit= false;
    private  boolean  cellPhoneHolder = false;



    // Constructor
    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean isAvailable, String color,
                      boolean sidecart, boolean gps, boolean helmet, boolean suit, boolean cellPhoneHolder) {
        super(vehicleId, model, baseRentalRate, isAvailable, color);
        this.sidecart = sidecart;
        this.gps = gps;
        this.helmet = helmet;
        this.suit = suit;
        this.cellPhoneHolder = cellPhoneHolder;

    }

    // Override abstract method to calculate rental cost
    @Override
    public double calculateRentalCost(int days) {
        double totalCost = getBaseRentalRate() * days;
            if (sidecart) {
                totalCost += 100;
            }
            if (gps) {
                totalCost += 20;
            }
            if (helmet) {
                totalCost += 20;
            }
            if (suit) {
                totalCost += 50;
            }
            if (cellPhoneHolder) {
                totalCost += 5;
            }
        return totalCost;
    }

    public boolean isSidecart() {
        return sidecart;
    }
    public void setSidecart(boolean sidecart) {
        this.sidecart = sidecart;
    }
    public boolean isGps() {
        return gps;
    }
    public void setGps(boolean gps) {
        this.gps = gps;
    }
    public boolean isHelmet() {
        return helmet;
    }
    public void setHelmet(boolean helmet) {
        this.helmet = helmet;
    }
    public boolean isSuit() {
        return suit;
    }
    public void setSuit(boolean suit) {
        this.suit = suit;
    }
    public boolean isCellPhoneHolder() {
        return cellPhoneHolder;
    }
    public void setCellPhoneHolder(boolean cellPhoneHolder) {
        this.cellPhoneHolder = cellPhoneHolder;
    }


    @Override
    public boolean isAvailableForRental() {
        return isAvailable() && !isRented();
    }

    // Add a toString method for better representation
    @Override
    public String toString() {
        return String.format("Motorcycle [ID=%s, Model=%s, Color=%s, Base Rate=%.2f, Available=%b]",
                getVehicleId(), getModel(), getColor(), getBaseRentalRate(), isAvailable());
    }
}
