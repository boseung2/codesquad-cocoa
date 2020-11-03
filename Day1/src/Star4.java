import java.util.Scanner;

public class Star4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for(int i = 0; i < num; i++){
            for(int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for(int k = i; k < (num); k++){
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();

    }
}
