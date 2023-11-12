import java.io.File;
import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) throws Exception {
        File f = new File("input6.txt");
        Scanner scan = new Scanner(f);

        int f1 = Integer.parseInt(scan.nextLine());
        int f2 = Integer.parseInt(scan.nextLine());
        int k= Integer.parseInt(scan.nextLine());
        int[] terms = new int[k];
        String [] tokens = scan.nextLine().split(" ");
        for (int i = 0; i < k; i++) {
            terms[i] = Integer.parseInt(tokens[i]);
        }
        int[] fib = new int[1000];
        fib[1] = f1;
        fib[2] = f2;
        for (int i = 3; i < 1000; i++) {
            fib[i] = (fib[i-1] + fib[i-2]) % 100;
            System.out.println("fib[" + i + "] = " + (char)fib[i]);  // debug
        }
        String answer = "";
        for (int i = 0; i < k; i++) {
            answer += ((char)fib[terms[i]]) + "";
        }
        System.out.println(answer);
    }
}