/**
 * 
 */
package in.krishna.common;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Krishna
 *
 */
public class DataTable {
	
	public HashMap<String, String> readFile(){
		
		HashMap<String, String> data=new HashMap<String, String>();
		
	try {
		
		Scanner in =new Scanner(new File("./src/main/resources/config.property"));
	String line;
	while(in.hasNextLine())
	{
		line=in.nextLine();
		String[] keyvalue=line.split("=");
		data.put(keyvalue[0], keyvalue[1]);	
	}
	
in.close();	

		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	
}
