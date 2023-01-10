-- inner join-

-- 예제 1) 현재, 근무하고 있는 직원의 이름과 직책을 모두 풀력하세요.
select a.first_name, b.title
	from employees a, titles b
 where a.emp_no = b.emp_no		-- join 조건(n-1)
and b.to_date = '9999-01-01'; -- row 선택 조건
        
-- 예제 2) 현재, 근무하고 있는 직원의 이름과 직책을 출력하되 여성 엔지니어(Engineer)만 출력하세요.
select a.first_name, a.gender, b.title
	from employees a, titles b
 where a.emp_no = b.emp_no 		-- join 조건(n-1)
and b.to_date = '9999-01-01'	-- row 선택 조건 1
 and a.gender = 'f'				-- row 선택 조건 2
 and b.title = 'Engineer';		-- row 선택 조건 3
 
 -- 
 -- ANSI/OSP SQL1999 JOIN 표준 문법
 -- 
 
 -- 1) Natual Join
 -- 	조인 대상이 되는 두 테이블에 이름이 같은 고통 컬럼이 있으면 조인 조건을 
 -- 	명시하지 않고 암묵적으로 조인이 된다.
select a.first_name, b.title
	from employees a natural join titles b 
 where b.to_date = '9999-01-01'; 
 
-- 2) Join ~ Using
-- 		natual Join의 문제점 
select count(*)
	from salaries a join titles b using(emp_no)
    where a.to_date = '9999-01-01'
    and b.to_date = '9999-01-01';

 -- 3) joing ~ on ***
 -- 예제) 현재, 직책별 평균 연봉을 큰 순서대로 출력하세요.
 select b.title, avg(a.salary)
	from salaries a join titles b on a.emp_no = b.emp_no
	where a.to_date = '9999-01-01'
    and b.to_date = '9999-01-01'
    group by b.title
order by salary desc;
 
-- 실습 문제1
-- 현재, 직원 별 근무 부서를 사번, 지원 이름, 부서명으로 출력하세요.
 select e.emp_no, e.first_name, d.dept_name
	from dept_emp de join employees e on e.emp_no = de.emp_no
					 join departments d on d.dept_no = de.dept_no 
 where de.to_date = '9999-01-01'
 ;
 
-- 실습 문제2
--  현재, 지급되고 있는 급여를 출력 해보세요.
-- 사번, 이름, 급여 순으로 출력.
select e.emp_no, e.first_name, s.salary
	from employees e join salaries s on e.emp_no = s.emp_no
 where s.to_date = '9999-01-01';

-- 실습 문제3
-- 현재, 직책별 평균연봉, 직원 수를 구하되 직책별 직원 수가 100 명 이상인 직책만 출력하세요.
select t.title, avg(s.salary), count(*)
	from titles t join salaries s on t.emp_no = s.emp_no
 where s.to_date = '9999-01-01'
 group by t.title
 having count(*)>=100;

-- 실습 문제4
-- 현재, 부서별로 직책이 Engineer인 직원들에 대해서만 평균 급여를 구하세요.
-- 부서이름, 평균급여 순으로 출력하세요.
  select d.dept_name, avg(s.salary)
    from employees e join titles t on e.emp_no = t.emp_no
					 join salaries s on t.emp_no = s.emp_no
					 join dept_emp de on s.emp_no = de.emp_no
                     join departments d on de.dept_no = d.dept_no 
 where s.to_date = '9999-01-01'
 and t.to_date = '9999-01-01'
 and de.to_date = '9999-01-01'
 and t.title = 'Engineer'
 group by d.dept_name
order by avg(s.salary) desc;
 
select a.dept_name, avg(d.salary) 
    from departments a, dept_emp b, titles c, salaries d
where a.dept_no = b.dept_no
	and b.emp_no = c.emp_no
    and c.emp_no = d.emp_no
    and b.to_date = '9999-01-01'
    and c.to_date = '9999-01-01'
    and d.to_date = '9999-01-01'
    and c.title = 'Engineer'
group by a.dept_name
order by avg(d.salary) desc;