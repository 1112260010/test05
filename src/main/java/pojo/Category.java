package pojo;

import java.util.List;

/**
    * easybuy_product_category 实体类
    * @author liangzz
    * @date2019-04-08 11:46 
    */ 

public class Category {
	 /**主键**/
	private Integer id;
	 /**名称**/
	private String name;
	 /**父级目录id**/
	private Integer parentId;
	 /**级别(1:一级 2：二级 3：三级)**/
	private Integer type;
	 /**图标**/
	private String iconClass;

	private List<Category> list;

	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", name='" + name + '\'' +
				", parentId=" + parentId +
				", type=" + type +
				", iconClass='" + iconClass + '\'' +
				", list=" + list +
				", category=" + category +
				'}';
	}

	public List<Category> getList() {
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return id;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public void setParentId(Integer parentId){
		this.parentId=parentId;
	}

	public Integer getParentId(){
		return parentId;
	}

	public void setType(Integer type){
		this.type=type;
	}

	public Integer getType(){
		return type;
	}

	public void setIconClass(String iconClass){
		this.iconClass=iconClass;
	}

	public String getIconClass(){
		return iconClass;
	}
}

