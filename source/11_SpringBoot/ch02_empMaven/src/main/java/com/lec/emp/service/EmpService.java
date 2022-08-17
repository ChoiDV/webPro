package com.lec.emp.service;
import java.util.List;
import com.lec.emp.domain.Dept;
import com.lec.emp.domain.Emp;
public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp searchEmp);
}
