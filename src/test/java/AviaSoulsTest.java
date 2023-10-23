import org.example.AviaSouls;
import org.example.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AviaSoulsTest {

//    @Test
//    void testCompareTo1() {
//        AviaSouls souls = new AviaSouls();
//
//        Ticket ticket1 = new Ticket("spb", "msk", 5_000, 12, 14);
//        Ticket ticket2 = new Ticket("spb", "msk", 4_500, 12, 14);
//        Ticket ticket3 = new Ticket("spb", "msk", 4_500, 12, 14);
//
//        souls.add(ticket1);
//        souls.add(ticket2);
//        souls.add(ticket3);
//
//       Ticket[] expected = { ticket3, ticket2, ticket1 };
//       Ticket[] actual = souls.findAll();
//
//        Arrays.sort(expected);
//        Arrays.sort(actual);
//
//       Assertions.assertArrayEquals(expected, actual);
//    }

    @Test
    void testCompareTo() {
        AviaSouls souls = new AviaSouls();

        Ticket ticket1 = new Ticket("Spb", "Msk", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("Kursk", "Orel", 4_500, 2, 3);
        Ticket ticket3 = new Ticket("Ekb", "Kazan", 4_500, 17, 20);

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);

        int result1 = ticket1.compareTo(ticket2); // Сравниваем билет 1 и билет 2 = 1
        int result2 = ticket2.compareTo(ticket3); // Сравниваем билет 2 и билет 3 = 0
        int result3 = ticket3.compareTo(ticket1); // Сравниваем билет 3 и билет 1 = -1

//        Ticket[] expected = { ticket3, ticket2, ticket1 };
//        Ticket[] actual = souls.findAll();
//
//        Arrays.sort(expected);
//        Arrays.sort(actual);
//
//        Assertions.assertArrayEquals(expected, actual);

        System.out.println("Результат сравнения ticket1 и ticket2: " + result1);
        System.out.println("Результат сравнения ticket2 и ticket3: " + result2);
        System.out.println("Результат сравнения ticket3 и ticket1: " + result3);
    }

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
