import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C018 {
    static Map<String, Integer> recipe = new HashMap<>();
    static Map<String, Integer> inventory = new HashMap<>();
    // 何人前作れる？
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfIngredients = sc.nextInt();
        for(int i = 0; i < numOfIngredients; i++){
            String nameOfIngredient = sc.next();
            int requiredNum = sc.nextInt();
            recipe.put(nameOfIngredient, requiredNum);
        }
        int inMyRefrigerator = sc.nextInt();
        for(int i = 0; i < inMyRefrigerator; i++){
            String nameOfIngredient = sc.next();
            int requiredNum = sc.nextInt();
            inventory.put(nameOfIngredient, requiredNum);
        }
        int maxServings = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : recipe.entrySet()){
            String nameOfIng = entry.getKey();
            int required = entry.getValue();
            // TODO: 레시피에 있는 재료가 내 냉장고에 존재를 하니?
            if(inventory.containsKey(nameOfIng)){
                // TODO: 몇 개나 만들 수 있니?
                // Q. 0을 정수로 나누면 문제가 생길까?
                int capacity = inventory.get(nameOfIng) / required;
                // TODO: 만들 수 있는 수 갱신
                if (capacity == 0) {
                    maxServings = 0;
                    break;
                }
                maxServings = Math.min(capacity, maxServings);
            }else{
                maxServings = 0;
                break;
            }
        }
        System.out.println(maxServings);
    }
}
