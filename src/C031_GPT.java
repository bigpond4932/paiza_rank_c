import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class C031_GPT {
    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int numOfTimezones = Integer.parseInt(buf.readLine());

        // LinkedHashMap 사용
        Map<String, Integer> timeDiffMap = new LinkedHashMap<>();

        for (int i = 0; i < numOfTimezones; i++){
            String[] info = buf.readLine().split(" ");
            timeDiffMap.put(info[0], Integer.parseInt(info[1]));
        }

        // 기준 도시와 시간을 읽음
        String[] lastInput = buf.readLine().split(" ");
        String baseCity = lastInput[0];
        String[] timeParts = lastInput[1].split(":");
        int baseHour = Integer.parseInt(timeParts[0]);
        int baseMinute = Integer.parseInt(timeParts[1]);

        // 기준 도시의 시간차
        int baseTimeDiff = timeDiffMap.get(baseCity);

        // 다른 시간대의 시간을 계산 및 출력
        for (Map.Entry<String, Integer> entry : timeDiffMap.entrySet()) {
            String city = entry.getKey();
            int timeDiff = entry.getValue();
            int localHour = (baseHour - baseTimeDiff + timeDiff + 24) % 24; // 시간대 차이 계산
            // %연산자를 이용하여 24시간이 넘는 시간대는 -24를 , 24시간이 안되는 시간대는 시간대 그대로
            System.out.printf("%02d:%02d\n", localHour, baseMinute);
            // String.format(%2d , 1) -> 두 자리수 정수를 입력 받는데, 부족한 부분은 0으로 채워넣기
        }
    }
}
