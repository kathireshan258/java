package collections.ImmutableClass;

import java.util.HashMap;
import java.util.Map;

class Location {
    private final int locationId;
    private final String discription;
    private final Map<String, Integer> exists;

    public Location(int locationId, String discription, Map<String, Integer> exists) {
        this.locationId = locationId;
        this.discription = discription;
        if (exists != null) {
            this.exists = new HashMap<>(exists);
        } else {
            this.exists = new HashMap<>();
        }

        this.exists.put("Q", 0);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDiscription() {
        return discription;
    }

    public Map<String, Integer> getExists() {
        return new HashMap<>(this.exists);
    }
}
