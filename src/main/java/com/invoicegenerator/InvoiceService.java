package com.invoicegenerator;

public class InvoiceService {
    private RideRepository rideRepository;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(Ride ride) {
        return Math.max(ride.rideCategory.minFare,
                ride.getDistance() * ride.rideCategory.costPerKm + ride.getTime() * ride.rideCategory.costPerTime);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] ride) {
        rideRepository.addRide(userId, ride);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}