package AccountingBook;

import java.util.Scanner;

public class Print {
    Data data = new Data();
    int month;
    int day;
    final int MONTH = 12;
    final int DAY = 31;

    public boolean input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("출력하실 월을 입력해주세요 : ");
        this.month = scanner.nextInt();
        if (data.checkMonthDay(month, 1) == false) {
            System.out.println("월을 잘못 입력하셨습니다. 처음으로 돌아갑니다.");
            System.out.println();
            return false;
        }
        return true;
    }

    public void print(Data[][] dataArr) {
        int[] sumMonthIncome = new int[MONTH];
        int[] sumMonthExpense = new int[MONTH];
        int thisMonthBalance = 0;

        //달마다 각각의 income값을 더함
        for (int i = 0; i < MONTH; i++) {
            for (int j = 0; j < DAY; j++) {
                if (dataArr[i][j] == null) {
                    continue;
                }
                sumMonthIncome[i] += dataArr[i][j].getIncome();
            }
        }

        //달마다 각각의 expense값을 더함
        for (int i = 0; i < MONTH; i++) {
            for (int j = 0; j < DAY; j++) {
                if (dataArr[i][j] == null) {
                    continue;
                }
                sumMonthExpense[i] += dataArr[i][j].getExpense();
            }
        }

        //해당 달까지의 (총수입 - 총지출)을 더함
        for (int i = 0; i < month; i++) {
            thisMonthBalance += sumMonthIncome[i] - sumMonthExpense[i];
        }

        System.out.println();
        for (int i = 0; i < DAY; i++) {
            //dataArr에 저장된 정보가 없으면 출력안함, 저장된 정보가 있으면 정보 출력
            if (dataArr[month - 1][i] == null) {
                continue;
            } else {
                System.out.println("날짜 : " + month + "월 " + (i + 1) + "일");
                dataArr[month - 1][i].print();
            }
        }

        //출력마지막에 해당월의 총 수입,지출,잔액 표시
        System.out.println();
        System.out.println((month) + "월의 총 수입 : " + sumMonthIncome[month - 1]);
        System.out.println((month) + "월의 총 지출 : " + sumMonthExpense[month - 1]);
        System.out.println((month) + "월 현재 남은 잔액 : " + thisMonthBalance);
        System.out.println();
    }


}
