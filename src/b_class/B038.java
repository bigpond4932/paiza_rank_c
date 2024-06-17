package b_class;

import java.util.Scanner;

public class B038 {
    // B038:つるかめ算
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TODO 동물원에 존재하는 파이자 학과 거북이의 수를 계산하는 프로그램을 만들어라.
        int totalRegs = sc.nextInt(); // 학과 거북이의 다리수의 합
        int totalNum = sc.nextInt(); // 학과 거북이의 마리수의 합
        int regByCrane = sc.nextInt(); // 학의 다리 수
        int regByTurtle = sc.nextInt(); // 거북이의 다리 수

        // TODO 내가 무엇을 할 것이냐. 학의 수를 늘려가면서 총 다리 수의 합의 조건을 만족하는 학과 거북이의 수를 찾아갈 것이다.
        findAppropriateCombination result = getFindAppropriateCombination(totalNum, regByTurtle, regByCrane, totalRegs);
        // TODO 결과는 두 가지.
        printAnswer(result);
    }

    private static void printAnswer(findAppropriateCombination result) {
        if (result.caseCount() != 1){
            System.out.println("miss");
        }else{
            System.out.printf("%d %d%n", result.numOfCranes(), result.numOfTurtles());
        }
    }

    private static findAppropriateCombination getFindAppropriateCombination(int totalNum, int regByTurtle, int regByCrane, int totalRegs) {
        int numOfCranes = 0;
        int numOfTurtles = 0;
        int caseCount = 0;
        for(int numOfCrane = 1; numOfCrane < totalNum; numOfCrane++ ){ // 학의 최대수는 total - 1
            for(int numOfTurtle = 1; numOfCrane + numOfTurtle <= totalNum; numOfTurtle++){  // 학과 거북이의 최대수는 total
                if( numOfTurtle * regByTurtle + numOfCrane * regByCrane == totalRegs && numOfTurtle + numOfCrane == totalNum){ // 마리 수 and 다리 수를 만족하는 조합을 찾는다.
                    numOfCranes = numOfCrane;
                    numOfTurtles = numOfTurtle;
                    caseCount++;
                }
                if (caseCount > 1){
                    break;
                }
            }
            if (caseCount > 1){
                break;
            }
        }
        return new findAppropriateCombination(numOfCranes, numOfTurtles, caseCount);
    }

    private record findAppropriateCombination(int numOfCranes, int numOfTurtles, int caseCount) {
    }
}
