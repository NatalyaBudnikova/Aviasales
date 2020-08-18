package com.iqoption.manager;

import com.iqoption.comparator.TicketByFlightTimeComparator;
import com.iqoption.domain.Ticket;
import com.iqoption.repository.TicketRepository;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket item) {
        repository.save(item);
    }

    public  void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public Ticket findById(int id) {
        return repository.findByID(id);
    }

    public Ticket[] findAll(String from, String to) {
        Collection <Ticket> items = repository.getAll();
        Ticket[] result = new Ticket[0];
        for (Ticket item : items) {
            if (matches(item, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Collection <Ticket> items = repository.getAll();
        Ticket[] result = new Ticket[0];
        for (Ticket item : items) {
            if (matches(item, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    private boolean matches(Ticket item, String from, String to) {
        return item.getDepartureAirport().equalsIgnoreCase(from) && item.getArrivalAirport().equalsIgnoreCase(to);
    }

}

