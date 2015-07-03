import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;




public class Main {

	
	

	public static ArrayList<String> getOutput(String command){
	
	Process proc = null;
	ArrayList<String> output = new ArrayList<String>();
	try {
		
		
// 		
		proc = Runtime.getRuntime().exec(command);
		
		
		
		BufferedReader reader = new BufferedReader (new InputStreamReader(proc.getInputStream()));
		
		
		
		String line;
		while ((line = reader.readLine ()) != null) {
		    //System.out.println (line);
			output.add(line.trim());
		}
		

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return output;
	
}
	
	
	public static ArrayList<String> getAllCategories(){
		
		ArrayList<String> categoriesOutput = new ArrayList<String>();
		
		for(String str : getOutput("java -jar googleplay.jar --conf crawler.conf categories")){
			categoriesOutput.add( str.split(";")[0] );
			
		}
		
		categoriesOutput.remove(0);
		
		return categoriesOutput;
		
	}
	
	
	
	public static void main(String[] args) {
		
		G.init();
		
		
		StringBuilder mainOutput = new StringBuilder();
		int appCount = 0;
		
		
		// header
		mainOutput.append("App name,Package name");
		
		for(String p : G.permStrings){
			mainOutput.append(","+p);
		}
		
		mainOutput.append('\n');
		
		
		//list all categories;
		ArrayList<String> categories = getAllCategories();
		String[] parts;
		
		ArrayList<PermRecord> permRecords = new ArrayList<PermRecord>();
		ArrayList<String> permissions;
		
		for(String category : categories){
			
			String command = "java -jar googleplay.jar --conf crawler.conf list -s apps_topselling_free -n " + G.NO_OF_APP_PER_CATEGORY + " " + category;
			
			ArrayList<String> output = getOutput(command);
			output.remove(0);
			
			// for each app
			for(String str : output){
				parts = str.split(";");
				
				PermRecord permRecord = new PermRecord(parts[0], parts[1]);
				mainOutput.append(parts[0]+","+parts[1]);
				
				permissions = getOutput("java -jar googleplay.jar --conf crawler.conf permissions " + parts[1]);
				
				permissions.remove(0);
				
				// each permission
				for(String perm : permissions){
					permRecord.addPermission(perm.replace("android.permission.", ""));
					
				}
				
				for(boolean isP : permRecord.permissions){
					if(isP) mainOutput.append(",1");
					else mainOutput.append(",0");
				}
				
				mainOutput.append('\n');
				System.out.println("Processed: " + (++appCount));
				
				
				//permRecords.add(new PermRecord(appName, pkgName))
				
			}
			
			PrintWriter writer;
			try {
				writer = new PrintWriter("perms_" + category + ".csv", "UTF-8");
				writer.print(mainOutput.toString());
				writer.close();
				
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		
		
		

	}

}
