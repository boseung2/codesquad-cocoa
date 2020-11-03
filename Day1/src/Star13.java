import java.util.Scanner;

public class Star13 {
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
            for(int j = 1; j <= tempI; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
