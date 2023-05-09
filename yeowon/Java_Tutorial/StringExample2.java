public class StringExample2  {

    public static void main(String[] args) {
        // 공백 제거

        // 1. 양쪽 끝 공백
        String str_1 = "      Hell0      ";
        str_1 = str_1.trim();
        System.out.println(str_1);

        // 2. 문자열 중간 공백
        String str_2 = " Hel         lo   ";
        str_2 = str_2.trim();
        // str_2 = str_2.replace(target: " ", replacement: "" );
        System.out.println(str_2);




    }
}
