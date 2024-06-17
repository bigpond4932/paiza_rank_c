import java.util.*;

public class C129 {
    // C129:工場の検品
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO 스시의 종류 M, 한 팩에 들어갈 스시의 수 N
         sc.nextInt(); // 필요 없지만, 형식을 맞추기 위해 추가.
        int numOfSushiByOnePack = sc.nextInt();
        // TODO 포장할 스시를 주어진 스시로 만들 수 있냐를 판단하는 것이 목적
        
        // TODO 포장할 스시의 종류와 개수를 기억한다.
        Map<String, Integer> sushiRequired = readSushi(numOfSushiByOnePack);
        Map<String, Integer> sushiGiven = readSushi(numOfSushiByOnePack);

        // TODO 포장할 수 있니? 판단기준 1: 주어진 스시의 종류가 포장할 스시 종류를 모두 포함하고 있어야 함.
        // TODO 포장할 수 있니? 판단기준 2: 포장해야 할 스시 중에 새우초밤은 두 개가 필요한데 주어진 스시종류의 새우초밥은 하나라면 안되지 -> 종류 + 개수를 만족해야함.

        // TODO 스시 포장 요구조건과 주어진 스시정보를 비교하여 포장여부를 판단한다.
        if(sushiRequired.equals(sushiGiven)) { // Map끼리 equals로 요소 비교가 가능하구나
            System.out.println("Yes");
        }else{  
            System.out.println("No");
        }
    }

    private static Map<String, Integer> readSushi(int numOfSushiByOnePack) {
        Map<String, Integer> sushiMap = new HashMap<>();
        for(int i = 0; i < numOfSushiByOnePack; i++){
            String typeOfSushi = sc.next();
            sushiMap.put(typeOfSushi, sushiMap.getOrDefault(typeOfSushi, 0) + 1); // 코드를 더욱 간결하게 만들어준다. 키가 있는지 없는지 판단 안해도 됨.
        }
        return sushiMap;
    }
}
