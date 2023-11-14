import java.io.File;
import java.util.*;

public class Problem2 {
    public static void main(String[] args) throws Exception {
        File f = new File("input2.txt");
        Scanner scan = new Scanner(f);
        int len = Integer.parseInt(scan.nextLine().trim());
        String s = scan.nextLine().trim();
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
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {

                if (o1.getValue() > o2.getValue()) return -1;
                if (o2.getValue() > o1.getValue()) return 1;
                if (o1.getKey() > o2.getKey()) return 1;
                if (o2.getKey() > o1.getKey()) return -1;
                return 0;
            }
        });
        //System.out.println(list); // debug
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getValue(); j++) {
                System.out.print(list.get(i).getKey());
            }
        }
    }
}
