import java.util.Scanner;

public class Gugudan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startDan = scanner.nextInt();
        int finishDan = scanner.nextInt();

        for(int i=1; i<10; i++){
            for(int j=startDan; j<=finishDan; j++){
                System.out.printf("%d X %d = %3d  ", j, i, j*i );
            }
            System.out.println();
        }
    }
}
