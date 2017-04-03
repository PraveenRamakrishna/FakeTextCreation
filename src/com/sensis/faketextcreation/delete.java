package com.sensis.faketextcreation;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.UUID;

public class delete {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
	
		PrintWriter printWriter = new PrintWriter("C:/Users/hk824910/Desktop/unique.txt");
		for(int i=0; i<2000000; i++)
		{
		String unique = UUID.randomUUID().toString().replaceAll("-", " ");
		printWriter.println(unique);
		}

	}

}
