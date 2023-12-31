import java.io.File;
import java.util.Scanner;

public class Problem4 {
    public static void printArray(String [] [] array) {
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        String [] [] foods = new String[9][9];
        File f = new File("input4d.txt");
        Scanner scan = new Scanner(f);
        String[] tokens = scan.nextLine().split(" ");
        int[] instructions = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            instructions[i] = Integer.parseInt(tokens[i]);
        }
        tokens = scan.nextLine().split(" ");
        int[] printIndicies = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            printIndicies[i] = Integer.parseInt(tokens[i]);
        }
        for (int row = 0; row < 9; row++) {
            String line = scan.nextLine();
            tokens = line.split(";");
            /* replaced 9 to tokens.length in the for loop below
               because one of the test cases did not have nine elements in the array row.
               not sure if this was a typo or intentional
             */
            for (int col = 0; col < tokens.length; col++) {
                // System.out.println("row = " + row + " col = " + col); // debug
                foods[row][col] = tokens[col].trim();
            }
        }
        //printArray(foods); // debug
        int r = 0;
        int c = 0;
        boolean horiz = true;
        int count = 0;
        int j = 0;
        int i= 0;
        //System.out.println("debug: count =" + count + " r = " + r + " c = " + c + " i = " + i + " j = " + j +
                //"print index = " + printIndicies[j] + " instruction = " + instructions[i]);
        for (i = 0; i < instructions.length ; i++) {

                ++count;
                if (horiz) {
                    c = c + instructions[i];
                    if (c > 0)
                        c = c % 9;
                    else
                        while (c < 0)
                            c += 9;
                } else {
                    r = r - instructions[i];
                    if (r > 0)
                        r = r % 9;
                    else
                        while (r < 0)
                            r += 9;
                }
                //System.out.println("debug: count =" + count + " r = " + r + " c = " + c + " i = " + i + " j = " + j +
                        //"print index = " + printIndicies[j] + " instruction = " + instructions[i]);
                if (count == printIndicies[j]) {
                    System.out.println(foods[r][c]);
                    count = 0;
                    ++j;
                }
                horiz = !horiz;


        }
    }
}
