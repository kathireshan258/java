package collections.MapMethods.LocationGame;

import java.util.HashMap;
import java.util.Map;

class Location {
    private final int locationId;
    private final String discription;
    private final Map<String, Integer> exists;

    public Location(int locationId, String discription) {
        this.locationId = locationId;
        this.discription = discription;
        this.exists = new HashMap<>();
        this.exists.put("Q", 0);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDiscription() {
        return discription;
    }

    public void addExists(String direction, int location) {
        exists.put(direction, location);
    }

    public Map<String, Integer> getExists() {
        return new HashMap<>(this.exists);
    }
}
