package collections.Comparator;

import java.util.*;

class Theater {
    private final String theaterName;
    private final List<Seat> seats = new ArrayList<>();

//    Here the below comparator can be written in Theater class which controls the innerclass Seat, or we can add it in
//    innerclass Seat also
//    static final Comparator<Seat> PRICE_ORDER;
//
//    static {
//        PRICE_ORDER = new Comparator<Seat>() {
//            @Override
//            public int compare(Seat seat1, Seat seat2) {
//                return Double.compare(seat1.getPrice(), seat2.getPrice());
//
//                Above Double.compare can be replaced with below also
//                if (seat1.getPrice() < seat2.getPrice()) {
//                    return -1;
//                } else if (seat1.getPrice() > seat2.getPrice()) {
//                    return 1;
//                } else {
//                    return 0;
//                }
//            }
//        };
//    }

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12;
                if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14;
                } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheaterName() {
        return this.theaterName;
    }

    public boolean reserveSeat(String seatNumber) {
//        Seat requestedSeat = null;
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(this.seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return this.seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

//        for (Seat seat : this.seats) {
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if (requestedSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//
//        return requestedSeat.reserve();


        //Binary Search method done inside
        /*int low = 0;
        int high = this.seats.size()-1;

        while (low <= high) {
            System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid -1;
            } else {
                return seats.get(mid).reserve();
            }
        }*/
    }

    //testing purpose
    /*public void getSeats() {
        for (Seat seat : this.seats) {
            System.out.println(seat.getSeatNumber());
        }
    }*/

    public Collection<Seat> getSeats() {
        return this.seats;
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;
        private final double price;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + this.seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + this.seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return this.seatNumber;
        }

        public double getPrice() {
            return this.price;
        }

        static final Comparator<Seat> PRICE_ORDER;

        static {
            PRICE_ORDER = new Comparator<Seat>() {
                @Override
                public int compare(Seat seat1, Seat seat2) {
                    return Double.compare(seat1.getPrice(), seat2.getPrice());

//                Above Double.compare can be replaced with below also
//                if (seat1.getPrice() < seat2.getPrice()) {
//                    return -1;
//                } else if (seat1.getPrice() > seat2.getPrice()) {
//                    return 1;
//                } else {
//                    return 0;
//                }
                }
            };
        }
    }
}