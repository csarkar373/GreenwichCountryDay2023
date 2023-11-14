import java.io.File;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) throws Exception {
        File f = new File("input3.txt");
        Scanner scan = new Scanner(f);
        double c = Double.parseDouble(scan.nextLine().trim());
        int len = Integer.parseInt(scan.nextLine().trim());
        int[] temps = new int[len];
        String[] tokens = scan.nextLine().split(",");
        for (int i = 0; i < tokens.length; i++) {
            temps[i] = Integer.parseInt(tokens[i].trim());
            //System.out.println(temps[i]);
        }
        double answer = 0.0;
        for (int i = 0; i < len; i++) {
            double next = (temps[i] * temps[i] / 100.0) * 0.01 * c * 18.0;
            //System.out.println(next);
            answer += next;
        }
        System.out.println((int)Math.ceil(answer));
    }
}
