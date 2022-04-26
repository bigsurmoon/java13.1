package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.TicketRepository;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);
    private Ticket first = new Ticket(1, 30000, "JFK", "DME", 600);
    private Ticket second = new Ticket(2, 29000, "JFK", "DME", 600);
    private Ticket third = new Ticket(3, 15000, "JFK", "DME", 600);
    private Ticket fourth = new Ticket(4, 37000, "SVO", "VVO", 500);
    private Ticket fifth = new Ticket(5, 25000, "JFK", "DME", 600);
    private Ticket sixth = new Ticket(6, 34000, "SVO", "VVO", 500);
    private Ticket seventh = new Ticket(7, 14500, "SVO", "VVO", 500);
    private Ticket eights = new Ticket(8, 20000, "SVO", "VVO", 500);

    @BeforeEach
    public void SetUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eights);
    }

    @Test
    public void removeNonExistingId() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(9);
        });
    }

    @Test
    public void removeExistingId() {
        repository.removeById(2);
        assertArrayEquals(new Ticket[]{first, third, fourth, fifth, sixth, seventh, eights}, repository.findAll());
    }

    @Test
    public void shouldSearchFlightFromSvoToVvo() {
        Ticket[] actual = manager.searchBy("SVO", "VVO");
        Ticket[] expected = new Ticket[]{seventh, eights, sixth, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFlightFromJfkToDme() {
        Ticket[] actual = manager.searchBy("JFK", "DME");
        Ticket[] expected = new Ticket[]{third, fifth, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchWithoutMatch() {
        Ticket[] actual = manager.searchBy("OSL", "BER");
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(expected, actual);
    }
}