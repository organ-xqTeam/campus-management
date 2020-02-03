package com.ruoyi.project.system.examSubjectCategory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.examSubjectCategory.domain.ExamSubjectCategory;
import com.ruoyi.project.system.examSubjectCategory.mapper.ExamSubjectCategoryMapper;

/**
 * 题目分类 服务层实现
 * 
 * @author ruoyi
 * @date 2019-08-08
 */
@Service
public class ExamSubjectCategoryServiceImpl implements IExamSubjectCategoryService 
{
	@Autowired
	private ExamSubjectCategoryMapper examSubjectCategoryMapper;

	/**
     * 查询题目分类信息
     * 
     * @param id 题目分类ID
     * @return 题目分类信息
     */
    @Override
	public ExamSubjectCategory selectExamSubjectCategoryById(String id)
	{
	    return examSubjectCategoryMapper.selectExamSubjectCategoryById(id);
	}
	
	/**
     * 查询题目分类列表
     * 
     * @param examSubjectCategory 题目分类信息
     * @return 题目分类集合
     */
	@Override
	public List<ExamSubjectCategory> selectExamSubjectCategoryList(ExamSubjectCategory examSubjectCategory)
	{
	    return examSubjectCategoryMapper.selectExamSubjectCategoryList(examSubjectCategory);
	}
	
    /**
     * 新增题目分类
     * 
     * @param examSubjectCategory 题目分类信息
     * @return 结果
     */
	@Override
	public int insertExamSubjectCategory(ExamSubjectCategory examSubjectCategory)
	{
	    return examSubjectCategoryMapper.insertExamSubjectCategory(examSubjectCategory);
	}
	
	/**
     * 修改题目分类
     * 
     * @param examSubjectCategory 题目分类信息
     * @return 结果
     */
	@Override
	public int updateExamSubjectCategory(ExamSubjectCategory examSubjectCategory)
	{
	    return examSubjectCategoryMapper.updateExamSubjectCategory(examSubjectCategory);
	}

	/**
     * 删除题目分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteExamSubjectCategoryByIds(String ids)
	{
		return examSubjectCategoryMapper.deleteExamSubjectCategoryByIds(Convert.toStrArray(ids));
	}

	@Override
	public ExamSubjectCategory selectMenuById(Long menuId) {
		 return examSubjectCategoryMapper.selectMenuById(menuId+"");
	}

	@Override
	public List<Ztree> menuTreeData() {
		 List<ExamSubjectCategory> menuList = selectMenuAll();
	        List<Ztree> ztrees = initZtree(menuList);
	        return ztrees;
	}
	@Override
	public List<Ztree> menuTreeData1(String parentId) {
		mList = new ArrayList<ExamSubjectCategory>();
		ExamSubjectCategory ex = examSubjectCategoryMapper.selectExamSubjectCategoryById(parentId);
		mList.add(ex);
		mList.addAll(selectChildren(parentId));
		List<Ztree> ztrees = initZtree(mList);
		return ztrees;
	}
	private List<ExamSubjectCategory>  mList = null;
	public List<ExamSubjectCategory> selectChildren(String parentId){
		ExamSubjectCategory es = new ExamSubjectCategory();
		es.setParentId(parentId);
		List<ExamSubjectCategory> menuList = selectExamSubjectCategoryList(es);
		for (ExamSubjectCategory examSubjectCategory : menuList) {
			mList.addAll(selectChildren(examSubjectCategory.getId()));
		}
		return menuList;
	}
	
	
	@Override
    public List<ExamSubjectCategory> selectMenuAll()
    {
        List<ExamSubjectCategory> menuList = null;
        menuList = examSubjectCategoryMapper.selectMenuAll();
        
        return menuList;
    }
	 /**
     * 对象转菜单树
     * 
     * @param menuList 菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<ExamSubjectCategory> menuList)
    {
        return initZtree(menuList, null, false);
    }
    public List<Ztree> initZtree(List<ExamSubjectCategory> menuList, List<String> roleMenuList, boolean permsFlag)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleMenuList);
        for (ExamSubjectCategory menu : menuList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(Long.valueOf(menu.getId()));
            ztree.setpId(Long.valueOf(menu.getParentId()));
            ztree.setName(transMenuName(menu, roleMenuList, permsFlag));
            ztree.setTitle(menu.getCategoryName());
            if (isCheck)
            {
                ztree.setChecked(roleMenuList.contains(menu.getId()));
            }
            ztrees.add(ztree);
        }
        return ztrees;
    }
    public String transMenuName(ExamSubjectCategory menu, List<String> roleMenuList, boolean permsFlag)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(menu.getCategoryName());
        if (permsFlag)
        {
            sb.append("<font color=\"#888\"></font>");
        }
        return sb.toString();
    }
}
