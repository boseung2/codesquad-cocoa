import java.util.Scanner;

public class if2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int score = scanner.nextInt();

        if(score >= 90 && score <= 100)
            System.out.println("A");
        if(score >= 80 && score <= 89)
            System.out.println("B");
        if(score >= 70 && score <= 79)
            System.out.println("C");
        if(score >= 60 && score <= 69)
            System.out.println("D");
        if(score <60)
            System.out.println("F");

    }
}
