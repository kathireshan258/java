package collections.SetMethods.Challenge1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still "Mars"

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still "Mars"

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still "Jupiter"

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still "Jupiter"

        tempMoon =  new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still "Jupiter"

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still "Jupiter"

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp  = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        System.out.println("============================\n*************************");
        System.out.println("Planets");
        planets.forEach( planet -> System.out.println("\t" + planet.getKey()));
        System.out.println("*************************\n============================");

        System.out.println("============================\n*************************");
        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of " + body.getKey());
        body.getSatellites().forEach(marsMoon -> System.out.println("\t" + marsMoon.getKey()));
        System.out.println("*************************\n============================");

        System.out.println("============================\n*************************");
        Set<HeavenlyBody> moons = new HashSet<>();
        planets.forEach(planet -> moons.addAll(planet.getSatellites()));
        System.out.println("All Moons");
        moons.forEach(moon -> System.out.println("\t" + moon.getKey()));
        System.out.println("*************************\n============================");

        HeavenlyBody pluto = new Planet("Pluto", 842);
        planets.add(pluto);

        System.out.println("============================\n*************************");
//        planets.forEach(planet -> System.out.println(
//                planet.getName() + ": " + planet.getOrbitalPeriod()
//        ));

        planets.forEach(System.out::println);

        // Since we have overwritten the toString() method in HeavenlyBody class,
        // we have shortern the above method & just written one println in the planets.forEach()
        // i.e., re written the above last commented lines to a single line -> planets.forEach(System.out::println)
        System.out.println("*************************\n============================");

        System.out.println("============================\n*************************");
        HeavenlyBody earth1 = new Planet("Earth", 365);
        HeavenlyBody earth2 = new Planet("Earth", 365);
        System.out.println("obj earth1 is equal to earth2: " + earth1.equals(earth2));
        System.out.println("obj earth2 is equal to earth1: " + earth2.equals(earth1));
        System.out.println("obj pluto is equal to earth1: " + pluto.equals(earth1));
        System.out.println("obj earth is equal to pluto: " + earth1.equals(pluto));
        System.out.println("*************************\n============================");

        System.out.println("============================\n*************************");
        System.out.println("Previous value for Pluto in solar system map -> " + solarSystem.put(pluto.getKey(), pluto));
        System.out.println("New value for Pluto in solar system map -> " +
                solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.PLANET)));

        pluto = new DwarfPlanet("Pluto", 842);
        System.out.println(planets.add(pluto) ? "Pluto previously doesn't exist in planets set, now it's added"
                : "Pluto already exist in planets set");

        solarSystem.put(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET), pluto);
        planets.add(pluto);
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));
        System.out.println("*************************\n============================");

        System.out.println("============================\n*************************");
        System.out.println("The solar system contains: ");
        solarSystem.values().forEach(value -> System.out.println("\t" + value));
        System.out.println("*************************\n============================");
    }
}
