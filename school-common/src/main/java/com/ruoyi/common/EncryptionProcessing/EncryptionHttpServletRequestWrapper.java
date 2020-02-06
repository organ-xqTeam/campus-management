package com.ruoyi.common.EncryptionProcessing;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 
 * 
 * @author ruoyi
 */
public class EncryptionHttpServletRequestWrapper extends HttpServletRequestWrapper
{
	private byte[] body;
	public EncryptionHttpServletRequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
		//StreamUtil.readBytes(servletRequest.getReader(), "utf-8");
        //由于request并没有提供现成的获取json字符串的方法，所以我们需要将body中的流转为字符串
        String json = HttpGetBody.getBodyString(servletRequest); 
        System.out.println("1");
        System.out.println(json);
        body = getData(Encryption.dncryptRSA(json)).getBytes();
	}
	@Override
	public String[] getParameterValues(String parameter) {
		System.out.println("2");
		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}
		int count = values.length;
		String[] encodedValues = new String[count];
		return encodedValues;
	}
	@Override
	public BufferedReader getReader() throws IOException {
		  String enc = getCharacterEncoding();
	        if(enc == null) enc = "UTF-8";
	        return new BufferedReader(new InputStreamReader(getInputStream()));
	} 
	private String getData(String json){
        return json;
    }
	
	@Override
    public ServletInputStream getInputStream() throws IOException {

        final ByteArrayInputStream bais = new ByteArrayInputStream(body);

        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return bais.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        };
    }
 





}