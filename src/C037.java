import java.util.Scanner;

public class C037 {
    // C037:アニメの日時
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TODO 애니메이션이 방영되는 날짜와 시간을 입력받는다.

        String[] monthAndDate = sc.next().split("/");
        String[] hourAndMinute = sc.next().split(":");
        int month = Integer.parseInt(monthAndDate[0]);
        int date = Integer.parseInt(monthAndDate[1]);
        int hour = Integer.parseInt(hourAndMinute[0]);
        int min = Integer.parseInt(hourAndMinute[1]);
        // TODO 만약 방영시간이 24시 이후라면 방영 날짜를 갱신하고 방영 시간을 0-23시 사이로 맞춰준다.
        int[] result = changeDisplayAnimeTime(date, hour);
        date = result[0];
        hour = result[1];
        // TODO 갱신된 애니메아션 방영시간을 출력한다.
        // 이거 0으로 패딩 어떻게 하지? 5 -> 05 10 -> 10 무조건 두 자리수의 정수가 왔으면 좋겠는데?
        System.out.printf("%02d/%02d %02d:%02d%n",month,date,hour,min);
    }

    private static int[] changeDisplayAnimeTime(int date , int hour) {
        if (hour >= 24){
            return new int[]{date + hour/24, hour%24};
        }
        return new int[]{date, hour};
    }
}
