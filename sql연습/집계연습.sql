-- 집계쿼리 : selct 절에 통계함수 (avg, max, min, count, sum, stddev, varance, ....)

select avg(salary), sum(salary)
	from salaries;

-- select 절에 그룹함수(통계함수) 있는 경우, 어떤 컬럼도 select 절에 올 수 없다!!!!!!
-- emp_no 는 아무 의미가 없다.
-- 오류 !!!!!!!!!!!!!!
select emp_no, avg(salary)
	from salaries;
    
-- query 순서
-- 1) from : 접근 테이블 확인
-- 2) where : 조건에 맞는 row 선택 (임시 테이블)
-- 3) 집계 (결과 테이블)
-- 4) projection
-- 예제 : 사번이 10060인 사원이 받는 평균 월급은?

select emp_no, salary, from_date, to_date
	from salaries
where emp_no = '10060';

-- 5) group by에 참여하고 있는 컬럼은 projection이 가능하다. : select 절에 올 수 있다.
-- 예제 : 사원별 평균 월급은?
select avg(salary)
	from salaries
    group by emp_no;
    
-- 6) having
-- 	집계 결과(결과 테이블)에서 row를 선택해야 하는 경우.
-- 이미 where절은 실행이 되었기 때문에 having 절에서 조건을 주어야 한다.
-- 예제 : 평균 월급이 60,000 달러 이상인 사원의 사번과 월급을 출력 하세요.
select emp_no, avg(salary) as avg_salary
	from salaries
group by emp_no
having avg_salary > 60000
order by avg_salary asc;

-- 주의)
-- 	예) 사번이 10060인 사원의 사번, 급여평균, 급여총합을 출력하세요.
-- 문법적 error !!
-- 의미적으로 맞다.
select emp_no, avg(salary), sum(salary)
	from salaries
where emp_no = '10060';

-- 
select emp_no, avg(salary), sum(salary)
	from salaries
group by emp_no
having emp_no = '10060';


-- 7) order by
-- 		order by는 항상 맨 마지막 출력 전에 한다.