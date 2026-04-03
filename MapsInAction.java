import java.util.*;

public class MapsInAction {
    public static void main(String[] args) {

       
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║         HASH MAP             ║");
        System.out.println("╚══════════════════════════════╝");
        Map<String, Integer> hashMap = new HashMap<>();
        fillMap(hashMap);
        printAll(hashMap);

        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║       LINKED HASH MAP        ║");
        System.out.println("╚══════════════════════════════╝");
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        fillMap(linkedHashMap);
        printAll(linkedHashMap);

        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║    TREE MAP (Natural Order)  ║");
        System.out.println("╚══════════════════════════════╝");
        Map<String, Integer> treeMap = new TreeMap<>();
        fillMap(treeMap);
        printAll(treeMap);

        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║  TREE MAP (Reverse / Z → A)  ║");
        System.out.println("╚══════════════════════════════╝");
        Map<String, Integer> reverseTreeMap = new TreeMap<>(Comparator.reverseOrder());
        fillMap(reverseTreeMap);
        printAll(reverseTreeMap);

    
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║  SORTED BY AGE (Descending)  ║");
        System.out.println("╚══════════════════════════════╝");

        Map<String, Integer> ages = new HashMap<>();
        fillMap(ages);

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(ages.entrySet());
        entryList.sort((e1, e2) -> e2.getValue() - e1.getValue());

        Map<String, Integer> sortedByAge = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedByAge.put(entry.getKey(), entry.getValue());
        }

        System.out.println("1. Enhanced for loop:");
        for (Map.Entry<String, Integer> entry : sortedByAge.entrySet()) {
            System.out.println("   " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    static void fillMap(Map<String, Integer> map) {
        map.put("Omar", 20);
        map.put("Elnur",   18);
        map.put("Elvin",     19);
        map.put("Ziya",     23);
        map.put("Ebdulsaksuka",   43);
        map.put("QocaIhtiyar",  71);
        map.put("OlecekKisi",     101);
    }

    static void printAll(Map<String, Integer> map) {

        System.out.println("\n1. Enhanced for loop:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("   " + entry.getKey() + " -> " + entry.getValue());
        }

        
        System.out.println("\n2. Iterator:");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("   " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n3. toString():");
        System.out.println("   " + map.toString());
    }
}