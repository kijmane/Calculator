// Lv.1
package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("첫번째 숫자를 입력해주세요. (종료 시 exit를 입력해주세요.) : ");
            String input1 = sc.nextLine();
            if (input1.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            int num1 = Integer.parseInt(input1);

            System.out.print("두번째 숫자를 입력해주세요. (종료 시 exit를 입력해주세요.) : ");
            String input2 = sc.nextLine();
            if (input2.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            int num2 = Integer.parseInt(input2);

            System.out.print("사칙 연산 기호를 입력해주세요. (+,-,*,/) : ");
            char operator = sc.next().charAt(0);

            int result = 0;
            boolean validOperation = false; //연산이 유효한지 여부를 추적함. false의 의미는 연산이 시작되기 전에는 유효하지 않다고 설정하는 역할.
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수) 0이 입력될 수 없습니다.");
                        validOperation = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("유효하지 않은 연산자입니다. 사칙 연산 기호를 입력해주세요. (+,-,*,/) : ");
                    validOperation = false;
            }
            if (validOperation) { // 만약 true 이면 연산 결과를 출력하라는 조건문
                System.out.println("결과 : " + result);
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String continueInput = sc.nextLine();
            if (continueInput.equalsIgnoreCase("exit")) { // 대소문자를 구문할 수 있는 메서드
                System.out.println("프로그램을 종료합니다.");
                break;
            }

        }
    }
}

/// /LV.2
//package com.example.calculator;
//import java.util.ArrayList;
//import java.util.List; //결과를 저장하기 위한 인터페이스
//public class Calculator {
//    private List<Integer> results; //여러 개의 Integer값을 저장할 수 있다.
//    public Calculator() {
//        this.results = new ArrayList<>();
//    }
//    public int calculate(int num1, int num2, char operator) {
//        int result = 0; //연산 결과 저장할 초기값
//        switch (operator) {
//            case '+':
//                result = num1 + num2;
//                break;
//            case '-':
//                result = num1 - num2;
//                break;
//            case '*':
//                result = num1 * num2;
//                break;
//            case '/':
//                if(num2 == 0) { //분모가 0인 경우
//                    throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
//                }
//                result = num1 / num2;
//                break;
//                default: //연산기호중 어느 것도 아닐 때
//                    throw new IllegalArgumentException("유효하지 않은 연산자입니다. 사칙 연산 기호를 입력해주세요. (+,-,*,/) : ");
//        }
//        results.add(result); //reult 값을 results리스트에 추가함으로서 계산된 결과 계속 저장 가능
//        return result; //result값 반환
//    }
//    public List<Integer> getResults() { //results 리스트를 반환하는 메서드
//        return new ArrayList<>(results);
//    }
//    public void removeResult() { //reulsts 리스트가 비어있지 않으면 첫 번째 요소 삭제
//        if(!results.isEmpty()) {
//            results.remove(0);
//        } else { // 만약 리스트 비어있으면
//            System.out.println("삭제할 결과가 없습니다.");
//        }
//    }
//}
