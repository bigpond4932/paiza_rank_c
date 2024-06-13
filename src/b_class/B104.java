package b_class;

import java.util.Arrays;
import java.util.Scanner;

public class B104 {
    // B104:データのクレンジング
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //TODO 사람, 앙케이트 수를 저장
        int numOfPeople = sc.nextInt();
        int typeOfQuestions = sc.nextInt();
        //TODO 각 앙케이트별 설문결과의 유효성 체크
        int[][] result = new int[typeOfQuestions][2]; // [][0] = 점수합 [][1] = 유효결과 카운팅
        //TODO 각 앙케이트별 유효한 설문결과의 합과 유효 응답 수를 저장
        for(int i = 0; i < numOfPeople; i++){
            for(int j = 0; j < typeOfQuestions; j++){
                try {
                    int t = Integer.parseInt(sc.next()); // 숫자로 변환 가능 하니?
                    if(validationCheck(t)){
                        result[j][0] += t; // 유효한 값의 합을 구하기
                        result[j][1]++; // 유효한 값의 개수를 구하기
                    }
                }catch (NumberFormatException ignored){
                }
            }
        }
//        DEBUG
//        for (int[] ints : result) {
//            System.out.println(Arrays.toString(ints));
//        }
        //TODO 각 앙케이트별 유효 설문결과 합/유효 응답 수를 나눠서 결과 출력
        for(int i = 0; i < typeOfQuestions; i++){
            int average = 0;
            if(result[i][1] != 0){
                average = result[i][0] / result[i][1];
            }
            System.out.println(average);
        }
    }

    private static boolean validationCheck(int t) {
        return t >= 0 && t <= 100;
    }
}
