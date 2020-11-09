package AccountingBook;

public class Run {
    public static void main(String[] args) {
        PromptStart promptStart = new PromptStart();
        PromptChoose promptChoose = new PromptChoose();
        Prompt1 prompt1 = new Prompt1();
        Prompt2 prompt2 = new Prompt2();
        Prompt3 prompt3 = new Prompt3();
        Prompt4 prompt4 = new Prompt4();

        final int MONTH = 12;
        final int DAY = 31;
        Data[][] dataArr = new Data[MONTH][];   // 2차원 data객체배열 생성 & 인스턴스 대입
        for (int i = 0; i < MONTH; i++) {
            dataArr[i] = new Data[DAY];
        }

        //시작프롬프트 출력
        promptStart.print();
        //0입력시 까지 반복
        while (true) {
            System.out.println();
            if (promptChoose.input() == false) {  //메뉴선택변수num 입력받음(0,1,2,3,4)
                continue;
            }
            if (promptChoose.getNum() == 0) {   //num = 0 프로그램종료
                System.out.println("종료합니다.");
                break;
            }
            if (promptChoose.getNum() == 1) {   //num = 1 데이터 입력
                if (prompt1.input() == true) {
                    prompt1.save(dataArr);
                }
                continue;
            }
            if (promptChoose.getNum() == 2) {   //num = 2 데이터 삭제
                if (prompt2.input() == true) {
                    prompt2.delete(dataArr);
                }
                continue;
            }
            if (promptChoose.getNum() == 3) {   //num = 3 데이터 수정
                if (prompt3.input(dataArr) == true) {
                    prompt3.change(dataArr);
                }
                continue;
            }
            if (promptChoose.getNum() == 4) {   //num = 4 데이터 출력
                if (prompt4.input() == true) {
                    prompt4.print(dataArr);
                }
                continue;
            }
        }

    }
}
