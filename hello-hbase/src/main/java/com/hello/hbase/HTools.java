package com.hello.hbase;

import java.util.Random;

public class HTools {

	Random r = new Random();

	/**
	 * 随机生成测试手机号码 prefix: 手机号码前缀 eq:186
	 * @param prefix
	 * @return
	 */
	public String getPhoneNum(String prefix) {
		return prefix + String.format("%08d", r.nextInt(99999999));
	}

	/**
	 * 随机生成时间
	 * @param year
	 *              年
	 * @return 时间 格式：yyyyMMddHHmmss
	 */

	public String getDate(String year) {
		return year + String.format( "%02d%02d%02d%02d%02d", new Object[] { r.nextInt(12) + 1, r.nextInt(28) + 1, r.nextInt(24), r.nextInt(60), r.nextInt(60) });
	}

}
