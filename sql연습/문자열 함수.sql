-- 문자열 함수

-- upper
select upper('busan'), ucase('BusaN'),upper('Busan') from dual;
select upper(first_name) from employees order by upper(first_name);

-- lower;
select lower('BUSAN'), lcase('BusaN'), lower('Busan') from dual;
 
 -- substring(문자열, index, length)
 select substring('hello World', 3,2);
 
 -- 예제) 1989년에 입사한 사원들의 이름, 입사일을 출력하라
 select first_name, hire_date 
	from employees
    where substring(hire_date,1,4) = '1989';
    
-- lpad(왼쪽 정렬), rpad(오른쪽 정렬)
select lpad('1234',10,'-'), rpad('1234',10,'-'); 

-- 예제) 직원들의 월급을 오른쪽 정렬(빈공간 *)
select lpad(salary,10,'*') from salaries;

-- trim, ltrim, rtrim
select concat('---',ltrim('     hello     '),'---');
select concat('---',rtrim('     hello     '),'---');
select concat('---',trim(leading 'x' from 'xxxxxhelloxxxxx'),'---');
select concat('---',trim(trailing 'x' from 'xxxxxhelloxxxxx'),'---');
select concat('---',trim(both 'x' from 'xxxxxhelloxxxxx'),'---');

-- length
select length('hello world') from dual;