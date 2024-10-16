import java.util.TreeSet;
import java.util.Comparator;

public class TreeSetExample {
    public static void main(String[] args) {
        // Creating a TreeSet with natural ordering
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Cherry");

        // Iterating over the TreeSet
        System.out.println("TreeSet with natural ordering:");
        for (String fruit : treeSet) {
            System.out.println(fruit);
        }

        // Creating a TreeSet with custom comparator (reverse order)
        TreeSet<String> customTreeSet = new TreeSet<>(Comparator.reverseOrder());
        customTreeSet.add("Apple");
        customTreeSet.add("Banana");
        customTreeSet.add("Cherry");

        // Iterating over the TreeSet with custom comparator
        System.out.println("\nTreeSet with custom comparator (reverse order):");
        for (String fruit : customTreeSet) {
            System.out.println(fruit);
        }
    }
}
