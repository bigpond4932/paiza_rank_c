import java.util.*;

public class C105 {
    // C105:カードのスコア
    // 문제를 잘못이해했구나.
    // 1차이가 나는 친구가 있으면, 아.. 정렬해야겠다 그리고 로직을 작성을 해야겠다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCards = sc.nextInt();
        int[] cards = new int[numOfCards];
        for(int i = 0; i < numOfCards; i++){
            cards[i] = sc.nextInt();
        }
        Arrays.sort(cards);

        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        ArrayList<Integer> group = new ArrayList<>();
        int sum = 0;
        int cardPointer = 0;
        for(int i = 0; i < cards.length; i++ ){
            int cardNo = cards[i];
            // 처음 받는 수를 그룹에 집어넣어요
            if(isSameGroup(cardPointer, cardNo)){
                // 같은 그룹이야.
                group.add(cardNo);
            }else{
                groups.add(group);
                // 새로운 그룹 시작
                group = new ArrayList<>(); // 이렇게 할당을 하면 전에 가지고 있던 group의 정보가 날아가나?
                group.add(cardNo);
            }
            // 카드 포인터 갱신
            cardPointer = cardNo;
//            System.out.println(group.toString());
                // 마지막 그룹같은 경우에는 그냥 넣어 줘야함.
            if (i == numOfCards - 1){
                groups.add(group);
            }
        }
//        System.out.println(groups.toString());
        // arrayList를 하나씩 까서 마지막 요소를 더해주면 게임 끝
//        groups.forEach((g) -> {
//            sum += Collections.max(g); // Variable used in lambda expression should be final or effectively final What?
//        });
        for (ArrayList<Integer> g : groups){
            sum += Collections.max(g);
        }
        System.out.println(sum);
    }
    static boolean isSameGroup(int c1, int c2){
        if (c1 == 0 ) return true;
        return c1 + 1 == c2 || c1 - 1 == c2;
    }
}
