package com.ruoyi.common.EncryptionProcessing;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class WrapperedResponse extends HttpServletResponseWrapper {

	private ByteArrayOutputStream buffer = null;
	private ServletOutputStream out = null;
	private PrintWriter writer = null;
	private CharArrayWriter bufferedWriter;

	public WrapperedResponse(HttpServletResponse resp) throws IOException {
		super(resp);
		buffer = new ByteArrayOutputStream();// 真正存储数据的流
		out = new WapperedOutputStream(buffer);
		writer = new PrintWriter(new OutputStreamWriter(buffer, this.getCharacterEncoding()));
	}

	/** 重载父类获取outputstream的方法 */
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return out;
	}

	/** 重载父类获取writer的方法 */
	@Override
	public PrintWriter getWriter() throws UnsupportedEncodingException {
		return writer;
	}

	/** 重载父类获取flushBuffer的方法 */
	@Override
	public void flushBuffer() throws IOException {
		if (out != null) {
			out.flush();
		}
		if (writer != null) {
			writer.flush();
		}
	}

	@Override
	public void reset() {
		buffer.reset();
	}

	/** 将out、writer中的数据强制输出到WapperedResponse的buffer里面，否则取不到数据 */
	public byte[] getResponseData() throws IOException {
		flushBuffer();
		return buffer.toByteArray();
	}

	public String getResult() {
		byte[] bytes = bufferedWriter.toString().getBytes();
		try {
			return new String(bytes, "UTF-8");
		} catch (Exception e) {
			return "";
		}
	}
}