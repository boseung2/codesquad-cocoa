import java.util.Scanner;

public class Star12 {
    static int isOverHalf(int i, int num){
        if (i > num) {
            return 2 * num - i;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for(int i = 1; i <= (2 * n - 1); i++){
            int tempI = isOverHalf(i, n);
            for(int j = 1; j <= n - tempI; j++){
                System.out.print(" ");
            }
            for(int k = 1; k <= tempI; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
