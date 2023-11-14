import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) throws Exception {
        File f = new File("input5f.txt");
        Scanner scan = new Scanner(f);
        int from = Integer.parseInt(scan.nextLine());
        int to = Integer.parseInt(scan.nextLine());
        String original = scan.nextLine();
        String num = Long.toString(Long.parseLong(original, from), to).toUpperCase();
        // System.out.println(num);
        int answer = 0;
        for (int i = 0; i < num.length(); i++) {
            switch (num.charAt(i)) {
                case 'A': answer += 10;
                break;
                case 'B': answer += 11;
                break;
                case 'C': answer += 12;
                break;
                case 'D': answer += 13;
                break;
                case 'E': answer += 14;
                break;
                case 'F': answer += 15;
                break;
                default: answer += Integer.parseInt(num.substring(i, i+1));
                break;
            }

        }
        System.out.println(answer);
    }
}
