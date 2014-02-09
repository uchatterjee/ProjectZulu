package twitter.extract.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FilterHashtag {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner reader = new Scanner(new FileInputStream("//Users/utsavchatterjee/Documents/New Java Workspace/ProjectZulu/TwitterDataHashtags/iPod.txt"));
		PrintStream out = new PrintStream(new FileOutputStream("//Users/utsavchatterjee/Documents/New Java Workspace/ProjectZulu/FilteredHashtags/iPod.txt"));
    	System.setOut(out);
    	
    	while (reader.hasNext()){
			String token = reader.next();
			if (token.toString().matches("(.*)iPod(.*)"))
				System.out.println(token.toString());
			
			  
			}
	}

}
