import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C149_GPT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String correctionRule = sc.next();
        String targetStr = sc.next();

        // 교정 규칙을 맵으로 저장
        Map<Character, Character> correctionMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char lowerCaseLetter = (char) ('a' + i);
            char upperCaseLetter = (char) ('A' + i);
            correctionMap.put(lowerCaseLetter, correctionRule.charAt(i));
            correctionMap.put(upperCaseLetter, correctionRule.charAt(i));
        }

        // 타겟 문자열 변환
        StringBuilder correctedStr = new StringBuilder();
        for (char c : targetStr.toCharArray()) {
            if (correctionMap.containsKey(c)) {
                correctedStr.append(correctionMap.get(c));
            } else {
                correctedStr.append(c);
            }
        }

        // 결과 출력
        System.out.println(correctedStr.toString());
    }
}
