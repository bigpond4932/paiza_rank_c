import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C030 {
    // C030:白にするか黒にするか
    // 2차원 배열 사실 선언만 해두고 사용은 안했다.
    // char 형 데이터에 관하여. int랑 비교할 때는 숫자로 비교 된다. String이랑 비교하면 어떻게 되지? 65부터 A
    // print로 출력하면 문자열로 취급돼서 ASCll코드 문자표의 문자로 변환된다.
    // buf readline() 사용시에 반각 스페이스까지 읽어들이는 것을 주의해서 처리해야 한다.
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        // 화상의 크기만큼의 배열을 만든다. (2차원 배열)
        String[] displayInfo = buf.readLine().split(" ");
        int h = Integer.parseInt(displayInfo[0]);
        int w = Integer.parseInt(displayInfo[1]);
//        System.out.println("h : "+ h + ", w : " + w);
//         각 배열의 값을 그레이스케일 -> 2단 스케일로 바꿔준다
        int[][] pixels = new int[h][w];

        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < pixels.length; row++){ // Array index is out of bounds
            String[] rowInfo = buf.readLine().split(" "); // 아! 띄어쓰기도 char형태로 반환이 되는구나
            for(int col = 0; col < rowInfo.length; col++){
                sb.append(isBlackOrWhite(rowInfo[col])); // 2단스케일로 변환하여 출력값에 넣어준다.
                if(col <  rowInfo.length - 1){
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        // 각 배열의 값을 출력한다. (버퍼)
        System.out.print(sb.toString());
    }
    static int isBlackOrWhite(String pixelInfo){
//        System.out.println("pixelInfo : " + pixelInfo); // 문자열로 변환하면 char 128 -> 1이된다
        if (Integer.parseInt(pixelInfo) >= 128){ // char 128 >= 128 -> true? false?
            return 1;
        }else{
            return 0;
        }
    }
}
