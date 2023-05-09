import jdk.swing.interop.SwingInterOpUtils;

public class PrimitiveType {

    public static void main(String[] args){

        // 정수형

        // 1. byte(1 byte = 8): -2^7 ~ 2^7-1(-128 ~ 127)
        // 2. short(2 bytes): -2^15 ~ 2^15-1(-32,768 ~ 32,767)
        // 3. int(4 bytes): -2^31 ~ 2^31-1
        // 4. long(8 bytes): -2^63 ~ 2^63-1


        // 실수형
        // 1. double(8 bytes) - 15자리
        // 2. float(4 bytes) - 7자리
        double a = 1.23;
        float b = 9.45f; // <= f로 명시해줘야 함


        // 문자형
        // char(2 bytes)
        char char_1 = 'a'; // <= 큰 따옴표 안됌
        char char_2 = 97;

        System.out.println(char_1);
        System.out.println(char_2); // <= 둘 다 결과값이 a (원인: ASCII 코드)

        // 논리형
        // boolean(1 byte)

        boolean bool_1 = true;
        boolean bool_2 = false;
        // boolean bool_3 = (100 < 0);
        // boolean bool_4 = 1;

        System.out.println(bool_1);
        System.out.println(bool_2);
        // System.out.println(bool_3);

        // 참조형
        // 참조형 데이터의 값 => 힙 메모리 영역
        // 변수에 대입되는 값 => 힙 메모리 영역의 주소값

        //String aa = new String(original: "Hello!");

    }
}
