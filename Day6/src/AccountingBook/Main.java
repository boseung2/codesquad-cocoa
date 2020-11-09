package AccountingBook;

import java.util.Scanner;

public class Main {

    static boolean checkMonthDay(int month, int day){
        if(month >= 1 && month <= 12 && day >= 1 && day <= 31){
            return true;
        }else
            return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MONTH = 12;
        final int DAY = 31;
        Data[][] dataArr = new Data[MONTH][];
        for(int i=0; i<MONTH; i++){
            dataArr[i] = new Data[DAY];
        }

        System.out.print("사용자 이름을 입력해주세요 : ");
        String userName = scanner.next();
        System.out.print("비밀번호를 입력해주세요 : ");
        String password = scanner.next();

        //0입력시 까지 반복
        while(true){
            System.out.println("1. 입력 2. 삭제 3. 수정 4. 출력 0. 종료");
            System.out.print("원하시는 항목을 선택해주세요. : ");
            int choose = scanner.nextInt();

            //(0)을 입력시 종료
            if(choose == 0){
                System.out.println("종료합니다.");
                break;
            }
            //(1)을 입력시 입력
            if(choose == 1){
                System.out.print("입력하실 월을 입력해주세요 : ");
                int month = scanner.nextInt();
                System.out.print("입력하실 일을 입력해주세요 : ");
                int day = scanner.nextInt();
                if(checkMonthDay(month, day) == false){
                    System.out.println("월 혹은 일을 잘못 입력하셨습니다. 처음으로 돌아갑니다.");
                    continue;
                }
                System.out.print("입력하실 적요를 입력해주세요 : ");
                String summary = scanner.next();
                System.out.print("입력하실 수입을 입력해주세요 : ");
                int income = scanner.nextInt();
                System.out.print("입력하실 지출을 입력해주세요 : ");
                int expense = scanner.nextInt();
                //입력받은 데이터 저장

                dataArr[month-1][day-1] = new Data(summary, income, expense);
                System.out.println("저장되었습니다.");
            }

            //(2)를 입력시 삭제
            if(choose == 2){
                System.out.print("삭제하실 월을 입력해주세요 : ");
                int month = scanner.nextInt();
                System.out.print("삭제하실 일을 입력해주세요 : ");
                int day = scanner.nextInt();
                if(checkMonthDay(month, day) == false){
                    System.out.println("월 혹은 일을 잘못 입력하셨습니다. 처음으로 돌아갑니다.");
                    continue;
                }
                dataArr[month-1][day-1] = null;
                System.out.println("삭제되었습니다.");
            }

            //(3)을 입력시 수정
            if(choose == 3){
                System.out.print("수정하실 월을 입력해주세요 : ");
                int month = scanner.nextInt();
                System.out.print("수정하실 일을 입력해주세요 : ");
                int day = scanner.nextInt();
                if(checkMonthDay(month, day) == false){
                    System.out.println("월 혹은 일을 잘못 입력하셨습니다. 처음으로 돌아갑니다.");
                    continue;
                }
                System.out.print("수정하실 적요를 입력해주세요 : ");
                String summary = scanner.next();
                System.out.print("수정하실 수입을 입력해주세요 : ");
                int income = scanner.nextInt();
                System.out.print("수정하실 지출을 입력해주세요 : ");
                int expense = scanner.nextInt();
                dataArr[month-1][day-1].change(summary, income, expense);
            }

            //(4)를 입력시 출력
            if(choose == 4){
                System.out.print("출력하실 월을 입력해주세요 : ");
                int month = scanner.nextInt();
                for(int i=0; i<DAY; i++){
                    //dataArr에 저장된 정보가 없으면 출력안함, 저장된 정보가 있으면 정보 출력
                    if(dataArr[month-1][i] == null){
                        continue;
                    }else{
                        System.out.println("날짜 : " + month + "월 " + (i+1) + "일");
                        dataArr[month-1][i].print();
                    }

                }
            }

        }

    }
}
