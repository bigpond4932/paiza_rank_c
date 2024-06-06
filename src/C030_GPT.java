import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C030_GPT {
    public static void main(String[] args) {
        // 익셉션 처리를 분명하게 표시함.
        // 사용하지 않는 픽셀이라는 배열 삭제
        // for문의 조건문을 간결하게 바꿈
        // 삼항연산자를 이용한 간결한 코드 작성 128 >= pixelInfo ? 1 : 0
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            String[] displayInfo = buf.readLine().split(" ");
            int h = Integer.parseInt(displayInfo[0]);
            int w = Integer.parseInt(displayInfo[1]);

            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < h; row++) {
                String[] rowInfo = buf.readLine().split(" ");
                for (int col = 0; col < w; col++) {
                    sb.append(isBlackOrWhite(rowInfo[col]));
                    if (col < w - 1) {
                        sb.append(" ");
                    }
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array index out of bounds: " + e.getMessage());
        }
    }

    static int isBlackOrWhite(String pixelInfo) {
        int pixelValue = Integer.parseInt(pixelInfo);
        return pixelValue >= 128 ? 1 : 0;
    }
}
