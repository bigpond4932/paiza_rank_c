public class Test {
    public static void main(String[] args) {
        char a = 68; // D
        System.out.println(a);
        int b = 128;
        if( a >= b ){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        System.out.println(Integer.valueOf(a)); // 68
        System.out.println(String.valueOf(a)); // D
    }
}
