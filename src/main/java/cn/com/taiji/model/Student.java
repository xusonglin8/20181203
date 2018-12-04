package cn.com.taiji.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String sid;
   
	private String sname;
	 @ManyToMany
	    @JoinTable(name = "Student_Teacher",joinColumns = @JoinColumn(name = "student_sid"),
	    inverseJoinColumns = @JoinColumn(name = "teacher_tid"))
	 private List<Teacher> teacherList;
	public Student() {
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public Student(String sname) {
		super();
		this.sname = sname;
	}

	

}