package org.example;

import org.example.Ticket;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket ticket1, Ticket ticket2) {

        int del1 = (ticket1.getTimeTo() - ticket1.getTimeFrom());
        int del2 = (ticket2.getTimeTo() - ticket2.getTimeFrom());

        if (del1 < del2) {
            return -1;
        } else if (del1 > del2) {
            return 1;
        } else {
            return 0;
        }
    }
}
