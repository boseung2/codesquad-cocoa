import java.util.Scanner;

public class if5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int m = scanner.nextInt();

        if(h != 0){
            if(m >= 45){
                m = m-45;
                System.out.println(h + " " + m);
            }
            else if(m < 45){
                h = h - 1;
                m = m + 15;
                System.out.println(h + " " + m);
            }
        }

        else if( h == 0){
            if(m >= 45){
                m = m-45;
                System.out.println(h + " " + m);
            }
            else if(m < 45){
                h = 23;
                m = m+15;
                System.out.println(h + " " + m);
            }
        }



    }
}
