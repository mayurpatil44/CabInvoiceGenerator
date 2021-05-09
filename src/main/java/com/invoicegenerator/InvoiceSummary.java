package com.invoicegenerator;

public class InvoiceSummary {
    public int numOfRides;
    public double totalFare;
    public double avgFare;

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.avgFare = this.totalFare / this.numOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return (numOfRides == that.numOfRides) && Double.compare(that.totalFare, totalFare) == 0
                && Double.compare(that.avgFare, avgFare) == 0;
    }
}