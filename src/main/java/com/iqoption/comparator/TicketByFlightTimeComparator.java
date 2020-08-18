package com.iqoption.comparator;

import com.iqoption.domain.Ticket;

import java.util.Comparator;

public class TicketByFlightTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getFlightTime() - o2.getFlightTime();
    }
}
