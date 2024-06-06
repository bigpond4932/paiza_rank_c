import java.util.*;

public class C065 {
    // 【ぱいじょ！コラボ問題】数字あてゲーム
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //


        int numOfHints = sc.nextInt();
        int x = 0;
        // TODO hint의 수 만큼 힌트를 받아서 정리한다. 힌트부호(문자열) space 숫자
        int smaller = 0;
        int bigger = 0;
        List<Integer> dividers = new ArrayList<>();
        // TODO 목표 : 조건을 만족하는 수 x를 구한다.
        // > 의 경우 -> bigger set (이미 세팅된 bigger보다 더 큰 bigger등장 시 갱신)
        // < 의 경우 -> smaller set (이미 세팅된 smaller보다 더 큰 smaller등장 시 갱신)
        // / 의 경우 ->
        // 힌트를 정리한다. 힌트는 부호와 숫자로 구분된다.

        for (int i = 0 ; i < numOfHints; i++){
            String hint = sc.next();
            int numberHint = sc.nextInt();
            if(hint.equals(">")){
//                System.out.println("bigger");
                if (bigger == 0 || bigger > numberHint  ){
                    bigger = numberHint;
                }
            } else if (hint.equals("<")) {
                if (smaller == 0 || smaller < numberHint  ){
                    smaller = numberHint;
                }
//                System.out.println("smaller");
            }else{
                dividers.add(numberHint);
            }
        }

         x = findX(dividers.stream().mapToInt(i -> i).sorted().toArray(), smaller, bigger);
        System.out.println(x);
        // > < 조건을 통해서 x의 범위를 구한다.
        // "/" 의 힌트의 수들의 최소 공배수를 구한다. a*b*c/MCD(최대공약수)
        // x 범위 내의 최소공배수의 배수를 구한다.
        // 출력한다.
    }

    private static int findX(int[] array, int s , int b) {
        int result = 0;
       List<Integer>lmcCandidates = new ArrayList<>();
        for(int i = b + 1; i < s; i++ ){
//            System.out.println("i : " + i);
//            System.out.println("array[0] : " + array[0]);
            if(i % array[0] == 0){
                lmcCandidates.add(i);
            }
        }
//        System.out.println("lmcCandidates.toString() : ");
//        System.out.println(lmcCandidates.toString());
        for(int i = 0; i < array.length; i++){
//            System.out.println("array["+ i +"] : " + array[i]);
            List<Integer>newCandidates = new ArrayList<>();

            for (Integer lmcCandidate : lmcCandidates) {
                if (lmcCandidate % array[i] == 0) {
                    newCandidates.add(lmcCandidate);
                }
            }
            if(newCandidates.size() == 1){
//                System.out.println(newCandidates.get(0));
                result = newCandidates.get(0);
                break;
            }else{
                lmcCandidates = newCandidates;
            }
        }

        return result;
    }
}
