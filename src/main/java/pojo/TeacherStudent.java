package pojo;

import java.util.List;

/**
    * teacher_student 实体类
    * @author liangzz
    * @date2019-04-08 04:08 
    */ 

public class TeacherStudent{
	 /****/
	private Integer id;
	 /****/
	private Integer sid;
	 /****/
	private Integer tid;

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return id;
	}

	public void setSid(Integer sid){
		this.sid=sid;
	}

	public Integer getSid(){
		return sid;
	}

	public void setTid(Integer tid){
		this.tid=tid;
	}

	public Integer getTid(){
		return tid;
	}
}

