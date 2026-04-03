import java.util.*;

public class ComplexMap {

    static HashMap<String, List<String>> friendsMap = new HashMap<>();

    
    static void addFriend(String person1, String person2) {

        friendsMap.putIfAbsent(person1, new ArrayList<>());
        if (!friendsMap.get(person1).contains(person2)) {
            friendsMap.get(person1).add(person2);
        }

        friendsMap.putIfAbsent(person2, new ArrayList<>());
        if (!friendsMap.get(person2).contains(person1)) {
            friendsMap.get(person2).add(person1);
        }

        System.out.println("✔ Added friendship: " + person1 + " ↔ " + person2);
    }

   
    static void removeFriend(String person1, String person2) {

        boolean removed = false;

        if (friendsMap.containsKey(person1)) {
            removed = friendsMap.get(person1).remove(person2);
        }

        
        if (friendsMap.containsKey(person2)) {
            friendsMap.get(person2).remove(person1);
        }

        if (removed) {
            System.out.println("✖ Removed friendship: " + person1 + " ↔ " + person2);
        } else {
            System.out.println("⚠ Friendship not found: " + person1 + " ↔ " + person2);
        }
    }

   
    static void printMap() {
        System.out.println("\n┌─────────────────────────────────┐");
        System.out.println("│           Friends Map            │");
        System.out.println("└─────────────────────────────────┘");
        if (friendsMap.isEmpty()) {
            System.out.println("  (empty)");
        } else {
            for (Map.Entry<String, List<String>> entry : friendsMap.entrySet()) {
                System.out.println("  " + entry.getKey() + " → " + entry.getValue());
            }
        }
        System.out.println();
    }

  
    public static void main(String[] args) {

  
        System.out.println("=== Adding Friends ===");
        addFriend("Omar",   "Elnur");
        addFriend("Shahin",   "Ravan");
        addFriend("Artogrul",   "Saleh");

        printMap();

        System.out.println("=== Adding Duplicate (ignored) ===");
        addFriend("Ali", "Sadi");   

        printMap();

        System.out.println("=== Removing Friends ===");
        removeFriend("Ali",  "Sadi");   
        removeFriend("Ali",  "Sadi");   

        printMap();
    }
}