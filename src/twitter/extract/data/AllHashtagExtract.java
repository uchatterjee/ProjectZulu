package twitter.extract.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AllHashtagExtract {

	public static void main(String[] args) throws FileNotFoundException {
		Set<String> set = new HashSet<String>();
		Scanner reader = new Scanner(new FileInputStream("/Users/utsavchatterjee/Documents/New Java Workspace/ProjectZulu/TwitterExtractData/MacBook.txt"));
		PrintStream out = new PrintStream(new FileOutputStream("/Users/utsavchatterjee/Documents/New Java Workspace/ProjectZulu/TwitterDataHashTags/MacBook.txt"));
    	System.setOut(out);
		while (reader.hasNext()){
			String token = reader.next();
			if (token.toString().matches("#(.*)") && !(token.toString().matches("(.*),(.*)")) || !(token.toString().matches("(.*\\.*)")) )
				set.add(token);
			
			  
			}
		Iterator iterator = set.iterator();  
        
		while (iterator.hasNext()){  
	        Object val = iterator.next();  
	        System.out.println(val);

	}
	}
}
