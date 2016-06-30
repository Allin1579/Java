package com.allin.java.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ChanelUtil {
	
	public static void getChanels(String path){
		File file = new File(path);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			String targ = null;
			System.out.println("begin read!");
			while((tempString = reader.readLine()) != null){
				targ = String.format("<release-channel channel=\"%s\" />", tempString);
				System.out.println(targ);
			}
			System.out.println("end read!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
