import java.io.File;
import java.util.Scanner;

public class Problem1 {
    public static void main(String [] args) throws Exception {
        File f = new File("input1.txt");
        Scanner scan = new Scanner(f);
        int m1 = Integer.parseInt(scan.nextLine());
        int m2 = Integer.parseInt(scan.nextLine());
        int percent = Integer.parseInt(scan.nextLine());
        double total = (m1 + m2) + percent/100.0 * (m1 + m2);
        System.out.println(Math.round(total));
    }
}
