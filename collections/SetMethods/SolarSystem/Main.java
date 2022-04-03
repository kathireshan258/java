package collections.SetMethods.SolarSystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        System.out.println("Planets");
        planets.forEach(planet -> System.out.println("\t" + planet.getName()));

        HeavenlyBody body = solarSystem.get("Earth");
        System.out.println("Moon of " + body.getName());
        body.getSatellites().forEach(earthMoon -> System.out.println("\t" + earthMoon.getName()));

        Set<HeavenlyBody> moons = new HashSet<>();
        planets.forEach(planet -> moons.addAll(planet.getSatellites()));
        System.out.println("All moons");
        moons.forEach(moon -> System.out.println("\t" + moon.getName()));
    }
}
