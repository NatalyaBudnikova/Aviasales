package com.iqoption.manager;

import com.iqoption.comparator.TicketByFlightTimeComparator;
import com.iqoption.domain.Ticket;
import com.iqoption.repository.TicketRepository;
import com.iqoption.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketManager manager = new TicketManager(new TicketRepository());
    Ticket ticket1 = new Ticket(1, 3000, "LED", "LCA", 300);
    Ticket ticket2 = new Ticket(2, 2500, "LCA", "LED", 400);
    Ticket ticket3 = new Ticket(3, 1500, "LED", "LCA", 600);
    Ticket ticket4 = new Ticket(4, 2300, "ASA", "DME", 550);
    TicketByFlightTimeComparator comparator = new TicketByFlightTimeComparator();

    @BeforeEach
    void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
    }

    @Test
    void findById() {
        assertEquals(ticket2, manager.findById(2));
    }

    @Test
    void findByIdNull() {
        assertNull(manager.findById(15));
    }

    @Test
    void removeAll() {
        Ticket[] expected = {};
        manager.removeAll();
        assertArrayEquals(expected, manager.findAll("led", "lca", comparator));
    }

    @Test
    void removeById() {
        Ticket[] expected = {ticket1};
        manager.removeById(3);
        assertArrayEquals(expected, manager.findAll("led", "lca", comparator));
    }

    @Test
    void findAll() {
        Ticket[] expected = {ticket1, ticket3};
        assertArrayEquals(expected, manager.findAll("led", "lca", comparator));
    }

    @Test
    void findAllNotFound() {
        Ticket[] expected = {};
        assertArrayEquals(expected, manager.findAll("led", "vn", comparator));
    }


}