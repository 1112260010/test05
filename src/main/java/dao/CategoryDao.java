package dao;

import pojo.Category;

import java.util.List;

public interface CategoryDao {
    //自关联  1：N     通过父类id查询该分类包括所有子分类
    public List<Category> selectCategoryByParentId(Integer pid);

    //自关联   N：1     通过id查询该分类包括所有父分类
    public List<Category> selectCategoryById(Integer id);
}
