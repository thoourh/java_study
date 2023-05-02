// Shift을(를) 두 번 눌러 전체 검색 대화상자를 열고 'show whitespaces'를 입력한 다음,
// Enter를 누르세요. 그러면 코드 내에서 공백 문자를 확인할 수 있습니다.
public class Main {
    public static void main(String[] args) {
    String str_1 = "Hello,";
    String str_2 = "World!";

    System.out.println(str_1 + " " + str_2);

    // StringBuilder
        StringBuilder strBdr_1 = new StringBuilder("Hello,");

        strBdr_1.append("World!");

        System.out.println(strBdr_1.toString()); // toString 스트링 타입 형태 변환

    }
}

