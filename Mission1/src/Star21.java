import java.util.Scanner;

public interface Star21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for(int i = 1; i <= 2 * n; i++){
            if(n == 1){
                System.out.println("*");
                break;
            }

            if(i % 2 == 1){
                for(int j=1; j <= (n + 1) / 2; j++) {
                    System.out.print("* ");
                }
            }

            if(i % 2 == 0){
                for(int k=1; k <= n / 2; k++){
                    System.out.print(" *");
                }
            }
            System.out.println();
        }
    }
}
