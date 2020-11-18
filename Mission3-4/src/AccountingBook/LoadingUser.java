package AccountingBook;

import java.util.Scanner;

public class LoadingUser {
    public void print() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("사용자 이름을 입력해주세요 : ");
        String userName = scanner.next();
        System.out.print("비밀번호를 입력해주세요 : ");
        String password = scanner.next();
        System.out.println();
        System.out.println(userName + "님의 가계부 입니다.");
    }
}
