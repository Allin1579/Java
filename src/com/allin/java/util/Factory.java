package com.allin.java.util;
/**
 * 数据工厂
 * @author Allin
 */
public class Factory {

	/**
	 * 创建长度为length的int数组
	 * @param length
	 * @return int[]
	 */
	public static int[] createArray(int length){
		int[] s = new int[length];
		for (int i = 0; i < length; i++) {
			s[i] = createInt();
		}
		return s;
	}
	
	/**
	 * 创建0到100的随机数，强转为int
	 * @return int
	 */
	private static int createInt(){
		int i = (int) (Math.random() * 100);
		return i;
	}
	
}
