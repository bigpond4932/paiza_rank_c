import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C043 {
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int numOfItemUsed = Integer.parseInt(sb.readLine());
        int[] userIds = convertStringArrayToIntArray(sb.readLine().split(" "));
        Arrays.sort(userIds);
//        System.out.println(" ---- userids ----");
//        System.out.println(Arrays.toString(userIds));

        Map<Integer, Integer> usedInfoWithUserId = new HashMap<>();
        int maxItemUsed = 0;
        int usedCount = 0;
        for(int i = 0; i < numOfItemUsed; i++){
//            System.out.println("userId : " + userIds[i]);
            if(usedInfoWithUserId.containsKey(userIds[i])){
                usedInfoWithUserId.put(userIds[i], usedInfoWithUserId.get(userIds[i]) + 1);
            }else{
                usedInfoWithUserId.put(userIds[i], 1);
            }
//            System.out.println(usedInfoWithUserId.get(userIds[i]));
        }
//        usedInfoWithUserId.forEach((int userId, int cnt) -> { // Cannot infer functional interface type?...
//
//        });
        // TODO maxcount 만큼의 사용횟수를 가진 유저들을 찾아서 배열에 저장하는 거야.
        ArrayList<Integer> mostUsedUserIds = new ArrayList<>();

        // forEach 메서드를 사용하여 키와 값을 순회
//        usedInfoWithUserId.forEach((userId, usedCnt) -> {
//            if(usedCnt == maxItemUsed){ // Variable used in lambda expression should be final or effectively final
//
//            }
//        });
        int maxUsedCount = Collections.max(usedInfoWithUserId.values());
        for(Map.Entry<Integer, Integer> entry : usedInfoWithUserId.entrySet()){
            if(entry.getValue() == maxUsedCount){
                mostUsedUserIds.add(entry.getKey());
            }
        }
        Collections.sort(mostUsedUserIds);
//        System.out.println(mostUsedUserIds.toString());
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer mostUsedUserId : mostUsedUserIds) {
            stringBuilder.append(String.format("%d ", mostUsedUserId));
        }
        System.out.println(stringBuilder.toString().trim());
    }
    public static int[] convertStringArrayToIntArray(String[] stringArray) {
        if (stringArray == null) {
            return null;
        }
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }
}
