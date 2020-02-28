package com.ruoyi.common.core.controller;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.AjaxResult.Type;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.exception.ResultException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.FtpUtils;
import com.ruoyi.common.utils.ImageUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.sql.SqlUtil;

/**
 * web层通用数据处理
 * 
 * @author ruoyi
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    
    @Value("${ftp.address}")
    private String ftpAddress;
    @Value("${ftp.port}")
    private int ftpPort;
    @Value("${ftp.userName}")
    private String ftpUserName;
    @Value("${ftp.password}")
    private String ftpPassword;

    private final String DEFAULT_BLOB_IMAGE_SUFFIX = ".jpg";
    
    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
        {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 获取request
     */
    public HttpServletRequest getRequest()
    {
        return ServletUtils.getRequest();
    }

    /**
     * 获取response
     */
    public HttpServletResponse getResponse()
    {
        return ServletUtils.getResponse();
    }

    /**
     * 获取session
     */
    public HttpSession getSession()
    {
        return getRequest().getSession();
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? success() : error();
    }

    /**
     * 响应返回结果
     * 
     * @param result 结果
     * @return 操作结果
     */
    protected AjaxResult toAjax(boolean result)
    {
        return result ? success() : error();
    }

    /**
     * 返回成功
     */
    public AjaxResult success()
    {
        return AjaxResult.success();
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }

    /**
     * 返回成功消息
     */
    public AjaxResult success(String message)
    {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }

    /**
     * 返回错误码消息
     */
    public AjaxResult error(Type type, String message)
    {
        return new AjaxResult(type, message);
    }

    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }
    
    /**
     * Blob图片上传至FTP服务器，上传之前对图片进行重命名，并添加后缀名
     * @param file     上传的文件
     * @param targetPath 目标路径
     * @return 文件所在服务器的完整目录，如/userfile/bus100/20141024/20141024155312804.JPG
     */
    protected String uploadBlobImageToFTP(MultipartFile file, String targetPath) throws ResultException {
        if (file == null || file.getSize() == 0) {
            return null;
        }

        // 设置上传文件名
        String fileName = FileUploadUtils.encodingFilename(file.getOriginalFilename() + DEFAULT_BLOB_IMAGE_SUFFIX);
        FtpUtils ftp = null;
        try {
            //将上传的图片文件临时保存到服务器的临时目录中
            String outputDirectory = System.getProperty("java.io.tmpdir") + "/uploadFile/";
            File tempFileDir = new File(outputDirectory);
            if (!tempFileDir.exists()) {
                if (!tempFileDir.mkdir()) {//生成临时目录
                    return null;
                }
            }
            File tempFile = new File(outputDirectory + fileName);
            if (!tempFile.createNewFile()) {//生成临时文件
                return null;
            }
            file.transferTo(tempFile);

            ftp = new FtpUtils(ftpAddress, ftpPort, ftpUserName, ftpPassword);
            ftp.ftpLogin();
            //上传文件
            targetPath += DateUtils.dateTime() + "/";
            if (!ftp.uploadFile(tempFile, targetPath)) {
                throw new ResultException("文件上传失败");
            }

            //最后删除临时文件
            try {
                tempFile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return targetPath + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResultException("网络异常，文件上传失败");
        } finally {
            if (ftp != null) {
                try {
                    ftp.ftpLogOut();
                } catch (Exception e) {

                }
            }
        }
    }

    /**
     * 文件上传至FTP服务器，上传后文件名重命名
     * @param file     上传的文件
     * @return 文件所在服务器的完整目录，如/userfile/bus100/20141024/20141024155312804.JPG
     */
    protected String uploadFileToFTP(MultipartFile file, String targetPath) {
        if (file == null || file.getSize() == 0) {
            return null;
        }
        
        String oldname  =  file.getOriginalFilename();
        
        String suffixImg = oldname.substring(oldname.lastIndexOf("."), oldname.length());
        // 设置上传文件名
        String fileName = FileUploadUtils.encodingFilename(oldname)+suffixImg;
        System.out.println("设置上传文件名:"+fileName);
        FtpUtils ftp = null;
        try {
            //将上传的图片文件临时保存到服务器的临时目录中
            String outputDirectory = System.getProperty("java.io.tmpdir") + "/uploadFile/";
            File tempFileDir = new File(outputDirectory);
            if (!tempFileDir.exists()) {
                if (!tempFileDir.mkdir()) {//生成临时目录
                    return null;
                }
            }
            File tempFile = new File(outputDirectory + fileName);
            if (!tempFile.createNewFile()) {//生成临时文件
                return null;
            }
            file.transferTo(tempFile);

            ftp = new FtpUtils(ftpAddress, ftpPort, ftpUserName, ftpPassword);
            ftp.ftpLogin();
            //上传文件
            targetPath += DateUtils.dateTime() + "/";
            if (!ftp.uploadFile(tempFile, targetPath)) {
                throw new ResultException("文件上传失败");
            }

            //最后删除临时文件
            try {
                tempFile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return targetPath + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResultException("网络异常，文件上传失败");
        } finally {
            if (ftp != null) {
                try {
                    ftp.ftpLogOut();
                } catch (Exception e) {

                }
            }
        }

    }


    /**
     * 图片上传至FTP服务器，上传之前对图片进行压缩处理，上传后文件名重命名
     * @param file     上传的文件
     * @param targetPath 目标路径
     * @return 文件所在服务器的完整目录，如/userfile/bus100/20141024/20141024155312804.JPG
     */
    protected String uploadImageToFTPComp(MultipartFile file, String targetPath) throws ResultException {
        //默认压缩到200KB大小
        return uploadImageToFTPComp(file, targetPath, 200);
    }

    /**
     * 图片上传至FTP服务器，上传之前对图片进行压缩处理，上传后文件名重命名
     * @param file     上传的文件
     * @param targetPath 目标路径
     * @param compKB 压缩的大小
     * @return 文件所在服务器的完整目录，如/userfile/bus100/20141024/20141024155312804.JPG
     */
    protected String uploadImageToFTPComp(MultipartFile file, String targetPath, int compKB) throws ResultException {
        if (file == null || file.getSize() == 0) {
            return null;
        }

        //判断文件名是否合法
        //获取后缀名
        String originalName = file.getOriginalFilename();
        String suffix = originalName.substring(originalName.lastIndexOf(".") + 1);
        if (!"jpg".equalsIgnoreCase(suffix) && !"jpeg".equalsIgnoreCase(suffix) && !"png".equalsIgnoreCase(suffix)
                && !"gif".equalsIgnoreCase(suffix)&& !"jfif".equalsIgnoreCase(suffix)) {
            throw new ResultException("图片格式不正确");
        }

        // 设置上传文件名
        String fileName = FileUploadUtils.encodingFilename(file.getOriginalFilename());
        FtpUtils ftp = null;
        try {
            //将上传的图片文件临时保存到服务器的临时目录中
            String outputDirectory = System.getProperty("java.io.tmpdir") + "/uploadFile/";
            File tempFileDir = new File(outputDirectory);
            if (!tempFileDir.exists()) {
                if (!tempFileDir.mkdir()) {//生成临时目录
                    return null;
                }
            }
            File tempFile = new File(outputDirectory + fileName);
            if (!tempFile.createNewFile()) {//生成临时文件
                return null;
            }
            file.transferTo(tempFile);


            if (("jpg".equalsIgnoreCase(suffix) || "jpeg".equalsIgnoreCase(suffix) || "png".equalsIgnoreCase(suffix))
                    && compKB > 0 && file.getSize() > compKB * 1024) {
                //压缩
                String compFileName = "thumb_" + fileName;
                compFileName = compFileName.toLowerCase();
                if (fileName.contains(".png")) {
                    compFileName = compFileName.replace(".png", ".jpg");
                }
                FileUploadUtils.cycleCompress(outputDirectory + fileName, outputDirectory + compFileName, 1f, compKB * 1024);
                //删除临时文件
                try {
                    tempFile.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                fileName = compFileName;
                tempFile = new File(outputDirectory + compFileName);
            }

            //打水印
            if (Constants.WATERMARK_SWITCH_ON.equals(Global.getConfig("watermark.switch"))) {
                String nowTime = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", new Date());
                ImageUtils.pressText(outputDirectory + fileName, nowTime, Constants.WATERMARK_POSITION_BOTTOM_RIGHT, 1f);
            }

            ftp = new FtpUtils(ftpAddress, ftpPort, ftpUserName, ftpPassword);
            ftp.ftpLogin();
            //上传文件
            targetPath += DateUtils.dateTime() + "/";
            if (!ftp.uploadFile(tempFile, targetPath)) {
                throw new ResultException("文件上传失败");
            }


            //最后删除临时文件
            try {
                tempFile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return targetPath + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResultException("网络异常，文件上传失败");
        } finally {
            if (ftp != null) {
                try {
                    ftp.ftpLogOut();
                } catch (Exception e) {

                }
            }
        }
    }
    
}
