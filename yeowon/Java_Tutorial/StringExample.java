public class StringExample {

    public static void main(String[] args) {

        // String => 문자열 객체
        // 객체 => 힙 메모리 영역
        // 변수 => 힙 메모리 영역의 주소

        // String str = "안녕하세요!"; // 문자열 리터럴
        // String str_2 = new String(original: "안녕하세요!"); // 생성자
        // String str_3 = "안녕하세요!";

        // if(str == str_2) {
           // System.out.println("str == str_2");
        //}
        //if (str == str_3){
           // System.out.println("str == str_3");
        // }


        // 문자열 병합
        // 1. '+' 연산자
        // String str_1 = "Hello,";
        // String str_2 = "World!";

        // System.out.println(str_1 + " " + str_2);

        // 2. StringBuilder
        // StringBuilder strBdr_1 = new StringBuilder("Hello,");
        // strBdr_1.append(" ");
        // strBdr_1.append("World");
        // String str_new = strBdr_1.toString();

        // System.out.println(strBdr_1.toString());


        // 문자열 슬라이스

        String str_1 = "이름: 김자바";
        // System.out.println(str_1.indexOf("이"));
        // System.out.println(str_1.indexOf("름"));

        String str_name = str_1.substring(4, 7);
        System.out.println(str_name);


        // 문자열 대소문자 변환

        String str_2 = "abc";
        String str_3 = "ABC";

        str_2 = str_2.toUpperCase();
        str_3 = str_3.toLowerCase();

        System.out.println(str_2);
        System.out.println(str_3);


    }
}
