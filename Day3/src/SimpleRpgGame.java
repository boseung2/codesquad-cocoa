import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;
import java.util.Scanner;

//Thing클래스 캐릭터, 지뢰, 몬스터 객채 생성해야할듯??
class Thing{
    int x, y;


    Thing(int x, int y){
        this.x = x;
        this.y = y;
    }

}






public class SimpleRpgGame {

    //배열 프린트함수
    static void printArray(String[][] field) {
        System.out.println("=================================");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.println("=================================");
    }

    /*
     *메인함수********************************
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //field 배열 생성 및 초기화
        String[][] field = new String[11][11];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = "   ";
            }
        }

        //캐릭터 생성 및 초기화
        Thing character = new Thing(5, 5);
        field[ character.y ][ character.x ] = " ♥ ";

        //첫번째 지뢰 생성 및 초기화
        Thing bomb = new Thing(0,0);
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        while(x != 5 && y != 5) {
            bomb.x = x;
            bomb.y = y;
            break;
        }

        //초기 배열 출력
        printArray(field);


        while (true) {
            //문자열 입력받아서 캐릭터 이동
            String inputKey = scanner.next();
            if (inputKey.equals("w") || inputKey.equals("W")) {

                field[ character.y ][ character.x ] = "   ";
                character.y--;
                field[ character.y ][ character.x ] = " ♥ ";

            }
            if (inputKey.equals("a") || inputKey.equals("A")) {

                field[ character.y ][ character.x ] = "   ";
                character.x--;
                field[ character.y ][ character.x ] = " ♥ ";

            }
            if (inputKey.equals("s") || inputKey.equals("S")) {

                field[ character.y ][ character.x ] = "   ";
                character.y++;
                field[ character.y ][ character.x ] = " ♥ ";

            }
            if (inputKey.equals("d") || inputKey.equals("D")) {

                field[ character.y ][ character.x ] = "   ";
                character.x++;
                field[ character.y ][ character.x ] = " ♥ ";

            }
            printArray(field);

            if (character.x == bomb.x && character.y == bomb.y){
                field[ character.y ][ character.x ] = " 💥 ";
                printArray(field);
                System.out.println("Game Over");
                break;
            }


        }

    }
}

