package com.ym.common.utils;

import java.util.Random;

/**
 * 验证码随机数
 */
public final class RandomUtils {

	public static String random(int n) {
		if (n < 1 || n > 10) {
			throw new IllegalArgumentException("cannot random " + n + " bit number");
		}
		Random ran = new Random();
		if (n == 1) {
			return String.valueOf(ran.nextInt(10));
		}
		int bitField = 0;
		char[] chs = new char[n];
		for (int i = 0; i < n; i++) {
			while (true) {
				int k = ran.nextInt(10);
				if ((bitField & (1 << k)) == 0) {
					bitField |= 1 << k;
					chs[i] = (char) (k + '0');
					break;
				}
			}
		}
		return new String(chs);
	}
}
