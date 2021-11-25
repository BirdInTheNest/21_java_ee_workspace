package com.jstl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data //기본생성자, setter/getter, toString(), hashCode()...
public class PersonDTO {
	@NonNull
	private String name;
	private int age;
}

/*
@NoArgsConstructor 
매개변수 없는 빈 생성자를 자동으로 생성해주며,
public PersonDTO() {}

@AllArgsConstructor 
객체의 모든 필드 변수들을 매개변수로 하는 생성자를 자동으로 생성합니다.
public PersonDTO(String name, int age) {}

@RequiredArgsConstructor
초기화 되지 않은 모든 final 필드, @NonNull로 마크돼있는 모든 필드들에 대한 생성자를 자동으로 생성합니다.
public PersonDTO(String name) {}
*/