package AccountingBook;

import java.util.Scanner;

public class PromptChoose {
    private int num;

    public boolean input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("(1. 입력 2. 삭제 3. 수정 4. 출력 0. 종료)");
        System.out.print("원하시는 항목을 선택해주세요. : ");
        num = scanner.nextInt();
        if (num < 0 || num > 5) {
            System.out.println("잘못입력하셨습니다. 0~5사이의 숫자를 입력해주세요.");
            return false;
        }
        return true;
    }

    public int getNum() {
        return num;
    }

}
