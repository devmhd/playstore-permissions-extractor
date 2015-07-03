import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;




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


	public static void runPlayStoreExtractor(){

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
				writer = new PrintWriter("output/perms_" + category + ".csv", "UTF-8");
				writer.print(mainOutput.toString());
				writer.close();

			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

	}


	public static void runFilePermissionsExtractor() throws IOException{

		File folder = new File("samples");
		File[] listOfFolders = folder.listFiles();

		// for every folder
		for (int i = 0; i < listOfFolders.length; i++) {

			File[] malwareFiles = listOfFolders[i].listFiles();

			// for every malware
			for(int j=0; j<malwareFiles.length; ++j){

				System.out.println("Processing: " + listOfFolders[i].getName() + "/" + malwareFiles[j].getName());
				ArrayList<String> output = getOutput("aapt.exe d permissions samples/" + listOfFolders[i].getName() + "/" + malwareFiles[j].getName()); 
				String pkgName = output.get(0).trim().replace("package: ", "");

				output.remove(0);

				PermRecord thisMalware = null;

				if(G.malwarePermRecords.containsKey(pkgName)){
					thisMalware = G.malwarePermRecords.get(pkgName);
				} else {

					thisMalware = new PermRecord("", pkgName);
					G.malwarePermRecords.put(pkgName, thisMalware);

				}

				for(String perm : output){

					thisMalware.addPermission(perm.trim().replace("uses-permission: android.permission.", ""));		

				}
			}


		}

		// output to file
		StringBuilder mainOutput = new StringBuilder();

		// header
		mainOutput.append("App name");

		for(String p : G.permStrings){
			mainOutput.append(","+p);
		}

		mainOutput.append('\n');

		
		int malwareCount = 0;
		
		// all perms
		Iterator it = G.malwarePermRecords.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();

			mainOutput.append(((PermRecord)pair.getValue()).pkgName);
			
			for(boolean isP : ((PermRecord)pair.getValue()).permissions){
				if(isP) mainOutput.append(",1");
				else mainOutput.append(",0");
			}
			mainOutput.append('\n');
			
			System.out.println("Processed: " + (++malwareCount));

//			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}
		
		PrintWriter writer;
		try {
			writer = new PrintWriter("output/malware_perms.csv", "UTF-8");
			writer.print(mainOutput.toString());
			writer.close();

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("***FINISHED***");
	}





	public static void main(String[] args) {

		G.init();


		//	runPlayStoreExtractor();


		try {
			runFilePermissionsExtractor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}








	}

}
