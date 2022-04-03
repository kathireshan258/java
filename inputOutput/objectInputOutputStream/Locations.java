package inputOutput.objectInputOutputStream;

import java.io.*;
import java.util.*;

class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    static {

       try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read Location " + location.getLocationID() + ": " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exists");

                    locations.put(location.getLocationID(), location);
                } catch (InvalidClassException ic) {
                    System.out.println("Invalid class Exception: " + ic.getMessage());
                } catch (ClassNotFoundException ce){
                    System.out.println("Class Not Found Exception " + ce.getMessage());
                } catch (EOFException eo) {
                    eof = true;
                }
            }
       } catch (IOException e) {
           System.out.println();
       }

    }

    public static void main(String[] args) throws IOException {
//        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
//             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
//            for (Location location :
//                    locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String direction :
//                        location.getExits().keySet()) {
//                    dirFile.write(location.getLocationID() + "," + direction + "," +
//                        location.getExits().get(direction) + "\n");
//                }
//            }
//        }

        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream (new FileOutputStream("locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
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
