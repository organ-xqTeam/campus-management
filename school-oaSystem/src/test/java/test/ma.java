package test;

import java.util.regex.Pattern;

public class ma {
	public static final String PW_PATTERN = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";

	public static void main(String args[]){
	      String content = "I am noob ";
	 
	      boolean isMatch = Pattern.matches(PW_PATTERN, content);
	      System.out.println(isMatch);
	      
	      System.out.println(content.matches(PW_PATTERN));
	   }

}
