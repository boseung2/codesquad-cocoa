import java.util.Scanner;

public interface Star20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for(int i=1; i<=n; i++){
            if(i % 2 == 1){
                for(int j=1; j<=n; j++) {
                    System.out.print("* ");
                }
            }

            if(i % 2 == 0){
                for(int k=1; k<=n; k++){
                    System.out.print(" *");
                }
            }
            System.out.println();
        }
    }
}
