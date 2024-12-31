public class Main {
    public static void main(String[] args) {
        // Create instances of Vehicles
        Vehicle car = new Cars("C001", "Toyota Corolla", 50.0, true, "Red", 5, true, true, false, false);
        Vehicle motorcycle = new Motorcycle("M001", "Royal RY125A", 30.0, true, "Black", true, true, true, true, true);
        Vehicle truck = new Truck("T001", "Ford F-150", 100.0, true, "Blue", 1500.0, true, true, true, true);

        System.out.println("Created Vehicles:");
        System.out.println(car);
        System.out.println(motorcycle);
        System.out.println(truck);
        System.out.println();

        // Test Rental Calculations
        System.out.println("Testing Rental Calculations:");
        System.out.printf("Car Rental Cost (5 days): %.2f%n", car.calculateRentalCost(5));
        System.out.printf("Motorcycle Rental Cost (3 days): %.2f%n", motorcycle.calculateRentalCost(3));
        System.out.printf("Truck Rental Cost (7 days): %.2f%n", truck.calculateRentalCost(7));
        System.out.println();

        // Test Polymorphism
        System.out.println("Polymorphism Test:");
        Vehicle[] vehicles = { car, motorcycle, truck };
        for (Vehicle v : vehicles) {
            System.out.println("Rental Cost for 2 days: " + v.calculateRentalCost(2));
        }
        System.out.println();

        // Test Customer and Rental
        System.out.println("Testing Customer and Rentals:");
        Customers customer = new Customers("John Doe", 30, "CUST001", "1234567890", "DL12345", false, false);
        RentalAgency agency = new RentalAgency();

        // Add vehicles to the rental agency
        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
        agency.addVehicle(truck);

        // Renting a vehicle
        RentalTransaction transaction = agency.rentVehicle(customer, car, 5);
        if (transaction != null) {
            System.out.println("Rental Successful: " + transaction.getTransactionDetails());
        } else {
            System.out.println("Rental Failed");
        }

        // Returning the vehicle
        System.out.println("\nReturning Vehicle:");
        agency.returnVehicle(customer, car, transaction);
        System.out.println("Rental History for Customer:");
        customer.printRentalHistory();

        // Checking Vehicle Availability
        System.out.println("\nVehicle Availability:");
        System.out.println("Car Available: " + car.isAvailableForRental());
        System.out.println("Motorcycle Available: " + motorcycle.isAvailableForRental());
        System.out.println("Truck Available: " + truck.isAvailableForRental());

        // this tests T Encapsulation (Validation Example)
        System.out.println("\nTesting Encapsulation (Validation):");
        try {
            truck.setBaseRentalRate(-10); // Should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //   this is to print Final Details
        System.out.println("\nFinal Vehicle Details:");
        System.out.println(car);
        System.out.println(motorcycle);
        System.out.println(truck);
    }
}
