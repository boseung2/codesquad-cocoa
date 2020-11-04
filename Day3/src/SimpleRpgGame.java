import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;
import java.util.Scanner;

class Character {
    private int x, y;

    Character(int x, int y) {
        this.x = x;
        this.y = y;
        Map.array[x][y] = " 🧍 ";
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    boolean checkInputKey(String inputKey) {
        if (inputKey.equals("w") || inputKey.equals("W") ||
            inputKey.equals("a") || inputKey.equals("A") ||
            inputKey.equals("s") || inputKey.equals("S") ||
            inputKey.equals("d") || inputKey.equals("D")  ) {
            return true;
        }else {
            System.out.println("잘못 입력하셨습니다. wasd중 입력해주세요.");
            return false;
        }
    }


    void move(String inputKey) {

            Map.array[this.x][this.y] = "   ";
            if (inputKey.equals("w") || inputKey.equals("W")) {
                this.x--;
            }
            if (inputKey.equals("a") || inputKey.equals("A")) {
                this.y--;
            }
            if (inputKey.equals("s") || inputKey.equals("S")) {
                this.x++;
            }
            if (inputKey.equals("d") || inputKey.equals("D")) {
                this.y++;
            }
            Map.array[this.x][this.y] = " 🧍 ";
    }

    boolean checkOverLine(int x, int y){
        if(x > 10 || y > 10){
            return false;
        }
        else{
            return true;
        }
    }


}

class Bomb {
    Random random = new Random();
    private int x = random.nextInt(10);
    private int y = random.nextInt(10);

    Bomb() {
        while (x != 5 && y != 5) {
            if (x != 0 && y != 0) {
                if (x != 0 && y != 10) {
                    if (x != 10 && y != 0) {
                        if (x != 10 && y != 10) {
                            this.x = x;
                            this.y = y;
                            break;
                        }
                    }
                }
            }
        }
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

}

class Monster{
    private int x, y;

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }



}

class Map{
    static String[][] array = new String[11][11];

    Map(){
        for(int i=0; i < array.length; i++){
            for(int j=0; j < array.length; j++){
                array[i][j] = "   ";
            }
        }
    }

    void print(){
        System.out.println("=================================");
        for(int i=0; i < array.length; i++){
            for(int j=0; j < array.length; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println("=================================");
    }





}



public class SimpleRpgGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Map map = new Map();                     //맵 생성 및 초기화
        Character character = new Character(5, 5);  //캐릭터 생성 및 초기화
        Bomb bomb = new Bomb();                  //첫번째 폭탄 생성 및 초기화
        Monster monster = new Monster();         //몬스터 인터페이스 생성
        int score = 0;                           //점수생성

        //첫번째 몬스터생성
        while (true) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            if (x != character.getX() || y != monster.getX()) {
                if (x != bomb.getX() || y != bomb.getY()) {
                    monster.setX(x);
                    monster.setY(y);
                    Map.array[ monster.getX() ][ monster.getY() ] = " 🐖 ";
                    break;
                }
            }
        }

        //초기 배열 출력
        System.out.println("    🐖🐖🐖🐖🐖돼지RPG🐖🐖🐖🐖🐖");
        System.out.println(" 숨겨져 있는 폭탄을 피해 돼지를 잡으세요 ");
        map.print();

        //폭탄밟기전까지 무한반복
        while (true) {
            //문자열 입력받아서 캐릭터 이동
            String inputKey = new String();
            while(true) {
                inputKey = scanner.next();
                if(character.checkInputKey(inputKey) == true) break;
            }
            character.move(inputKey);
            map.print();

            //캐릭터가 폭탄만났을데 게임오버
            if (character.getX() == bomb.getX() && character.getY() == bomb.getY()){
                Map.array[ character.getX() ][ character.getY() ] = " 💥 ";
                map.print();
                System.out.println("Game Over");
                break;
            }



            //캐릭터가 몬스터만나면면 점수획득
            if(character.getX() == monster.getX() && character.getY() == monster.getY()){
                Map.array[ character.getX() ][ character.getY() ] = " 🧍 ";
                score += 100;
                System.out.println();
                System.out.println("돼지를 잡았습니다. 현재점수 : " + score + "점");
                System.out.println();
                //몬스터 재생성
                while (true) {
                    int x = random.nextInt(10);
                    int y = random.nextInt(10);
                    if (x != character.getX() || y != monster.getX()) {
                        if (x != bomb.getX() || y != bomb.getY()) {
                            monster.setX(x);
                            monster.setY(y);
                            Map.array[ monster.getX() ][ monster.getY() ] = " 🐖 ";
                            map.print();
                            break;
                        }
                    }
                }
            }



        }



    }
}

