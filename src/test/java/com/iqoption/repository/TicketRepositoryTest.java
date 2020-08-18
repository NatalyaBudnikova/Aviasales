package com.iqoption.repository;

import com.iqoption.domain.Ticket;
import com.iqoption.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();
    Ticket ticket1 = new Ticket(1, 3000, "LED", "LCA", 300);
    Ticket ticket2 = new Ticket(2, 2500, "LCA", "LED", 400);
    Ticket ticket3 = new Ticket(3, 1500, "LED", "LCA", 600);
    Ticket ticket4 = new Ticket(4, 2300, "ASA", "DME", 550);

    @BeforeEach
    void setUp() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
    }

    @Test
    void removeById() {
        repository.removeById(2);
        assertNull(repository.findByID(2));
    }

    @Test
    void removeAll() {
        repository.removeAll();
        Ticket[] expected = {};
        assertArrayEquals(expected, repository.getAll().toArray());
    }

    @Test
    void findById() {
        assertEquals(ticket2, repository.findByID(2));
    }

    @Test
    void findByIdNotFind() {
        assertNull(repository.findByID(5));
    }


}