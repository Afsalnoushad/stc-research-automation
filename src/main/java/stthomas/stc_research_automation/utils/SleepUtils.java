package stthomas.stc_research_automation.utils;


public class SleepUtils {
	
	
	public static void waitSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void shortWait() {
		waitSeconds(1);
	}
	
	public static void mediumWait() {
		waitSeconds(3);
	}
	
	public static void longWait() {
		waitSeconds(5);
	}
	
	public static void lengthyWait() {
		waitSeconds(15);
	}
	
}
