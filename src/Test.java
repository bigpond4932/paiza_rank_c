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

        String temp = "a";
        String temp2 = "035";
        String temp3 = "0035";
        String temp4 = "-50";
//        System.out.println(Integer.parseInt(temp)); //"main" java.lang.NumberFormatException: For input string: "a"
//        System.out.println(Integer.parseInt(temp2)); // 35
//        System.out.println(Integer.parseInt(temp3)); // 35
        System.out.println(Integer.parseInt(temp4));
    }
}
