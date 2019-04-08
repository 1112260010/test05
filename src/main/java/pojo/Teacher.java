package pojo;

import java.util.List;

/**
    * teacher 实体类
    * @author liangzz
    * @date2019-04-08 03:54 
    */ 

public class Teacher{
	 /****/
	private Integer tid;
	 /****/
	private String tname;

	private List<Student> list;

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public void setTid(Integer tid){
		this.tid=tid;
	}

	public Integer getTid(){
		return tid;
	}

	public void setTname(String tname){
		this.tname=tname;
	}

	public String getTname(){
		return tname;
	}
}

