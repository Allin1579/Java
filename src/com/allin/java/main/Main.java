package com.allin.java.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.allin.java.annotation.TestAnno;

/**
 * Main
 * @author Allin
 */
public class Main {
	
	public static void main(String[] args) {
//		//创建无序数组
//		int[] s = Factory.createArray(10000);
//		//排序
//		long start = System.currentTimeMillis();
//		Sort.sort(s);
//		long end = System.currentTimeMillis();
//		System.out.println(String.format("排序耗时%sms", String.valueOf(end - start)));
//		//检查排序是否正确
//		Sort.isOrder(s);
		
//		String path = "C:\\Users\\a\\Desktop\\chanel.txt";
//		ChanelUtil.getChanels(path);
		
//		new Some().stc();
		
		new TestAnno().testFun();
		
		
	}
	
}
