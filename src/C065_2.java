import java.util.*;

public class C065_2 {
    //TODO ★★★ 단계별로 스탭바이스탭. 비교대상이 a,b,c면 a,b를 비교하고 c와 비교하자! 디버거를 자주 이용하자! 수학적 개념이 문제를 해결하는데 필요하구나! ★★★
    private static final List<Integer> dividers = new ArrayList<>();
    private static int[] dividersArr;
    static int loopCnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TODO 조건이 주어진다. 조건을 모두 만족하는 수 x를 구하자
        int x = 0;
        // TODO 조건은 연산자와 숫자로 구분된다.
        // INFO > n x는 n보다 큰 수이다. x > n == true
        // INFO < n x는 n보다 작은 수이다. x < n == true
        // INFO / n x는 n으로 나누어 떨어지는 수이다. x % n = 0
        // TODO x 후보군(범위)을 정한다.
        int biggerThanX = Integer.MIN_VALUE;
        int smallerThanX = Integer.MAX_VALUE;
        // > 1 , > 5 , > 9999 x의 범위는 9999를 기준으로 찾아야지 그치?
        // TODO 조건을 모두 확인한다. (x의 범위 / 약수를 기억한다.)
        int numOfHints = sc.nextInt();
        for(int i = 0; i < numOfHints; i++){
            String operator = sc.next();
            int num = sc.nextInt();
            if(operator.equals("/")){
                dividers.add(num);
            }else {
                if(operator.equals(">")){
//                    if (num > biggerThanX){
//                        biggerThanX = num;
//                    }
                    biggerThanX = Math.max(biggerThanX, num); //TODO ★★★ 더 큰 값을 얻고 싶을 때 if문 보다 Math.max ★★★
                }else{
//                    if (num < smallerThanX){
//                        smallerThanX = num;
//                    }
                    smallerThanX = Math.min(smallerThanX, num); //TODO ★★★ 더 작은 값을 얻고 싶을 때 if문 보다 Math.min ★★★
                }
            }
        }
        dividersArr = dividers.stream().mapToInt(Integer::intValue).toArray(); //TODO ★★★ stream을 이용한 컬렉션 객체 배열 변환 ★★★

        // 최소공배수 계산
        int lcm = calculateLCM(dividersArr);
        System.out.println(lcm);
//        System.out.println("biggerThanX : " + biggerThanX);
//        System.out.println("smallerThanX : " + smallerThanX);
//        System.out.println(dividers.toString());
        // TODO 모든 x의 후보군에서 x의 약수인 n을 모두 만족시키는 x를 찾는다.
        for(int i = biggerThanX + 1; i < smallerThanX; i++){
            if(findX(i)){
                x = i;
                break;
            }
        }
        System.out.println(x);
        System.out.println(loopCnt);
    }
    private static boolean findX(int candidateX) {
        boolean isX = true;
        // 최대 반복 회수는 몇회나 될까?
        // x의 후보군 수 * 약수 개수 (x후보군이 100개고 약수의 개수가 5개면 최대 500회? 그치?)
        // 반복회수를 줄이려면 약수들의 최소공배수를 구하는 것이 좋겠다.
        for(int divider : dividersArr){
            loopCnt++;
            if(candidateX%divider != 0){
                return !isX;
            }
        }
        return isX;
    }
    // 두 수의 최소공배수 계산
    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    // 두 수의 최대공약수 계산　★ 유클리드 호제법 (최대공약수를 구하는 방식) 쉽게 생각 못할 법 했네..
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    // 최소공배수 계산 함수
    private static int calculateLCM(int[] numbers) {
        int lcm = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            lcm = lcm(lcm, numbers[i]); // TODO ★★★ 최소공배수를 구하는 편이 반복을 많이 줄인다 ★★★
        }
        return lcm;
    }

}
