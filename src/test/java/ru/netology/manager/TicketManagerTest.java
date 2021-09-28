package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager ticketManager = new TicketManager(repository);
    private Ticket first = new Ticket(1, 14271, "LED", "VVO", 19);
    private Ticket second = new Ticket(2, 14799, "LED", "VVO", 14);
    private Ticket third = new Ticket(3, 14217, "LED", "VVO", 20);
    private Ticket forth = new Ticket(4, 6229, "LED", "OVB", 4);


    @BeforeEach
    void setUp() {
        ticketManager.add(first);
        ticketManager.add(second);
        ticketManager.add(third);
        ticketManager.add(forth);
    }

    @Test
    public void shouldSearchByExist() {
        Ticket[] actual = ticketManager.searchBy("LED", "VVO");
        Ticket[] expected = new Ticket[]{third, first, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFound() {
        Ticket[] actual = ticketManager.searchBy("LED", "ARH");
        Ticket[] expected = new Ticket[]{};

        assertArrayEquals(expected, actual);
    }
}