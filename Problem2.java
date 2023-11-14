import java.io.File;
import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int len = Integer.parseInt(scan.nextLine());
        String s = scan.nextLine();
        // make a map that is a frequency counter
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (m.containsKey(c)) {
                m.put(c, m.get(c)+1);
            } else {
                m.put(c, 1);
            }
        }
        // put the map entries into an arralist and do a two-level sort on them
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(m.entrySet());
        // System.out.println(list); // debug
        Comparator<Map.Entry<Character, Integer>> c = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {

                if (o1.getValue() > o2.getValue()) return -1;
                if (o2.getValue() > o1.getValue()) return 1;
                if (o1.getKey() > o2.getKey()) return 1;
                if (o2.getKey() > o1.getKey()) return -1;
                return 0;
            }
        };
        Collections.sort(list, c); 
        //System.out.println(list); // debug
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getValue(); j++) {
                System.out.print(list.get(i).getKey());
            }
        }
    }
}
