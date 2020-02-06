package com.ruoyi.common.EncryptionProcessing;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * <br>类 名: TokenFilter
 * <br>描 述: TODO
 * <br>作 者: lipeng
 * <br>创 建： 2018/9/29 17:32
 * <br>版 本：v1.0.0
 * <br>
 * <br>历 史: (版本) 作者 时间 注释
 */
public class TokenFilter implements Filter {


    public static final String PARAM_NAME_EXCLUSIONS = "exclusions";
    private Set<String> excludesPattern;
    protected String contextPath;

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String param = filterConfig.getInitParameter(PARAM_NAME_EXCLUSIONS);
        if (param != null && param.trim().length() != 0) {
            this.excludesPattern = new HashSet(Arrays.asList(param.split("\\s*,\\s*")));
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;
        TokenFilter.StatHttpServletResponseWrapper responseWrapper = new TokenFilter.StatHttpServletResponseWrapper(httpResponse);
        String requestURI = this.getRequestURI(httpRequest);
//        System.out.println("1=="+requestURI);
//        System.out.println(this.getContextPath());
//        if (this.isExclusion(requestURI)) {
//            //不过滤走
//            System.out.println("===不进过滤器");
//            filterChain.doFilter(servletRequest, servletResponse);
//        }else {
//            //这里是过滤方法
//            System.out.println("===进了过滤器");
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
        if (requestURI.startsWith("/ajax/")) {
//          requestURI.endsWith(".html");
//          System.out.println("1=="+requestURI);
          if (requestURI.endsWith(".js") || requestURI.endsWith(".css")) {
        	  filterChain.doFilter(servletRequest,servletResponse);
          }else {
//        	  System.out.println("1=="+requestURI);
//        	  System.out.println("===进了过滤器");
        	  WrapperedResponse wrapResponse = new WrapperedResponse(
                      (HttpServletResponse) servletResponse);
        	  filterChain.doFilter(new EncryptionHttpServletRequestWrapper(httpRequest),wrapResponse);
        	  
        	  PrintWriter out = servletResponse.getWriter(); 
        	  ///取返回的json串

        	  byte[] data = wrapResponse.getResponseData();
        	  //
              String result = new String(data, "UTF-8");
              System.out.println(result);
              //加密
              String encryptStr = Encryption.encryptRSA(result);
              out.write(encryptStr);
        	  out.flush(); 
        	   
          }
		}else {
		  filterChain.doFilter(servletRequest, servletResponse);
		}
    }

    

	@Override
    public void destroy() {

    }


    public static final class StatHttpServletResponseWrapper extends HttpServletResponseWrapper implements HttpServletResponse {
        private int status = 200;

        public StatHttpServletResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public void setStatus(int statusCode) {
            super.setStatus(statusCode);
            this.status = statusCode;
        }

        public void setStatus(int statusCode, String statusMessage) {
            super.setStatus(statusCode, statusMessage);
            this.status = statusCode;
        }

        @Override
        public void sendError(int statusCode, String statusMessage) throws IOException {
            super.sendError(statusCode, statusMessage);
            this.status = statusCode;
        }

        @Override
        public void sendError(int statusCode) throws IOException {
            super.sendError(statusCode);
            this.status = statusCode;
        }

        @Override
        public int getStatus() {
            return this.status;
        }
    }

    public String getRequestURI(HttpServletRequest request) {
        return request.getRequestURI();
    }
}
