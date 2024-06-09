import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class C082 {
    // C082:【推しプロコラボ問題】テストの赤点
    public static void main(String[] args) {
        // TODO: 학생 수, 낙제점의 기준이 되는 순위를 받는다(뒤에서부터)
        Scanner sc = new Scanner(System.in);
        int numOfStudents = sc.nextInt();
        int fallingStandardRank = sc.nextInt() - 1; // 배열이 0부터 시작하기 때문

        // TODO: 각 학생의 과목별 점수를 기록한다.
        int[] mathPoints = new int[numOfStudents];
        int[] languagePoints = new int[numOfStudents];
        int[] englishPoints = new int[numOfStudents];
        for (int studentNo = 0; studentNo < numOfStudents; studentNo++){
            mathPoints[studentNo] = sc.nextInt();
            languagePoints[studentNo] = sc.nextInt();
            englishPoints[studentNo] = sc.nextInt();
        }
        // TODO: 낙제점 기준이 되는 순위의 점수를 구한다.
        int fallingStandardMathPoint = getFallingPoint(mathPoints, fallingStandardRank);
        int fallingStandardLanguagePoint = getFallingPoint(languagePoints, fallingStandardRank);
        int fallingStandardEnglishPoint = getFallingPoint(englishPoints, fallingStandardRank);
//        System.out.println("fallingStandardMathPoint : " + fallingStandardMathPoint);
//        System.out.println("fallingStandardLanguagePoint : " + fallingStandardLanguagePoint);
//        System.out.println("fallingStandardEnglishPoint : " + fallingStandardEnglishPoint);
        // TODO: 각 학생별로 낙제점이 몇 개 존재하는 지 확인한다.
        for(int studentNo = 0; studentNo < numOfStudents; studentNo++){
            int numOfFallingSubjects = 0;
            if (mathPoints[studentNo] <= fallingStandardMathPoint) numOfFallingSubjects++;
            if (languagePoints[studentNo] <= fallingStandardLanguagePoint) numOfFallingSubjects++;
            if (englishPoints[studentNo] <= fallingStandardEnglishPoint) numOfFallingSubjects++;
            System.out.println(numOfFallingSubjects);
        }
    }

    private static int getFallingPoint(int[] points, int fallingStandardRank) {
        // TODO: 낙제점 구하기
//        Integer[] wrapperArray = Arrays.stream(points).boxed().toArray(Integer[]::new); // 배열에서 스트림을 취득 -> 박싱 -> 배열로 변환(어던 배열을 만들것인가?)
        int[] temp = points.clone();
//        System.out.println(Arrays.toString(temp)); // 아.. 이래 해버리면 학생 순서대로 저장했던 점수들의 순서가 바뀌는구나.
        Arrays.sort(temp);
//        System.out.println(Arrays.toString(temp));
        return temp[fallingStandardRank];
    }
}
