////Lv.2
//package com.example.calculator;
//import java.util.Scanner;
//public class App {
//    public static void main(String[] args) {
//        Calculator calcultator = new Calculator();
//        Scanner sc = new Scanner(System.in);
//
//        while (true) {
//            System.out.print("첫번째 숫자를 입력해주세요. (종료 시 : exit) : ");
//            String input1 = sc.nextLine();
//            if(input1.equalsIgnoreCase("exit")){
//                System.out.println("프로그램을 종료합니다.");
//                break;
//            }
//            int num1 = Integer.parseInt(input1);
//            System.out.print("두번째 숫자를 입력해주세요. (종료 시 : exit) : ");
//            String input2 = sc.nextLine();
//            if(input2.equalsIgnoreCase("exit")){
//                System.out.println("프로그램을 종료합니다.");
//                break;
//            }
//            int num2 = Integer.parseInt(input2);
//            System.out.print("사칙 연산 기호를 입력해주세요.(+, -, *, /) : ");
//            char operator = sc.next().charAt(0);
//            try {
//                int result = calcultator.calculate(num1, num2, operator);
//                System.out.println("결과 : " + result);
//            } catch (IllegalArgumentException e){
//                System.out.println(e.getMessage());
//                continue;
//            }
//            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료) ");
//            String continueInput = sc.nextLine();
//            if(continueInput.equalsIgnoreCase("exit")){
//                System.out.println("프로그램을 종료합니다.");
//                break;
//            }
//        }
//        System.out.println("저장된 결과 : " + calcultator.getResults());
//        System.out.println("가장 먼저 저장된 결과를 삭제합니다.");
//        calcultator.removeResult();
//        System.out.println("저장된 결과 : " +calcultator.getResults());
//        sc.close();
//    }
//}

//Lv.3 + 계산기 히스토리 조회 기능 추가 (마지막 계산 결과 불러오기)
package com.example.calculator;
import java.util.Scanner;
import java.util.List;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
        double result1 = calculator.calculate(10,20, OperatorType.ADD);
        calculator.storeResult(result1);
        double result2 = calculator.calculate(30,5, OperatorType.SUBTRACT);
        calculator.storeResult(result2);
        Double firstResult = calculator.getResultAt(0);
        System.out.println("첫번째 계산 결과: " + firstResult);
        System.out.println("계산 히스토리: " + calculator.getResults());
        while (true) {
            System.out.print("첫번째 숫자를 입력해주세요. : ");
            double num1 = sc.nextDouble();
            System.out.print("두번째 숫자를 입력해주세요. : ");
            double num2 = sc.nextDouble();
            System.out.print("연산 기호를 입력해주세요. (+,-,*,/) : ");
            char operatorChar = sc.next().charAt(0);
            OperatorType operator = null;
            switch (operatorChar) {
                case '+':
                    operator = OperatorType.ADD;
                    break;
                case '-':
                    operator = OperatorType.SUBTRACT;
                    break;
                case '*':
                    operator =  OperatorType.MULTIPLY;
                    break;
                case '/':
                    operator =  OperatorType.DIVIDE;
                    break;
                default:
                    System.out.println("유효하지 않은 연산자 입니다. 다시 입력해주세요.");
                    continue; //잘못된 연산자는 다시 입력받기
            }
            double result = calculator.calculate(num1, num2, operator);
            System.out.println("계산 결과 :  " + result);

            calculator.storeResult(result);

            System.out.println("계산된 결과: " + calculator.getResults());
            System.out.println("입력한 값보다 큰 계산 결과들 : "+ calculator.getResultsGreaterThan(10));
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료됩니다.) : ");
            String continueInput = sc.next();
            if(continueInput.equalsIgnoreCase("exit")) {
                break;
            }
            sc.close();
        }
    }
}
