import java.util.Arrays;
import java.util.Scanner;

public class C105_GPT {
    public static void main(String[] args) {
        // 카드 정보 설정.
        Scanner sc = new Scanner(System.in);
        int numOfCards = sc.nextInt();
        int[] cards = new int[numOfCards];
        for(int i = 0; i < numOfCards; i++){
            cards[i] = sc.nextInt();
        }
        Arrays.sort(cards); // 오름차순 정렬 (핵심) -> 문제가 간단해진다. 1 5 2와 같의 떨어져 있는 연속된 수를 어떻게 찾을까 -> 정렬!
        System.out.println(Arrays.toString(cards));
        int sum = 0;

        // 첫 그룹은 0번 인덱스의 숫자부터 시작
        int currentMaxOfGroup = cards[0];
        for (int i = 1; i < cards.length; i++){
            // 연속된 카드인가?
            if ( cards[i] != cards[i - 1] + 1 ){
                // no 그룹의 마지막 수이자 최대값 이므로, 결과에 더하기
                sum += currentMaxOfGroup;
            }
            // 판정할 숫자 변경
            currentMaxOfGroup = cards[i];
//            if (i == cards.length - 1){
//                sum += currentMaxOfGroup;
//            }
        }
        // 마지막 그룹의 최대값 추가
        sum += currentMaxOfGroup;
        System.out.println(sum);
    }
}
