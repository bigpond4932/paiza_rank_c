import java.util.Scanner;

public class C148 {
    // C148:戦闘シミュレーション
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int battles = sc.nextInt();
        int myLv = sc.nextInt();
//        System.out.println("battles :" + battles);
//        System.out.println("myLv :" + myLv);
        for (int phase = 0; phase < battles; phase++ ){
            int enemyLv = sc.nextInt();
            if (myLv > enemyLv){
                myLv += enemyLv/2;
            } else if (myLv < enemyLv) {
                myLv /= 2;
            }
//            System.out.println("phase : " + phase + ", myLv :" + myLv);
        }
        System.out.println(myLv);
    }
}