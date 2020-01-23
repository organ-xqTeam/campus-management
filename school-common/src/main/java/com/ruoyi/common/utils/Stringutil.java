package com.ruoyi.common.utils;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Stringutil {
	private static AtomicInteger counter = new AtomicInteger(0);

	private static long incrementAndGet() {
		return counter.incrementAndGet();
	}

	public static long getLongUID() {
		if (counter.get() > 999) {
			counter.set(1);
		}
		long time = System.currentTimeMillis();
		return time * 1000 + incrementAndGet();
	}

	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] retArray = new String[number];
		for (int i = 0; i < number; i++) {
			retArray[i] = getUUID();
		}
		return retArray;
	}

	/**
	 * 获得一个UUID
	 * 
	 * @return String UUID
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		// 去掉“-”符号
		return uuid.replaceAll("-", "");
	}
}

