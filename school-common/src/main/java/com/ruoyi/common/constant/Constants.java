package com.ruoyi.common.constant;

/**
 * 通用常量信息
 * 
 * @author ruoyi
 */
public class Constants
{
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";
    
    /**
     * 图片水印开关 -- 开启
     */
    public static final String WATERMARK_SWITCH_ON = "1";
    /**
     * 图片水印开关 -- 关闭
     */
    public static final String WATERMARK_SWITCH_OFF = "0";

    /**
     * 图片水印位置 -- 左上
     */
    public static final int WATERMARK_POSITION_TOP_LEFT = 1;
    /**
     * 图片水印位置 -- 右上
     */
    public static final int WATERMARK_POSITION_TOP_RIGHT = 2;
    /**
     * 图片水印位置 -- 左下
     */
    public static final int WATERMARK_POSITION_BOTTOM_LEFT = 3;
    /**
     * 图片水印位置 -- 右下(默认)
     */
    public static final int WATERMARK_POSITION_BOTTOM_RIGHT = 4;
    /**
     * 图片水印位置 -- 居中
     */
    public static final int WATERMARK_POSITION_CENTER = 5;

}
