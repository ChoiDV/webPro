-- Dept.xml의 id=deptList
SELECT * FROM DEPT;
-- Emp.xml의 id=empList
SELECT * FROM EMP WHERE 1=1 
    AND ENAME LIKE '%'||'A'||'%'
    AND JOB LIKE '%'||'E'||'%'
    AND DEPTNO=20;