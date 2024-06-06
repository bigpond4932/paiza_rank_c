import java.util.*;

public class C029 {
    // C029:旅行の計画
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int holidays = sc.nextInt();
        int durationOfTrip = sc.nextInt();
//        int[] days = new int[holidays];
//        int[] rainGaugeByDay = new int[holidays];
        Map<Integer, Integer> dateWithRainGauge = new LinkedHashMap<>();
        Map<Integer, Integer> tripWithRainGauge = new LinkedHashMap<>();

        for(int i = 0; i < holidays; i++){
            // 날짜별 강수확률 세팅
            dateWithRainGauge.put(sc.nextInt(),sc.nextInt());
        }
//        System.out.println(Arrays.toString(days));
//        System.out.println(Arrays.toString(rainGaugeByDay));
        // 휴가 첫번째 날짜가 될 수 있는 날짜를 루프
        // 휴가에서의 모든 강수확률 경우의 수 찾기 (여행 기간만큼 루프를 돌려야 함
        for(Map.Entry<Integer, Integer> entry : dateWithRainGauge.entrySet()){
            int rainPoint = 0;
            int firstDay = entry.getKey();
            int lastDay = firstDay + durationOfTrip - 1;
            if(dateWithRainGauge.containsKey(lastDay)){
                for(int i = firstDay; i <= lastDay; i++){
                    // 강수확률 계산하기
                    rainPoint += dateWithRainGauge.get(i);
                }
                tripWithRainGauge.put(firstDay, rainPoint);
            }
        }
//        System.out.println(Collections.min(tripWithRainGauge.values()));
        int lowestRainPower = Collections.min(tripWithRainGauge.values());
        List<Integer> earlyDays = new ArrayList<>();
        // 가장 빠른 날짜 찾기
        for(Map.Entry<Integer, Integer> entry : tripWithRainGauge.entrySet()){
            if(entry.getValue() == lowestRainPower){
                earlyDays.add(entry.getKey());
            }
        }
        Collections.sort(earlyDays);
        System.out.printf("%d %d", earlyDays.getFirst(), earlyDays.getFirst() + durationOfTrip -1);
    }
}
