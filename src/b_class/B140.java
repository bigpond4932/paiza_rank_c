package b_class;

import java.util.Arrays;
import java.util.Scanner;

public class B140 {
    // B140:ネズミ駆除
        static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //　가지고 있는 덫으로 최대한 많은 쥐를 잡고 싶어요
        // 각 구획에 출현하는 쥐의 숫자를 카운팅
        int[][] divWithMouse = new int[sc.nextInt()][sc.nextInt()];
        int totalMouses = sc.nextInt();
        int numOfTraps = sc.nextInt();
        placeMouses(divWithMouse, totalMouses);
        // 모든 구획을 하나의 배열에 담고 내림차순으로 정렬
        int[] mouseNumByPlace = Arrays.stream(divWithMouse).flatMapToInt(Arrays::stream).toArray();
        // Q. mapToInt 랑 flatMapToInt랑 뭐가 다르누?
        Arrays.sort(mouseNumByPlace); // 내림차순 정렬이 인트배열이여야 가능하구나.
//        System.out.println(Arrays.toString(mouseNumByPlace));
        // 쥐 덫의 개수만큼 더하기
        int capturedCount = 0;
        for(int i = 1; i <= numOfTraps; i++){ // 덫이 할당된 공간보다 더 많을 경우도 처리를 해줘야하는구나.
            try{
                // 이렇게 작성하는 것 보다, 덫의 수가 공간의 수보다 클 경우, 공간에 존재하는 쥐의 수를 다 더하면 되겠네.
                capturedCount += mouseNumByPlace[mouseNumByPlace.length - i];
            }catch (ArrayIndexOutOfBoundsException e){
                break;
            }
        }
        System.out.println(capturedCount);
    }

    private static void placeMouses(int[][] divWithMouse, int totalMouses) {
        for(int i = 0; i < totalMouses; i++){
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
