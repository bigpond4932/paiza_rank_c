import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class C006 {
    // C006:ハイスコアランキング
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        // 1行目　→　アイテム数　、　ユーザー数、　TOP何位までの点数が知りたいのか
        String[] info1 = buf.readLine().split(" ");
        int itemTypes = Integer.parseInt(info1[0]);
        int numOfUser = Integer.parseInt(info1[1]);
        int howManyRank = Integer.parseInt(info1[2]);
//        System.out.println("itemTypes , numOfUser, howManyRank : " + itemTypes + " " + numOfUser + " " + howManyRank);
        // ２行目　→　各アイテムの点数
        String[] info2 = buf.readLine().split(" ");
        double[] scoreByItem = new double[itemTypes];
        Integer[] scoreByUser = new Integer[numOfUser];

        for (int i = 0; i < info2.length; i++ ){
            scoreByItem[i] = Double.parseDouble(info2[i]);
        }
//        System.out.println("--------- scoreByItem");
//        System.out.println(Arrays.toString(scoreByItem));
        // 3行目　→　ユーザー数 + 2 (ユーザーごとのアイテム保持情報)
        for(int i = 0; i < numOfUser; i++){
            double score = 0;
            // TODO 각 유저의 아이템 수를 받아서 int배열로 바꾸기 -> 굳이 다 바꿀 필요가 없다!!
            int[] userInventory = Arrays.stream(buf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            System.out.println("----- userInventory");
//            System.out.println(Arrays.toString(userInventory));
            for(int itemType = 0; itemType < itemTypes; itemType++){
//                System.out.println("scoreByItem : " + scoreByItem[itemType]);
                score += userInventory[itemType] * scoreByItem[itemType];
            }
            // 小数第一位を四捨五入し、整数にします。　→　これどうしたらへん？
            scoreByUser[i] = roundingOff(score);
//            System.out.println("scoreByUser[i] : " + scoreByUser[i]);
        }
        // TODO 各ユーザーごとの点数を測り、配列に保存 -> 配列を整列し、求めたいランキングの点数を出力
        Arrays.sort(scoreByUser, Collections.reverseOrder()); // TODO 컬렉션 프레임워크를 사용하면 내가 정렬코드를 짤 일이 없어진다.!!
        for(int rank = 0; rank < howManyRank; rank++ ){
            System.out.println(scoreByUser[rank]);
        }
    }
    static int roundingOff (double num){ // TODO Math.round()라는 좋은 반올림 함수가 존재한다.!!
//        System.out.println("---- roundingOff");
//        System.out.println("num : " + num);
        int integerPart = (int) num;
        double decimalPart = num - integerPart;
//      Float a = 0.000F;
        if(decimalPart >= 0.5) {
            return integerPart + 1;
        }else{
            return integerPart;
        }
    }
}
