import java.util.Scanner;

public class IndianNaming {

    static void printWord(String[] wordArray, int calendarNum){
        for(int i = 0; i < wordArray.length; i++){
            if(calendarNum % wordArray.length == i)
                System.out.print(wordArray[i]);
        }
    }

    static void printAll(int year, int month, int day){

        String[] yearWord = {"말많은 ", "푸른 ", "어두운 ", "조용한 ", "웅크린 ", "백색 ",  "지혜로운 ", "용감한 ", "날카로운 ", "욕심많은 "};
        String[] monthWord = {"늑대", "태양", "양", "매", "황소", "불꽃", "나무", "달빛", "말", "돼지", "하늘", "바람"};
        String[] dayWord = {"와(과) 함께 춤을", "의 기상", "은(는) 그림자속에", "", "", "", "의 환생", "의 죽음", "아래에서", "를(을) 보라",
                "이(가) 노래하다", "의 그림자", "의 일격", "에게 쫓기는 남자", "의 행진", "의 왕", "의 유령", "을 죽인자", "는 맨날 잠잔다", "처럼",
                "의 고향", "의 전사", "은(는) 나의 친구", "의 노래", "의 정령", "의 파수꾼", "의 악마", "와 같은 사나이", "를 쓰러린 자", "의 혼", "은(는) 말이 없다"};

        printWord(yearWord , year);
        printWord(monthWord, month - 1);
        printWord(dayWord, day - 1);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("생년월일을 입력해 주세요>");
        int year =  scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        System.out.print("당신의 이름은 ");
        printAll(year, month, day);
        System.out.print("입니다.");
    }
}
