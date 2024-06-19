package b_class;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B140 {
    // B140:ネズミ駆除
        static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // 각 구획에 출현하는 쥐의 숫자를 카운팅
        int rows = sc.nextInt(); // 이렇게 정의하는 것이 명확하다.
        int cols = sc.nextInt();
        int[][] div = new int[rows][cols];
        int totalMouse = sc.nextInt();
        int totalTraps = sc.nextInt();

        // 쥐를 배치
        placeMouses(div, totalMouse); // 배열의 참조를 전달하기 때문에 리턴 안해줘도 div에 쥐를 채워넣을 수 있다.

        // 각 구획에 존재하는 쥐의 수를 하나의 배열에 담고 내림차순으로 정렬
        Integer[] mouseNumByPlace = Arrays.stream(div).flatMapToInt(Arrays::stream).boxed().toArray(Integer[]::new);
//        IntStream flatIntStream = Arrays.stream(div).flatMapToInt(array -> Arrays.stream(array)); {1234567} 와 같이 2차원 배열을 평탄화.

        Arrays.sort(mouseNumByPlace, Collections.reverseOrder()); // 내림차순 정렬이 래퍼클래스 배열이여야 가능하구나. -> 이차원 배열을 Integer형의 일차원 배열로 변환하는 방법은?
//        System.out.println(Arrays.toString(mouseNumByPlace)); // for DEBUG

        // Q. mapToInt 랑 flatMapToInt랑 뭐가 다르지?
        // Q. 애초에 stream이란게 뭘까
        // 쥐 덫의 개수만큼 더하기
        int capturedCount = countHunted(mouseNumByPlace, totalTraps);

        System.out.println(capturedCount);
    }

    private static int countHunted(Integer[] mouseNumByPlace, int numOfTraps) {
        int result = 0;
        if(numOfTraps >= mouseNumByPlace.length){
            result = Arrays.stream(mouseNumByPlace).reduce(0, Integer::sum); //
        }else{
            for(int i = 0; i < numOfTraps; i++){
                // 이렇게 작성하는 것 보다, 덫의 수가 공간의 수보다 클 경우, 공간에 존재하는 쥐의 수를 다 더하면 되겠네.
                result += mouseNumByPlace[i];
            }
        }
        return result;
    }

    private static void placeMouses(int[][] divWithMouse, int totalMouse) {
        for(int i = 0; i < totalMouse; i++){
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            if(divWithMouse[r][c] == 0){
                divWithMouse[r][c] = 1;
            }else{
                divWithMouse[r][c]++;
            }
        }
    }
}
