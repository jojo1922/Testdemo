package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NotepadUtility {

	public String path;
	public static String s = "";
	public static String   ReadNotepad(String path) throws FileNotFoundException {

		System.out.println(path);
		File file = new File(path);
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			s = sc.nextLine();
		}
		// System.out.println(s);
		return s;
	}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

