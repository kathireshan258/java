package collections.MapMethods;

import java.util.HashMap;

class MapMethods {

    public static void main(String[] args) {
        java.util.Map<String, String> language = new HashMap<>();
        language.put("Java", "Evergreen  programming language");
        language.put("Python", "The most simplistic programming language");
        System.out.println("Line 11: printing the return value of put(): " + language.put("Javascript","The most dynamic programming language"));
        language.put("Typescript", "Super Script of Javascript");
        System.out.println(language.get("Typescript"));

//      Overriding the already existing value for a key using put() method
        System.out.println("Line 16: printing the return value of put(): " + language.put("Typescript", "Advanced level of Javascript"));

//      Checking whether a key exist in a map
        if (language.containsKey("Javascript")) {
            System.out.println("Line 20: containsKey(): 'Javascript' Key already exist");
        } else {
            System.out.println("Line 21: containsKey(): 'Javascript' key doesn't exist");
        }

//      Checking whether a value exist in a map
        if (language.containsValue("Super Script of Javascript")) {
            System.out.println("Line 27: containsValue(): 'Super Script of Javascript' value already exist");
        } else {
            System.out.println("Line 29: containsValue(): 'Super Script of Javascript' value doesn't exist");
        }

//      Replacing a value in a map:
//      method1: replace("Key", "NewValue") : returns "OldValue" stored for the key in map
        System.out.println("Line 33: replace(\"Key\", \"NewValue\"): " + language.replace("Java", "Easiest programming language"));

//      method1: replace("Key", "OldValue", "NewValue") : returns "Boolean" value and change the "OldValue" to "NewValue"
//          only when the "OldValue" present in the map for the given "Key" is equal to the "OldValue" entered in the
//           replace() method
        if (language.replace("Python", "The most simplistic programming language",
                        "Easiest advanced programming language")) {
            System.out.println("Line 41: replace(\"Key\",\"OldValue\", \"NewValue\"):  " +
                    "\"The most simplistic programming language\" value replaced with " +
                    "\"Easiest advanced programming language\"");
        } else {
            System.out.println("Line 41: replace(\"Key\",\"OldValue\", \"NewValue\"):  " +
                    "\"The most simplistic programming language\" value doesn't match with the \"OldValue\" given to the" +
                    "replace() method");
        }

        for (String key: language.keySet()) {
            System.out.println("Line 51: output for keySet() method: " + key);
        }

        for (String val: language.values()) {
            System.out.println("Line 55: output for values() method: " + val);
        }

//      Removing a Key Value from map
//      method 1: remove("Key") : returns "Value for the Key" which we removed
        System.out.println("Line 60: output of replace(\"Key\"): " +
                language.remove("Javascript"));

//      method 2: remove("Key" ,"Value") : returns "boolean" value if the "Given value in the method matches with the
//       Value of the Key in the Map
        System.out.println("Line 65: output of replace(\"Key\"," +
                "\"Value\"): "+ language.remove("Typescript", "Advanced level of Javascript"));
    }
}
