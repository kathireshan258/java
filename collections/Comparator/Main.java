package collections.Comparator;

import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        Theater theater = new Theater("Olympian", 8, 12);
//        theater.getSeats();
        if (theater.reserveSeat("H11")) {
            System.out.println("please Pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        List<Theater.Seat> priceSeat = new ArrayList<>(theater.getSeats());
        priceSeat.add(theater.new Seat("B00", 13));
        priceSeat.add(theater.new Seat("A00", 13));
        priceSeat.sort(Theater.Seat.PRICE_ORDER); //this can be written as --> Collections.sort(price, Theater.PRICE_ORDER);
        printList(priceSeat);
    }

    public static void printList(List<Theater.Seat> list) {
        for (Theater.Seat seat : list) {
            System.out.println(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
    }
}
