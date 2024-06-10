import java.util.Scanner;

public class C069 {
    // C069:お祭りの日付
    static final int YEAR2DAY = 181;
    static final int DAY2MONTH2 = 28;
    static final int EVENMONTH2DAY = 15;
    static final int ODDMONTH2DAY = 13;
    public static void main(String[] args) {
        // TODO 현재 날짜를 구한다.
        Scanner sc = new Scanner(System.in);
        int nowY = sc.nextInt();
        int nowM = sc.nextInt();
        int nowD = sc.nextInt();
        int partyM = sc.nextInt();
        int partyD = sc.nextInt();

        // TODO 다음 있을 파이자축제의 년도를 구한다
        int partyY = findPaizaPartyYear(nowY);
//        System.out.println("다음 축제 년도는 ? : " + partyY);

        // TODO 현재 날짜를 0년 0월 부터 몇 일이 지났는지 구한다.
        int fromZeroToNow = calDays(nowY, nowM, nowD);
//        System.out.println("현재 날짜를 절대 값으로 바꾸면? : " + fromZeroToNow);
        // TODO 축제 날짜를 0년 0월 부터 몇 일이 지났는지 구한다.
        int fromZeroToNextParty = calDays(partyY, partyM, partyD);
//        System.out.println("다음 파티 날짜를 절대 값으로 바꾸면? : " + fromZeroToNextParty);
        // TODO 다음 파이자 파티까지 몇 일이나 남았는지 구한다.
        System.out.println(fromZeroToNextParty - fromZeroToNow);
    }

    private static int calDays(int Y, int M, int D) {
        int result = 0;
        result += Y * YEAR2DAY;
        // 아 여기서 for문으로 날짜별로 더하면 되는구나..
        if( M%2 == 0){
            // M이 짝수일 경우. M을 포함하여 몇 개의 페어가 존재하는 지 확인한다.
            result += M/2 * DAY2MONTH2 - (EVENMONTH2DAY - D);
        }else{
            // M이 홀수일 경우. M을 포함하지 않는 페어가 몇개 존재하는지 확인 + 현재 달의 일수를 더함
            result += M/2 * DAY2MONTH2 + D;
        }
        return result;
    }

    private static int findPaizaPartyYear(int nowY) {
        while(nowY % 4 != 1){
            nowY++;
        }
        return nowY;
    }
}
