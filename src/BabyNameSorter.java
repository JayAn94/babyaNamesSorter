import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
 * This program will sort babyname.txt into
 * male.txt and female.txt using the BufferReader, BufferWriter, File, and File Writer methods
 * 
 * FILE MUST BE PLACED OUTSIDE OF SRC
 */


public class BabyNameSorter {
	
	public static void main(String[] args) throws IOException {		
		
		BufferedReader bReader = null;
		File males = null;
		File females= null;
		BufferedWriter malesBWriter = null;
		BufferedWriter femalesBWriter = null;
		FileWriter malesWriter = null;
		FileWriter femalesWriter = null;
		String line;
		
		try {
		
		bReader = new BufferedReader(new FileReader("babynames.txt"));	
				 
		males = new File("males");
		females = new File("females");
		
		malesWriter = new FileWriter(males);
		femalesWriter = new FileWriter(females);
		
		malesBWriter = new BufferedWriter(malesWriter);	
		femalesBWriter = new BufferedWriter(femalesWriter);		
		
		while((line = bReader.readLine()) != null) {				
			String[] columns = line.split(" ");
			malesBWriter.write(columns[2]);
			malesBWriter.newLine();
			femalesBWriter.write(columns[8]);
			femalesBWriter.newLine();
			}		
		} catch (IOException ex) {
			System.out.println("File IO Error");
			ex.printStackTrace();			
		} finally {
			try {
				femalesBWriter.close();
				System.out.println("Females Buffer Writer Closed.");
				malesBWriter.close();
				System.out.println("Males Buffer Writer Closed.");
				bReader.close();
				System.out.println("Buffer Reader Closed.");
			} catch (IOException ex) {
				System.out.println("Reader did not close.");
				ex.printStackTrace();
			}			
		}
	}	
}
