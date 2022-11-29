
/**
*@author Chris Duong
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MorseCodeConverter {
	
	public static MorseCodeTree treeMorse = new MorseCodeTree();
	
	public static String convertToEnglish(String string) {
		
		String[] array = string.split(" ");
		String code = "";
		
		for(String t : array){
			
			if(t.equals("/")){
				
				code += " ";
				
			}
	
			else {
				
				code += treeMorse.fetch(t);
			}
		}
		
		return code; 
    }

    public static Object printTree() {
    	
		ArrayList<String> treeList = treeMorse.toArrayList();
		
		String printTree = "";
		
			for(String s : treeList) {
			
				printTree += s + " ";
			
		}
		
		return printTree.substring(0, printTree.length() - 1);
	}
  
//    protected static String convertToEnglish(String code) {
//    	
//		String words[] = code.split("/");
//		String output = "";
//		String letters[];
//		
//			for (int i = 0; i < words.length; i++) {
//				
//			words[i] = words[i].trim();
//			letters = words[i].split(" ");
//				for (int j = 0; j < letters.length; j++) {
//					
//				output+=treeMorse.fetch(letters[j]);
//			}
//				
//			output += " ";
//
//		}
//
//		return output.trim();
//	}
   
    public static String convertToEnglish(File codeFile) throws FileNotFoundException{
    	
    	String code = "";
		Scanner scan = new Scanner(codeFile);
		String[] array = scan.nextLine().split(" ");
		
		for(String s : array){
			
			if(s.equals("/")){
				code += " ";
				
			}
		
				else {
				
					code += treeMorse.fetch(s);
				}
		}
		
		return code;
	}

}