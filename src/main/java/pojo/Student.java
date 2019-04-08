package pojo;

   /**
    * student 实体类
    * @author liangzz
    * @date2019-04-02 01:45 
    */ 

public class Student{
	 /****/
	private Integer sid;
	 /****/
	private String sname;
	 /****/
	private Integer sage;

	   @Override
	   public String toString() {
		   return "Student{" +
				   "sid=" + sid +
				   ", sname='" + sname + '\'' +
				   ", sage=" + sage +
				   '}';
	   }

	   public void setSid(Integer sid){
		this.sid=sid;
	}

	public Integer getSid(){
		return sid;
	}

	public void setSname(String sname){
		this.sname=sname;
	}

	public String getSname(){
		return sname;
	}

	public void setSage(Integer sage){
		this.sage=sage;
	}

	public Integer getSage(){
		return sage;
	}
}

