package inputOutput.bufferReaderChallenge;

import java.io.*;
import java.util.*;

class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    static {
        Scanner scanner = null;

//        Below Try method uses BufferedReader along with FileReader method to get the data.

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("locations.txt")));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + ":" + description);
                Map<String, Integer> tempExits = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExits));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

//        Below try method uses BufferedReader to read the input

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String direction = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dest = scanner.nextLine();
//                int destination = Integer.parseInt(dest);

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }

//          Below try method uses another way of using BufferedReader to read the data from the file
//
//            try (BufferedReader dirFile = new BufferedReader(new FileReader("directions.txt"))) {
//                String input;
//                while ((input = dirFile.readLine()) != null) {
//                    String[] data = input.split(",");
//                    int loc = Integer.parseInt(data[0]);
//                    String direction = data[1];
//                    int destination = Integer.parseInt(data[2]);
//                    System.out.println(loc + ": " + direction + ": " + destination);
//                    Location location = locations.get(loc);
//                    location.addExit(direction, destination);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
            for (Location location :
                    locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction :
                        location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," +
                        location.getExits().get(direction) + "\n");
                }
            }
        }
    }
        @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
