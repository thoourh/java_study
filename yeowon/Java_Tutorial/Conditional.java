public class Conditional {

    public static void main(String[] args) {

        /* int a = 1;
        int b = 100;*/

        // 다중 조건의 경우, 조건을 만족하는 최초의 분기만 실행!
/*        if (a == b){
            System.out.println("a == b");
        } else if (a < b) {
            System.out.println("a < b");
        } else {
            System.out.println("else");
        }*/


        /* if (a == b) {
            System.out.println("a == b");
        } else {
            System.out.println("else block");
        }
*/
        /*if(a != b){
            System.out.println("a != b");*/

        int a = 10;

        switch(a + 1) {
            case 9:
                System.out.println("a + 1 == 9");
            case 10:
                System.out.println("a + 1 == 10");
            case 11:
                System.out.println("a + 1 == 11");
                break;
            default:
                System.out.println("default");
        }


        }
    }

