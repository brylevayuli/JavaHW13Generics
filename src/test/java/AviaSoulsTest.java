import org.example.AviaSouls;
import org.example.Ticket;
import org.example.TicketTimeComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AviaSoulsTest {

    @Test
    void sortByPrice3() {

        AviaSouls souls = new AviaSouls();

        Ticket ticket1 = new Ticket("Spb", "Msk", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("Kursk", "Orel", 2_500, 2, 3);
        Ticket ticket3 = new Ticket("New-York", "Msk", 31_500, 3, 17);
        Ticket ticket4 = new Ticket("Spb", "Msk", 6_000, 12, 14);
        Ticket ticket5 = new Ticket("Ekb", "Kazan", 4_500, 17, 20);
        Ticket ticket6 = new Ticket("Spb", "Msk", 4_500, 12, 14);

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);

        Ticket[] expected = { ticket6, ticket1, ticket4 };
        Ticket[] actual = souls.search( "Spb", "Msk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortByPrice1() {

        AviaSouls souls = new AviaSouls();

        Ticket ticket1 = new Ticket("Kazan", "Msk", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("Kursk", "Orel", 2_500, 2, 3);
        Ticket ticket3 = new Ticket("New-York", "Msk", 31_500, 3, 17);
        Ticket ticket4 = new Ticket("Spb", "Msk", 6_000, 12, 14);
        Ticket ticket5 = new Ticket("Ekb", "Kazan", 4_500, 17, 20);
        Ticket ticket6 = new Ticket("Kursk", "Msk", 4_500, 12, 15);

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);

        Ticket[] expected = { ticket4 };
        Ticket[] actual = souls.search( "Spb", "Msk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortByPrice0() {

        AviaSouls souls = new AviaSouls();

        Ticket ticket1 = new Ticket("Omsk", "Msk", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("Kursk", "Orel", 2_500, 2, 3);
        Ticket ticket3 = new Ticket("New-York", "Msk", 41_500, 3, 17);
        Ticket ticket4 = new Ticket("Orel", "Msk", 6_000, 14, 16);
        Ticket ticket5 = new Ticket("Ekb", "Kazan", 4_500, 17, 20);
        Ticket ticket6 = new Ticket("Vladivostok", "Msk", 25_500, 9, 22);

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);

        Ticket[] expected = { };
        Ticket[] actual = souls.search( "Spb", "Msk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortByTime3() {

        AviaSouls souls = new AviaSouls();

        Ticket ticket1 = new Ticket("Spb", "Msk", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("Kursk", "Orel", 2_500, 2, 3);
        Ticket ticket3 = new Ticket("New-York", "Msk", 31_500, 3, 17);
        Ticket ticket4 = new Ticket("Spb", "Msk", 6_000, 13, 14);
        Ticket ticket5 = new Ticket("Ekb", "Kazan", 4_500, 17, 20);
        Ticket ticket6 = new Ticket("Spb", "Msk", 4_500, 15, 18);

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = { ticket4, ticket1, ticket6 };
        Ticket[] actual = souls.searchAndSortBy( "Spb", "Msk", comparator );

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortByTime1() {

        AviaSouls souls = new AviaSouls();

        Ticket ticket1 = new Ticket("Kazan", "Msk", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("Kursk", "Orel", 2_500, 2, 3);
        Ticket ticket3 = new Ticket("New-York", "Msk", 31_500, 3, 17);
        Ticket ticket4 = new Ticket("Spb", "Msk", 6_000, 12, 14);
        Ticket ticket5 = new Ticket("Ekb", "Kazan", 4_500, 17, 20);
        Ticket ticket6 = new Ticket("Kursk", "Msk", 4_500, 12, 15);

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = { ticket4 };
        Ticket[] actual = souls.searchAndSortBy( "Spb", "Msk", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void sortByTime0() {

        AviaSouls souls = new AviaSouls();

        Ticket ticket1 = new Ticket("Omsk", "Msk", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("Kursk", "Orel", 2_500, 2, 3);
        Ticket ticket3 = new Ticket("New-York", "Msk", 41_500, 3, 17);
        Ticket ticket4 = new Ticket("Orel", "Msk", 6_000, 14, 16);
        Ticket ticket5 = new Ticket("Ekb", "Kazan", 4_500, 17, 20);
        Ticket ticket6 = new Ticket("Vladivostok", "Msk", 25_500, 9, 22);

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = { };
        Ticket[] actual = souls.searchAndSortBy( "Spb", "Msk", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }


}
