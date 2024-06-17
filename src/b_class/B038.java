package b_class;

import java.util.Scanner;

public class B038 {
    // B038:つるかめ算
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TODO 동물원에 존재하는 파이자 학과 거북이의 수를 계산하는 프로그램을 만들어라.
        int totalLegs = sc.nextInt(); // 학과 거북이의 다리수의 합
        int totalAnimals = sc.nextInt(); // 학과 거북이의 마리수의 합
        int legsPerCrane = sc.nextInt(); // 학의 다리 수
        int legsPerTurtle = sc.nextInt(); // 거북이의 다리 수

        // TODO 내가 무엇을 할 것이냐. 학의 수를 늘려가면서 총 다리 수의 합의 조건을 만족하는 학과 거북이의 수를 찾아갈 것이다.
        AnimalCounts result = findAnimalCounts(totalAnimals, legsPerTurtle, legsPerCrane, totalLegs);
        // TODO 결과는 두 가지.
        printAnswer(result);
    }

    private static void printAnswer(AnimalCounts result) {
        if (result.caseCount() != 1){
            System.out.println("miss");
        }else{
            System.out.printf("%d %d%n", result.numOfCranes(), result.numOfTurtles());
        }
    }

    private static AnimalCounts findAnimalCounts(int totalNum, int legsPerTurtle, int legsPerCrane, int totalLegs) {
        int numCranes = 0;
        int numTurtles = 0;
        int solutionCount = 0;
        for(int numCrane = 1; numCrane < totalNum; numCrane++ ){ // 학의 최대수는 total - 1
            // 학의 수가 정해지면 거북이 수는 생각할 필요도 없이 정해진다.
            int numTurtle = totalNum - numCrane;
            // 이중 for문 삭제 && 총합을 계산하던 조건문 삭제!
            if(numTurtle * legsPerTurtle + numCrane * legsPerCrane == totalLegs){
                numCranes = numCrane;
                numTurtles = numTurtle;
                solutionCount++;
            }
            if (solutionCount > 1){
                break;
            }
        }
        return new AnimalCounts(numCranes, numTurtles, solutionCount);
    }

    private record AnimalCounts(int numOfCranes, int numOfTurtles, int caseCount) {
    }
}
