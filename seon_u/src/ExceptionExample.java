import java.util.ArrayList;

public class ExceptionExample {

    public static void main(String[] args) {

        // 예외(Exception)

//        int a = 10;
//        int b = 0;
//
//        int c = a / b;

        ArrayList arrayList = new ArrayList(3);
//        arrayList.get(10);

        try {
//            arrayList.get(10);
            int a = 10;
            int b = 0;
            int c = a / b;
        } catch (IndexOutOfBoundsException ioe) {
            ioe.printStackTrace(); // 에러난 부분의 메세지를 띄우기 위한 명령어(보안상 지향하는게 좋음)
            System.out.println("IndexOutOfBoundsException 발생"); // 웬만하면 catch구문 안에선 sout을 안써주는게 보안상 좋다고 함.
        } catch (IllegalArgumentException iae) {
            System.out.println("IllegalArgumentException 발생");
        }catch (Exception e) {
            System.out.println("Exception 발생");
        }
        finally {
            System.out.println("finally");
        }

    }
}
