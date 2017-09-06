package cn.xzf.db;

import cn.xzf.entityAll.Student;
import cn.xzf.util.ExRowMapper;
import cn.xzf.util.Execute;

public class StudentDao 
{
	private Execute ecu=new Execute();
	public Student findByname(String username)
	{
		String sql="select * from student where username=?";
		return ecu.findQuery(sql,new ExRowMapper<Student>(Student.class),username);
	}
	public void save(Student student) 
	{
		String sql="insert into student(username,password)values(?,?)";
		ecu.executeUp(sql,student.getUsername(),student.getPassword());
	}
	public void Pupdate(Student student) 
	{
		String sql="update student set password=? where id=?";
		ecu.executeUp(sql,student.getPassword(),student.getId());
	}
}
