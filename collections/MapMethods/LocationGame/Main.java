package collections.MapMethods.LocationGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of the system learning java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small bridge"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("EAST", "E");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");

        locations.get(1).addExists("W", 2);
        locations.get(1).addExists("E", 3);
        locations.get(1).addExists("S",4);
        locations.get(1).addExists("N",5);

        locations.get(2).addExists("N", 5);

        locations.get(3).addExists("W", 1);

        locations.get(4).addExists("N", 1);
        locations.get(4).addExists("W", 2);

        locations.get(5).addExists("S", 1);
        locations.get(5).addExists("W", 2);

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDiscription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExists();
            System.out.println("Available exits are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                    }
                }
            }
            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
