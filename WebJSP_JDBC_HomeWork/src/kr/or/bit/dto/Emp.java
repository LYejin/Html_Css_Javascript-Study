package kr.or.bit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Emp {
	@NonNull
	private String id;
	@NonNull
	private String pwd;
	private String name;
	private int age;
	private String gender;
	private String email;
	private String ip;
	@Override
	public String toString() {
		return "Emp [id=" + id + ", pwd=" + pwd + ", name=" + name + ", age=" + age + ", gender=" + gender + ", email="
				+ email + ", ip=" + ip + "]";
	}
}
