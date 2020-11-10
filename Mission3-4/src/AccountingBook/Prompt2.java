package AccountingBook;

import java.util.Scanner;

public class Prompt2 {
    Data data = new Data();
    int month;
    int day;

    public boolean input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("삭제하실 월을 입력해주세요 : ");
        this.month = scanner.nextInt();
        System.out.print("삭제하실 일을 입력해주세요 : ");
        this.day = scanner.nextInt();
        if (data.checkMonthDay(month, day) == false) {
            System.out.println("월 혹은 일을 잘못 입력하셨습니다. 처음으로 돌아갑니다.");
            return false;
        }
        return true;
    }

    //해당 날짜 데이터 삭제
    public void delete(Data[][] dataArr) {
        dataArr[month - 1][day - 1] = null;
        System.out.println("삭제되었습니다.");
        System.out.println();
    }
}
