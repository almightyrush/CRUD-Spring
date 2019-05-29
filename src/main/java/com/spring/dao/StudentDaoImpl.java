package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.beans.Student;

public class StudentDaoImpl implements StudentDao{

	JdbcTemplate jdbcTemplate;
	
	public void setTemplate(JdbcTemplate jdbcTemplate) {    
	    this.jdbcTemplate = jdbcTemplate;    
	}    
	
	@Override
	public int saveData(Student student) {
		 String sql="insert into student(id,name,marks) values(" +student.getId()+ " , '"+student.getName()+"' ,"+student.getMarks()+");";    
		    return jdbcTemplate.update(sql);    
	}

	@Override
	public List<Student> getStudent() {
		return jdbcTemplate.query("select * from student",new RowMapper<Student>(){    
	        public Student mapRow(ResultSet rs, int row) throws SQLException {    
	            Student student=new Student();    
	            student.setId(rs.getInt(1));    
	            student.setName(rs.getString(2));    
	            student.setMarks(rs.getInt(3));    
	            return student;    
	        }    
	    }); 
	}

	@Override
	public int updataData(Student student) {
		String sql = "update student set name ='" + student.getName() + "', marks = "+ student.getMarks()+";";
		return jdbcTemplate.update(sql);
	}

	@Override
	public int deleteData(int id) {
		String sql = "delete from student where id="+id+"";
		return jdbcTemplate.update(sql);
	}

	@Override
	public Student getById(int id) {
		String sql="select * from student where id=?";    
	    return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));
	}

}
