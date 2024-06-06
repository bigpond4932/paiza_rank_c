import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class C031 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int numOfTimezones = Integer.parseInt(buf.readLine());
//        System.out.println("numOfTimezones : " + numOfTimezones);
//        Map<String, Integer> timeDiffMap = new HashMap<>();
        Map<String, Integer> timeDiffMap = new LinkedHashMap<>();
        for (int i = 0; i < numOfTimezones; i++){
            String[] info = buf.readLine().split(" ");
            timeDiffMap.put(info[0], Integer.parseInt(info[1]));
        }
//         {tokyo=9, singapore=7, osaka=9, london=0, newyork=-5, beijing=8} 순서를 보장 안하나?... Map은 딱히 인덱스가 없나? -> LinkedHashMap
//        System.out.println(timeDiffMap.toString());

        String[] info2 = buf.readLine().split(" ");
        String uploadCountryName = info2[0];
        String[] uploadTimeInfo = info2[1].split(":");
        int uploadHour = Integer.parseInt(uploadTimeInfo[0]);
        int uploadMinute = Integer.parseInt(uploadTimeInfo[1]);
//        System.out.println("uploadCountryName : " + uploadCountryName + ", uploadHour : " + uploadHour + ", uploadMinute : " + uploadMinute);

        // 기준 시각을 찾아.
        int standardTime = calStandardHour(uploadHour, uploadCountryName, timeDiffMap);
        StringBuilder sb = new StringBuilder();
        timeDiffMap.forEach( (countryName, timeDiff) -> {
            String timePerCountry = String.format("%02d:%02d\n", calHour(standardTime ,timeDiff), uploadMinute);
            sb.append(timePerCountry);
        });
        System.out.print(sb.toString());
    }
    static int calStandardHour(int uploadHour, String uploadCountryName, Map<String, Integer> timeDiffMap){
        int standardHour;
        if (uploadHour - timeDiffMap.get(uploadCountryName) >= 24){
            standardHour = uploadHour - timeDiffMap.get(uploadCountryName) - 24;
        }else if(uploadHour - timeDiffMap.get(uploadCountryName) < 0){
            standardHour = uploadHour - timeDiffMap.get(uploadCountryName) + 24;
        }else{
            standardHour = uploadHour - timeDiffMap.get(uploadCountryName);
        }

        return standardHour;
    }
    static int calHour(int StandardTime, int timeDiff){
        int hour;
        if (StandardTime + timeDiff >= 24){
            hour = StandardTime + timeDiff - 24;
        }else if(StandardTime + timeDiff < 0){
            hour = StandardTime + timeDiff  + 24;
        }else{
            hour = StandardTime + timeDiff;
        }
        return hour;
    }
}
