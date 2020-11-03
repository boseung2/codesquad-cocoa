import java.util.Scanner;

public class Star5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= (num - i); j++){
                System.out.print(" ");
            }
            for(int k = 1; k < (2 * i); k++){
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();

    }
}
