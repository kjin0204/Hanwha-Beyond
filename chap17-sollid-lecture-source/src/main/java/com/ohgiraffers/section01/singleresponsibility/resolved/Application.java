package com.ohgiraffers.section01.singleresponsibility.resolved;

/* 설명.
 *  단일 책임의 원칙을 바르게 적용한다면 각각의 책임을 별도의 클래스로 분리하고
 *  각 캘래스는 자신의 데이터와 연산을 최대한 캡슐화 해서 관리한다.
* */

public class Application {
    public static void main(String[] args) {

        Employee emp = new Employee("홍길동", 40, 25000);

        /* 설명. 급여 계산 */
        PayCalculator payCalculator = new PayCalculator();
        payCalculator.applyPatRate(emp);
        /* 설명. 데이터베이스에 저장 */
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.save(emp);
        /* 설명. 근무시간 보고 */
        TimeReporter timeReporter = new TimeReporter();
        timeReporter.reportHours(emp);

    }
}
