//Lv.3 제네릭 사용
package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    // 결과 저장 리스트
    private List<T> results = new ArrayList<>();

    // 결과 계산 메서드
    public T calculate(double num1, double num2, OperatorType operator) {
        double result = operator.apply(num1, num2); //double 타입의 값을 전달받음
        // 결과를 제네릭 타입으로 반환
        return (T) (Number) result;
    }

    // 결과 저장 메서드
    public void storeResult(T result) {
        results.add(result);
    }

    // 결과 조회 (입력한 값보다 큰 결과만) 제네릭 사용
    public List<T> getResultsGreaterThan(double value) {
        List<T> filteredResults = new ArrayList<>();
        for (T result : results) {
            if (result.doubleValue() > value) {
                filteredResults.add(result);
            }
        }
        return filteredResults;
    }
//    // 람다 + 스트림 사용 시
//    public List<T> getResultsLessThan(double value) {
//        return results.stream() // 스트림 사용
//                .filter(result -> result.doubleValue() > value) // 람다 사용
//                .toList();
//    }
    // 저장된 결과 반환
    public List<T> getResults() {
        return new ArrayList<>(results);
    }

    //계산된 결과들을 출력하는 메서드 (히스토리 기능 구현)
    public void printHistory() {
        if (results.isEmpty()) {
            System.out.println("계산 히스토리가 없습니다.");
        } else {
            System.out.println("계산 히스토리: ");
            for (T result : results) {
                System.out.println(result);
            }
        }
    }
    ////람다 사용
//    public void printHistory() {
//        if(results.isEmpty()) {
//            System.out.println("계산 히스토리가 없습니다.");
//        } else {
//            System.out.println("계산 히스토리 : ");
//            results.forEach(result -> System.out.println(result));
//        }
//    }
    //마지막 계산된 결과를 반환
    public T getLastResult() {
        if (!results.isEmpty()) {
            return results.get(results.size() - 1);
        } else {
            System.out.println("계산된 결과가 없습니다.");
            return null;
        }
    }

    public T getResultAt(int i) {
        return results.get(i);
    }
}