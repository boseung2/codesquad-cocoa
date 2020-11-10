import java.util.Scanner;

public class Star6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for(int i=1; i<=num; i++){
            for(int j = 1; j < i; j++){
                System.out.print(" ");
            }
            for(int k = 0; k < (2 * num) - (2 * i - 1); k++){
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}
