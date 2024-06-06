import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class C149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String correctionRule = sc.next();
        String targetStr = sc.next().toLowerCase();
        char[] eachRules = correctionRule.toCharArray();
        char[] targetChars = targetStr.toCharArray();
        for(int index = 0; index < targetChars.length; index++){ // 오 배열은 () 필요없네
            if(!checkRule(targetChars[index] , eachRules)){
                targetChars[index] = Character.toUpperCase(targetChars[index]);
                // 특정 인덱스의 문자열을 바꿔주는 방법은 없나?
            }
        }
        for(char c : targetChars){
            System.out.print(c);
        }
    }
    static boolean checkRule(char target, char[] checkRules){
        boolean result = false;
        for(char rule : checkRules){
            if(target == rule){
                result = true;
                break;
            }
        }
        return result;
    }
}
