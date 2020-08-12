package com.iqoption.repository;

import com.iqoption.domain.Ticket;
import com.iqoption.exception.NotFoundException;

public class TicketRepository {
    private Ticket[] items = new Ticket[0];

    public void save(Ticket item) {
        Ticket[] tmp = new Ticket[items.length + 1];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;

        items = tmp;
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
        if (items.length <= 0 || findByID(id) == null) {
            throw new NotFoundException("Ticket id=" + id + " not found");
        }

        Ticket[] tmp = new Ticket[items.length - 1];
        int index = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }


    public void removeAll() {
        items = new Ticket[0];
    }

    public Ticket[] getAll() {
        return items;
    }

}
