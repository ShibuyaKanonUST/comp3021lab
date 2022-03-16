package base;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class TextNote extends Note implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Data Member
	String content;
		
	// Member Function
	public TextNote(String title) {
		super(title);
		
		
	}
	
	public TextNote(File f) {
		
		super(f.getName());
		this.content = getTextFromFile(f.getAbsolutePath());
		
	}
	
	public TextNote(String title, String content) {
		super(title);
		this.content = content;
	}
	
	private String getTextFromFile(String absolutePath) {
		String result = "";
		String line = "";
		
		
		try {
			File filename = new File(absolutePath);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
			BufferedReader br = new BufferedReader(reader);
			line = br.readLine();
		}
		catch (Exception e){
			System.out.println("Error1");
		}
		
		
		return result;
	}
	
	public void exportTextToFile(String pathFolder) throws Exception{
		try {
			
			if (pathFolder.equals(""))
			{
				pathFolder = ".";
			}
			FileWriter writer = new FileWriter(new File(pathFolder + File.separator + (this.getTitle()).replaceAll(" ", "_")+".txt"));
			BufferedWriter bw = new BufferedWriter(writer);
	
			     
			bw.write(this.content);
		    bw.close();
				
		}
		catch (Exception e) {
			
			System.out.println(e);
		}
		
	}
	
	
}
