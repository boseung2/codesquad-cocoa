import java.util.Scanner;

public class for2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int num = scanner.nextInt();

        int sum = 0;
        int devidedValue=0;
        for(int i = (count-1); i>=1; i--){
            int tenValue = 1;
            for(int j=1; j<=i; j++) {
                tenValue = tenValue * 10;
            }
            devidedValue = num / (tenValue);
            sum += devidedValue;
            num = num - (devidedValue * tenValue);
        }
        sum = sum + num;
        System.out.println(sum);
    }
}
