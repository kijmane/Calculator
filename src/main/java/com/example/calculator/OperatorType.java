//Lv.3 + 계산기 히스토리 조회 기능 추가 (마지막 계산 결과 불러오기)
package com.example.calculator;

public enum OperatorType {
    ADD {
        @Override
        public double apply(double num1, double num2) {
            return num1 + num2;
        }
    },
    SUBTRACT {
        @Override
        public double apply(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLY {
        @Override
        public double apply(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVIDE {
        @Override
        public double apply(double num1, double num2) {
            if (num2 == 0) { //만약 분모가 0이라면
                throw new IllegalArgumentException("나눗셈에서 0으로 나눌 수 없습니다.");
            }
            return num1 / num2;
        }
    };

    public abstract double apply(double num1, double num2);
}