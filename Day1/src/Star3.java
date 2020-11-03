import java.util.Scanner;

public class Star3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= num - i + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }

}
