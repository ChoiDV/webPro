package com.lec.alist.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	private String name;
	private String id;
	private String pw;
	// 폼데이터 사용을 위해 : getter & 매개변수 없는 생성자
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{'name': '" + name + "', 'id' : '" +id +"', 'pw' : '"+ pw + "'}";
	}
}
