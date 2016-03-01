package fr.telecom.durifgame;

public class Log {
	
	public Log(){
		
	}
	public static void logd(boolean DBG,String TAG,String msg){
		if(DBG)
		System.out.println(TAG+" :: "+msg);
	}

}
