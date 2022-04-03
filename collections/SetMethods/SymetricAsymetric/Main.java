package collections.SetMethods.SymetricAsymetric;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        String[] divine = {"We", "Are", "Now", "Doing", "Set", "Operations"};
        String[] nature = {"Set", "Operations", "Now", "Duplicate"};
        Set<String> divineSet = new HashSet<>(Arrays.asList(divine));
        Set<String> natureSet = new HashSet<>(Arrays.asList(nature));

//      Doing Set union
        Set<String> unionSet = new HashSet<>(divineSet);
        unionSet.addAll(natureSet);
        System.out.println("Union operation on set:");
        unionSet.forEach(words -> System.out.print(" " + words));

//      Doing Set intersection
        Set<String> intersectionSet = new HashSet<>(divineSet);
        intersectionSet.retainAll(natureSet);
        System.out.println("\nIntersection operation on set:");
        intersectionSet.forEach(words -> System.out.print(" " + words));

//      Symmetric difference - removing intersection
        Set<String> symmetricSet = new HashSet<>(divineSet);
        symmetricSet.removeAll(natureSet);
        System.out.println("\nSymmetric difference - removing intersection on set:");
        symmetricSet.forEach(words -> System.out.print(" " + words));

//      Checking if a set contains all values in another set
        Set<String> containsAllSet = new HashSet<>(divineSet);
        if (containsAllSet.containsAll(natureSet)) {
            System.out.println("\ncontainsAllSet contains all the values in natureSet");
        } else {
            System.out.println("\ncontainsAllSet doesn't contains all the values in natureSet");
        }

        if (containsAllSet.containsAll(intersectionSet)) {
            System.out.println("containsAllSet contains all the values in intersectionSet");
        } else {
            System.out.println("containsAllSet doesn't contains all the values in intersectionSet");
        }
    }
}
