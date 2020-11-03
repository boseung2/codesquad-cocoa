import java.util.Random;
import java.util.Scanner;

public class Star14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int n = scanner.nextInt();


        for(int i=1; i<=n; i++){
            int randomNum = rand.nextInt(100);
            for(int j=1; j<randomNum; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
