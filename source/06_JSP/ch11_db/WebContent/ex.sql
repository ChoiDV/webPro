SELECT * FROM EMP; -- 실행은 실행하고자하는 sql문을 블럭잡고 alt+x => result탭에 결과
SELECT * FROM DEPT;
SELECT * FROM EMP WHERE DEPTNO=10;
SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER('al')||'%';
DESC EMP;