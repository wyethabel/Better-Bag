/* Main runner method to check bag
   functionality with a selection of tests.
 */

public class Main {
    public static void main(String[] args) {
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();
        bag1.add("Shoe", "Shoe", "Glasses", "Shirt", "Hat", "Shirt");
        bag2.add("Glasses", "Shoe", "Shoe", "Hoodie", "Sweatpants");
        System.out.println("Items in bag 1: " + bag1.size());
        System.out.println("Items in bag 2: " + bag2.size());
        bag1.merge(bag2);
        bag1.printContents();
        Bag bag3 = bag1.distinct();
        bag3.printContents();
    }
}
