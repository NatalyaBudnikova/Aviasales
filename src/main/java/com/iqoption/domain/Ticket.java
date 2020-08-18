package com.iqoption.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket implements Comparable<Ticket>{
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int flightTime;

    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }
}
