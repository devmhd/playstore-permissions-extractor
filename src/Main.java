import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;





public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		G.init();
		
		//list all categories;
		
		ArrayList<String> categories = new ArrayList<String>();
		
		
		
		Process proc = null;
		try {
			proc = Runtime.getRuntime().exec("java -jar googleplay.jar --conf crawler.conf permissions com.facebook.katana");
			
			
			
			BufferedReader reader = new BufferedReader (new InputStreamReader(proc.getInputStream()));
			
			String line;
			while ((line = reader.readLine ()) != null) {
			    System.out.println (line);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
