package com.lec.emp.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.lec.emp.domain.Dept;
@Mapper
public interface DeptRepository {
	public List<Dept> deptList();
}
