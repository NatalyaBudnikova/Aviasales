package com.iqoption.repository;

import com.iqoption.domain.Ticket;
import com.iqoption.exception.NotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TicketRepository {
    private List<Ticket> items = new LinkedList<>();

    public void save(Ticket item) {
        items.add(item);
    }

    public Ticket findByID(int id) {
        Ticket findItem = null;
        for (Ticket item : items) {
            if (item.getId() == id) {
                findItem = item;
                break;
            }
        }
        return findItem;
    }

    public void removeById(int id) {
        items.removeIf((i) -> i.getId() == id);
    }


    public void removeAll() {
        items.clear();
    }

    public List<Ticket> getAll() {
        return items;
    }

}
