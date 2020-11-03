import java.util.Scanner;

public class Star17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for(int i=1; i <= n-1; i++){
            for(int j=1; j <= n-i; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int k=1; k<=(2 * i - 3); k++){
                System.out.print(" ");
            }

            if(i != 1) {
                System.out.print("*");
            }
            System.out.println();

        }

        for(int i=1; i <= (2 * n -1); i++){
            System.out.print("*");
        }
    }
}
