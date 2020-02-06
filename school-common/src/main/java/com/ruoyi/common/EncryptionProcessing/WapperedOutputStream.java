package com.ruoyi.common.EncryptionProcessing;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/** 内部类，对ServletOutputStream进行包装 */
public  class WapperedOutputStream extends ServletOutputStream {
	private ByteArrayOutputStream bos = null;

	public WapperedOutputStream(ByteArrayOutputStream stream) throws IOException {
		bos = stream;
	}

	@Override
	public void write(int b) throws IOException {
		bos.write(b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		bos.write(b, 0, b.length);
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWriteListener(WriteListener writeListener) {
		// TODO Auto-generated method stub
		
	}
}