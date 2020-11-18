package AccountingBook;

import java.util.Scanner;

public class Change {
    Data data = new Data();
    int month;
    int day;

    //날짜와 해당되는 데이터 입력받기
    public boolean input(Data[][] dataArr) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("수정하실 월을 입력해주세요 : ");
        this.month = scanner.nextInt();
        System.out.print("수정하실 일을 입력해주세요 : ");
        this.day = scanner.nextInt();
        if (data.checkMonthDay(month, day) == false) {
            System.out.println("월 혹은 일을 잘못 입력하셨습니다. 처음으로 돌아갑니다.");
            return false;
        }
        if (dataArr[month - 1][day - 1].equals(null)) {
            System.out.println("저장되어 있는 데이터가 없습니다. 처음으로 돌아갑니다.");
            return false;
        }
        System.out.print("수정하실 적요를 입력해주세요 : ");
        data.setSummary(scanner.next());
        System.out.print("수정하실 수입을 입력해주세요 : ");
        data.setIncome(scanner.nextInt());
        System.out.print("수정하실 지출을 입력해주세요 : ");
        data.setExpense(scanner.nextInt());
        return true;
    }

    //해당날짜 입력받은 데이터 저장
    public void change(Data[][] dataArr) {
        dataArr[month - 1][day - 1] = new Data(data.getSummary(), data.getIncome(), data.getExpense());
        System.out.println("수정되었습니다.");
        System.out.println();
    }
}

