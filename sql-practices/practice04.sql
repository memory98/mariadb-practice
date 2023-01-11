-- 문제1 : 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select count(*)
	from salaries s
  where s.salary > (
                   select avg(s.salary) as avg_salary
				 from salaries s
                 where s.to_date = '9999-01-01'
  ) 
  and s.to_date = '9999-01-01'
;
                 
 -- (x) 문제2 : 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 


-- 문제3 : 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 급여을 조회하세요 
select e.first_name, e.emp_no, de.dept_no, s.salary, avgs.avg_salary 
	from employees e join dept_emp de on e.emp_no = de.emp_no
					 join salaries s on e.emp_no = s.emp_no
				join (
								select de.emp_no as emp_num, de.dept_no as dept_num, avg(s.salary) as avg_salary
								from dept_emp de join salaries s on de.emp_no = s.emp_no  
												 join employees e on s.emp_no = e.emp_no
								where de.to_date = '9999-01-01'
								and s.to_date = '9999-01-01'
							 group by de.dept_no
							)avgs
    on de.dept_no = avgs.dept_num	 
where de.to_date = '9999-01-01'
 and s.salary >avgs.avg_salary
;



-- 문제4 : 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
select e.emp_no, concat(e.first_name, " " ,e.last_name) as name, mng.mng_name, d.dept_name
	from employees e join dept_emp de on e.emp_no = de.emp_no
					 join departments d on de.dept_no = d.dept_no
					 join (
									select dm. dept_no, e.emp_no, concat(e.first_name," ",e.last_name) as mng_name
								from dept_manager dm join employees e on dm.emp_no = e.emp_no
							where dm.to_date = '9999-01-01'
                     ) mng on de.dept_no = mng.dept_no 
 where de.to_date = '9999-01-01';
-- 문제5 : 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 급여을 조회하고 급여 순으로 출력하세요.
select e.emp_no as '사번', concat(e.first_name, " " ,e.last_name) as '이름', t.title as '직책', s.salary as '급여'
	from employees e join dept_emp de on e.emp_no = de.emp_no
					 join salaries s on de.emp_no = s.emp_no
                     join titles t on s.emp_no = t.emp_no
                     join (
									 select de.dept_no as lrg_dept_no, avg(s.salary)
								from dept_emp de join salaries s on de.emp_no = s.emp_no
							 group by de.dept_no
							order by avg(s.salary) desc
							limit 1
                     ) lrg_dept
					on de.dept_no = lrg_dept.lrg_dept_no
	where s.to_date = '9999-01-01'
    and t.to_date='9999-01-01'
    ;
    
-- 문제6 : 평균 급여가 가장 높은 부서는? 
select de.dept_no as '부서번호', d.dept_name as '부서 이름',avg(s.salary) as '평균 급여'
	from salaries s join dept_emp de on s.emp_no = de.emp_no
					join departments d on de.dept_no = d.dept_no
group by de.dept_no
order by avg(s.salary) desc
limit 1
;

-- 문제7 :평균 급여가 가장 높은 직책?
select t.title, avg(s.salary)
	from salaries s join titles t on s.emp_no = t.emp_no
group by t.title
order by avg(s.salary) desc
limit 1
;

-- 문제8 : 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.
select dm.dept_no as mng_dept_no, concat(e.first_name," ",last_name) as mng_name, s.salary as mng_salary
	from employees e join dept_emp de on e.emp_no = de.emp_no
					 join dept_manager dm on de.dept_no = dm.dept_no
					 join salaries s on e.emp_no = s.emp_no
        where dm.to_date ='9999-01-01'
	group by dm.emp_no;

select d.dept_name as '부서이름', concat(e.first_name," ",e.last_name) as '이름',s.salary as '급여', mng.mng_name as '담당 매니저 이름',mng.mng_salary as '담당 매니저 급여'
	from employees e join salaries s on e.emp_no = s.emp_no
					 join dept_emp de on s.emp_no = de.emp_no
                     join departments d on de.dept_no = d.dept_no
                     join (
												 select dm.dept_no as mng_dept_no, concat(e.first_name," ",last_name) as mng_name, s.salary as mng_salary
											from employees e join dept_emp de on e.emp_no = de.emp_no
															 join dept_manager dm on de.dept_no = dm.dept_no
															 join salaries s on e.emp_no = s.emp_no
										where dm.to_date ='9999-01-01'
                                        and s.to_date = '9999-01-01'
										group by dm.emp_no
                     ) mng
	 where s.salary > mng.mng_salary
    ;
                     
                     
                     
                     
                     
                     
                     