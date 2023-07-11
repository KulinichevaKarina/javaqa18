import org.example.AviaSouls;
import org.example.Ticket;
import org.example.TicketTimeComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    @Test
    public void TicketAddTest() {
        AviaSouls manager = new AviaSouls();

        Ticket t1 = new Ticket("Москва", "Сочи", 12_000, 10, 14);
        Ticket t2 = new Ticket("Москва1", "Сочи1", 16_000, 8, 12);
        Ticket t3 = new Ticket("Москва2", "Сочи2", 15_000, 15, 19);
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);

        Assertions.assertArrayEquals(new Ticket[]{t1, t2, t3}, manager.findAll());
    }

    @Test
    public void TicketPriceTest() {
        Ticket ticket1 = new Ticket("Москва", "Сочи", 12_000, 10, 14);
        Ticket ticket2 = new Ticket("Москва1", "Сочи1", 16_000, 8, 12);
        Ticket ticket3 = new Ticket("Москва2", "Сочи2", 12_000, 15, 19);

        Assertions.assertEquals(-1, ticket1.compareTo(ticket2));
        Assertions.assertEquals(1, ticket2.compareTo(ticket1));
        Assertions.assertEquals(0, ticket1.compareTo(ticket3));
        Assertions.assertEquals(0, ticket3.compareTo(ticket1));

    }

    @Test
    public void TicketSearchComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Сочи", 12_000, 10, 14);
        Ticket ticket2 = new Ticket("Москва", "Сочи", 11_000, 11, 15);
        Ticket ticket3 = new Ticket("Москва", "Новороссийск", 11_000, 11, 15);
        Ticket ticket4 = new Ticket("Москва", "Сочи", 16_000, 8, 12);
        Ticket ticket5 = new Ticket("Москва", "Санкт-Петербург", 11_000, 11, 15);
        Ticket ticket6 = new Ticket("Москва", "Сочи", 17_000, 1, 5);
        Ticket ticket7 = new Ticket("Москва", "Симферополь", 11_000, 11, 15);
        Ticket ticket8 = new Ticket("Москва", "Сочи", 15_000, 3, 7);
        Ticket ticket9 = new Ticket("Москва", "Тюмень", 11_000, 11, 15);
        Ticket ticket10 = new Ticket("Москва", "Сочи", 13_000, 15, 19);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);


        Ticket[] tickets = {ticket2, ticket1, ticket10, ticket8, ticket4, ticket6};
        Assertions.assertArrayEquals(tickets, manager.search("Москва", "Сочи"));

        Ticket[] ticket = {ticket9};
        Assertions.assertArrayEquals(ticket, manager.search("Москва", "Тюмень"));

        Assertions.assertEquals(null, manager.search("Москва", "Краснодар"));



    }

    @Test
    public void TimeCompareTest() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        Ticket t1 = new Ticket("Москва", "Сочи", 12_000, 10, 14);
        Ticket t2 = new Ticket("Москва", "Сочи", 16_000, 9, 12);
        Ticket t3 = new Ticket("Москва", "Сочи", 13_000, 19, 23);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);

        Assertions.assertArrayEquals(new Ticket[]{t2, t1, t3}, manager.searchAndSortBy("Москва", "Сочи", comparator));
    }


}
