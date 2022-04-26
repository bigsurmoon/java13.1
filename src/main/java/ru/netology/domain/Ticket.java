package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String flightFrom;
    private String flightTo;
    private int travelTime;

    public Ticket(int id, int price, String flightFrom, String flightTo, int travelTime) {
        this.id = id;
        this.price = price;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.price - o.price;
    }
}