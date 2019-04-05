package pojo;
import java.util.Date;

   /**
    * easybuy_user_address 实体类
    * @author liangzz
    * @date2019-04-04 04:05 
    */ 

public class UserAddress {
	 /**主键id**/
	private Integer id;
	 /**用户主键**/
	private Integer userId;
	 /**地址**/
	private String address;
	 /**创建时间**/
	private Date createTime;
	 /**是否是默认地址（1:是 0否）**/
	private Integer isDefault;
	 /**备注**/
	private String remark;

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return id;
	}

	public void setUserId(Integer userId){
		this.userId=userId;
	}

	public Integer getUserId(){
		return userId;
	}

	public void setAddress(String address){
		this.address=address;
	}

	public String getAddress(){
		return address;
	}

	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}

	public Date getCreateTime(){
		return createTime;
	}

	public void setIsDefault(Integer isDefault){
		this.isDefault=isDefault;
	}

	public Integer getIsDefault(){
		return isDefault;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}

	public String getRemark(){
		return remark;
	}
}

