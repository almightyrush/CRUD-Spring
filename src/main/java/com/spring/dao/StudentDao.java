package com.spring.dao;

import java.util.List;

import com.spring.beans.Student;

public interface StudentDao {

	public int saveData(Student student);
	public int updataData(Student student);
	public int deleteData(int id);
	public List<Student> getStudent();
	public Student getById(int id);
}
