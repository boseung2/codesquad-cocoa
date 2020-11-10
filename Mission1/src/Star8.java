import java.util.Scanner;

public class Star8 {

    static int isOverHalf(int i, int num){
        if (i > num) {
            return 2 * num - i;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for(int i=1; i<=(2 * num - 1); i++){
            int x = isOverHalf(i, num);

            for (int j = 1; j <= x; j++) {
                    System.out.print("*");
                }

                for (int k = 1; k <= 2 * (num - x); k++) {
                    System.out.print(" ");
                }

                for (int j = 1; j <= x; j++) {
                    System.out.print("*");
                }

                System.out.println();
        }

    }
}

