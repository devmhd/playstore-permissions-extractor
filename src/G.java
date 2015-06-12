
import java.util.ArrayList;
import java.util.HashMap;


public class G {

	
	public static HashMap<String, Integer> allPermissionMap;
	
	public static void init() {
		
		allPermissionMap = new HashMap<String, Integer>();
		
		ArrayList<String> permStrings = new ArrayList<String>();
		
		permStrings.add("ACCESS_CHECKIN_PROPERTIES");
		permStrings.add("ACCESS_COARSE_LOCATION");
		permStrings.add("ACCESS_FINE_LOCATION");
		permStrings.add("ACCESS_LOCATION_EXTRA_COMMANDS");
		permStrings.add("ACCESS_MOCK_LOCATION");
		permStrings.add("ACCESS_NETWORK_STATE");
		permStrings.add("ACCESS_SURFACE_FLINGER");
		permStrings.add("ACCESS_WIFI_STATE");
		permStrings.add("ACCOUNT_MANAGER");
		permStrings.add("AUTHENTICATE_ACCOUNTS");
		permStrings.add("BATTERY_STATS");
		permStrings.add("BIND_APPWIDGET");
		permStrings.add("BIND_DEVICE_ADMIN");
		permStrings.add("BIND_INPUT_METHOD");
		permStrings.add("BIND_REMOTEVIEWS");
		permStrings.add("BIND_WALLPAPER");
		permStrings.add("BLUETOOTH");
		permStrings.add("BLUETOOTH_ADMIN");
		permStrings.add("BRICK");
		permStrings.add("BROADCAST_PACKAGE_REMOVED");
		permStrings.add("BROADCAST_SMS");
		permStrings.add("BROADCAST_STICKY");
		permStrings.add("BROADCAST_WAP_PUSH");
		permStrings.add("CALL_PHONE");
		permStrings.add("CALL_PRIVILEGED");
		permStrings.add("CAMERA");
		permStrings.add("CHANGE_COMPONENT_ENABLED_STATE");
		permStrings.add("CHANGE_CONFIGURATION");
		permStrings.add("CHANGE_NETWORK_STATE");
		permStrings.add("CHANGE_WIFI_MULTICAST_STATE");
		permStrings.add("CHANGE_WIFI_STATE");
		permStrings.add("CLEAR_APP_CACHE");
		permStrings.add("CLEAR_APP_USER_DATA");
		permStrings.add("CONTROL_LOCATION_UPDATES");
		permStrings.add("DELETE_CACHE_FILES");
		permStrings.add("DELETE_PACKAGES");
		permStrings.add("DEVICE_POWER");
		permStrings.add("DIAGNOSTIC");
		permStrings.add("DISABLE_KEYGUARD");
		permStrings.add("DUMP");
		permStrings.add("EXPAND_STATUS_BAR");
		permStrings.add("FACTORY_TEST");
		permStrings.add("FLASHLIGHT");
		permStrings.add("FORCE_BACK");
		permStrings.add("GET_ACCOUNTS");
		permStrings.add("GET_PACKAGE_SIZE");
		permStrings.add("GET_TASKS");
		permStrings.add("GLOBAL_SEARCH");
		permStrings.add("HARDWARE_TEST");
		permStrings.add("INJECT_EVENTS");
		permStrings.add("INSTALL_LOCATION_PROVIDER");
		permStrings.add("INSTALL_PACKAGES");
		permStrings.add("INTERNAL_SYSTEM_WINDOW");
		permStrings.add("INTERNET");
		permStrings.add("KILL_BACKGROUND_PROCESSES");
		permStrings.add("MANAGE_ACCOUNTS");
		permStrings.add("MANAGE_APP_TOKENS");
		permStrings.add("MASTER_CLEAR");
		permStrings.add("MODIFY_AUDIO_SETTINGS");
		permStrings.add("MODIFY_PHONE_STATE");
		permStrings.add("MOUNT_FORMAT_FILESYSTEMS");
		permStrings.add("MOUNT_UNMOUNT_FILESYSTEMS");
		permStrings.add("NFC");
		permStrings.add("PROCESS_OUTGOING_CALLS");
		permStrings.add("READ_CALENDAR");
		permStrings.add("READ_CONTACTS");
		permStrings.add("READ_EXTERNAL_STORAGE");
		permStrings.add("READ_FRAME_BUFFER");
		permStrings.add("READ_HISTORY_BOOKMARKS");
		permStrings.add("READ_INPUT_STATE");
		permStrings.add("READ_LOGS");
		permStrings.add("READ_PHONE_STATE");
		permStrings.add("READ_SMS");
		permStrings.add("READ_SYNC_SETTINGS");
		permStrings.add("READ_SYNC_STATS");
		permStrings.add("REBOOT");
		permStrings.add("RECEIVE_BOOT_COMPLETED");
		permStrings.add("RECEIVE_MMS");
		permStrings.add("RECEIVE_SMS");
		permStrings.add("RECEIVE_WAP_PUSH");
		permStrings.add("RECORD_AUDIO");
		permStrings.add("REORDER_TASKS");
		permStrings.add("RESTART_PACKAGES");
		permStrings.add("SEND_SMS");
		permStrings.add("SET_ACTIVITY_WATCHER");
		permStrings.add("SET_ALARM");
		permStrings.add("SET_ALWAYS_FINISH");
		permStrings.add("SET_ANIMATION_SCALE");
		permStrings.add("SET_DEBUG_APP");
		permStrings.add("SET_ORIENTATION");
		permStrings.add("SET_POINTER_SPEED");
		permStrings.add("SET_PROCESS_LIMIT");
		permStrings.add("SET_TIME");
		permStrings.add("SET_TIME_ZONE");
		permStrings.add("SET_WALLPAPER");
		permStrings.add("SET_WALLPAPER_HINTS");
		permStrings.add("SIGNAL_PERSISTENT_PROCESSES");
		permStrings.add("STATUS_BAR");
		permStrings.add("SUBSCRIBED_FEEDS_READ");
		permStrings.add("SUBSCRIBED_FEEDS_WRITE");
		permStrings.add("SYSTEM_ALERT_WINDOW");
		permStrings.add("UPDATE_DEVICE_STATS");
		permStrings.add("USE_CREDENTIALS");
		permStrings.add("USE_SIP");
		permStrings.add("VIBRATE");
		permStrings.add("WAKE_LOCK");
		permStrings.add("WRITE_APN_SETTINGS");
		permStrings.add("WRITE_CALENDAR");
		permStrings.add("WRITE_CONTACTS");
		permStrings.add("WRITE_EXTERNAL_STORAGE");
		permStrings.add("WRITE_GSERVICES");
		permStrings.add("WRITE_HISTORY_BOOKMARKS");
		permStrings.add("WRITE_SECURE_SETTINGS");
		permStrings.add("WRITE_SETTINGS");
		permStrings.add("WRITE_SMS");
		permStrings.add("WRITE_SYNC_SETTINGS");
		permStrings.add("BIND_ACCESSIBILITY_SERVICE");
		permStrings.add("BIND_TEXT_SERVICE");
		permStrings.add("BIND_VPN_SERVICE");
		permStrings.add("PERSISTENT_ACTIVITY");
		permStrings.add("READ_CALL_LOG");
		permStrings.add("READ_EXTERNAL_STORAGE");
		permStrings.add("READ_PROFILE");
		permStrings.add("READ_SOCIAL_STREAM");
		permStrings.add("READ_USER_DICTIONARY");
		permStrings.add("ermission");
		permStrings.add("SET_PREFERRED_APPLICATIONS");
		permStrings.add("WRITE_CALL_LOG");
		permStrings.add("WRITE_PROFILE");
		permStrings.add("WRITE_SOCIAL_STREAM");
		permStrings.add("WRITE_USER_DICTIONARY");
		
		for(int i=0; i< permStrings.size(); ++i){
			
			allPermissionMap.put(permStrings.get(i), new Integer(i));
			
		}
		

	}

}
