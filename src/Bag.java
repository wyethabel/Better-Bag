/* Bag type data structure built around a HashMap,
   where keys are item names and values represent
   the number of that item in the bag.
*/

import java.util.*;

public class Bag {
    private HashMap<String, Integer> contents;

    public Bag() {
        this.contents = new HashMap<>();
    }

    // Allows for the insertion of multiple items by name using variable arguments.
    public void add(String... items) {
        for (String i : items) {
            this.contents.put(i, this.contents.getOrDefault(i, 0) + 1);
        }
    }

    // Allows for the removal of an item by name.
    public void remove(String item) {
        if (!contents.containsKey(item)) {
            System.out.println("The bag does not contain this item.");
            return;
        }
        /* Check that the value can be removed and delete the key
           if value == 1 on call due to the lambda returning null.
         */
        contents.computeIfPresent(item, (key, value) -> (value > 1) ? value - 1 : null);
    }

    // Prints the entire contents of the bag.
    public void printContents() {
        if (contents.isEmpty()) {
            System.out.println("The bag is currently empty.");
        } else {
            System.out.println(contents);
        }
    }

    // Checks if a specific item is contained in the bag.
    public boolean contains(String item) {
        return contents.containsKey(item);
    }

    // Returns the number of times an item appears in the bag.
    public int count(String item) {
        return contents.getOrDefault(item, 0);
    }

    // Returns the total number of items in the bag.
    public int size() {
        int tempSize = 0;
        for (int i : contents.values()) {
            tempSize = tempSize + i;
        }
        return tempSize;
    }

    // Local isEmpty() method to support the merge method below.
    private boolean isEmpty() {
        return contents.isEmpty();
    }

    // merges the contents of the supplied bag into the bag this method is used on.
    public void merge(Bag inputBag) {
        if (inputBag.isEmpty()) {
            System.out.println("This bag is currently empty and has nothing to merge.");
            return;
        }
        try {
            /* For each Map.entry object in a set of key value pairs from the input bag,
               check if this key already exists, or default new keys to 0, adding the count to that key.
             */
            for (Map.Entry<String, Integer> i : inputBag.contents.entrySet()) {
                this.contents.put(i.getKey(), this.contents.getOrDefault(i.getKey(), 0) + i.getValue());
            }
            System.out.println("Merge completed.");
        } catch (Exception e) {
            System.out.println("Unable to merge due to error: " + e.getMessage());
        }
        // Implement method for clean-up of the inputBag?
    }

    /* Returns a new bag without duplicates. Did not include an empty check as this
       can also return a new empty bag if necessary.
     */
    public Bag distinct() {
        Bag tempBag = new Bag();
        for (String i : contents.keySet()) {
            tempBag.add(i);
        }
        return tempBag;
    }
}
