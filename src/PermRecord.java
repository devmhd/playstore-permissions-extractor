import java.io.Serializable;


public class PermRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String appName;
	public String pkgName;
	public boolean[] permissions;
	
	public PermRecord(String appName, String pkgName) {
		this.appName = appName;
		this.pkgName = pkgName;
		
		permissions = new boolean[G.permStrings.size()];
	}
	
	
	public void addPermission(String permission){
		
		
		if(G.allPermissionMap.containsKey(permission)){
			permissions[G.allPermissionMap.get(permission)] = true;
		}else{
			
			System.out.println("Unlisted permission ("+ pkgName+") : " + permission);
		}
		
		
	}
	
	
	
	
	

}
