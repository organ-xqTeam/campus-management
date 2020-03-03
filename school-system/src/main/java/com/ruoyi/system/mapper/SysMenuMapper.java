package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.system.domain.SysMenu;

/**
 * 菜单表 数据层
 * 
 * @author ruoyi
 */
public interface SysMenuMapper
{
    /**
     * 查询系统所有菜单（含按钮）
     * 
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuAll();

    /**
     * 根据用户ID查询菜单
     * 
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuAllByUserId(Long userId);

    /**
     * 查询系统正常显示菜单（不含按钮）
     * 
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuNormalAll();

    /**
     * 根据用户ID查询菜单
     * 
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenusByUserId(Long userId);

    /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<String> selectPermsByUserId(Long userId);

    /**
     * 根据角色ID查询菜单
     * 
     * @param roleId 角色ID
     * @return 菜单列表
     */
    public List<String> selectMenuTree(Long roleId);

    /**
     * 查询系统菜单列表
     * 
     * @param menu 菜单信息
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuList(SysMenu menu);

    /**
     * 查询系统菜单列表
     * 
     * @param menu 菜单信息
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuListByUserId(SysMenu menu);

    /**
     * 删除菜单管理信息
     * 
     * @param menuId 菜单ID
     * @return 结果
     */
    public int deleteMenuById(Long menuId);

    /**
     * 根据菜单ID查询信息
     * 
     * @param menuId 菜单ID
     * @return 菜单信息
     */
    public SysMenu selectMenuById(Long menuId);

    /**
     * 查询菜单数量
     * 
     * @param parentId 菜单父ID
     * @return 结果
     */
    public int selectCountMenuByParentId(Long parentId);

    /**
     * 新增菜单信息
     * 
     * @param menu 菜单信息
     * @return 结果
     */
    public int insertMenu(SysMenu menu);

    /**
     * 修改菜单信息
     * 
     * @param menu 菜单信息
     * @return 结果
     */
    public int updateMenu(SysMenu menu);

    /**
     * 校验菜单名称是否唯一
     * 
     * @param menuName 菜单名称
     * @param parentId 父菜单ID
     * @return 结果
     */
    public SysMenu checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") Long parentId);

	//本年度正在审核的招生数量
	public Integer count1();
	//本年度审核通过的招生数量
	public Integer count2();
	//往年招生通过的数量
	public Integer count3();
	//招生总数
	public Integer count4();
	//空余宿舍数量，点击可进入
	public Integer count5();
	//教室总量，可用数量，不可用数量
	public Integer count6();
	public Integer count10();
	public Integer count11();
	//资产总量
	public Integer count7();
	//设备报修单数量，未解决数量
	public Integer count8();
	public Integer count12();
	//累计举行会议数量
	public Integer count9();
	
	public Integer count13();
	public Integer count14();
	public Integer count15();
	public Integer count16();
	public Integer count17();
	public Integer count18();
	public Integer count19();
	public Integer count20();
	public Integer count21();
	public Integer count22();
	public Integer count23();
	public Integer count24();
	public Integer count25();
	public List<Map<String, Object>> count26();
}
