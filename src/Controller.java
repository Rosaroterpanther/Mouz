import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class Controller {
	
	/*
	 *  Prototyp V.1
	 * 
	 * */
	
	public static Date startDate;
	public static Date endDate;
	
	public static int clicksCounter;
	
	public static BufferedReader reader;
	
	public static Processes p;
	
	public static void main(String[] args) {
		System.out.println("Initalize...");
		
		init();
		System.out.println("Aktuelle Uhrzeit: " + startDate.getHours() + ":" + startDate.getMinutes() + ":" + startDate.getSeconds());
		listen();
		end();
	}
	
	
	public static void init() {
		startDate = new Date();
		
		// TODO: Init Observer/Mouse Listener
		reader = new BufferedReader(new InputStreamReader(System.in));
		
		// TODO: Init values
		clicksCounter = 0;
		
		p = new Processes();
		p.processes = p.listRunningProcesses();
	}
	
	public static void listen(){
		
		System.out.println("===================================");
		Iterator<String> it = p.processes.iterator();
	      int i = 0;
	      
	      while (it.hasNext()) {
	    	  System.out.println(""+i+": "+it.next());

	      }
		System.out.println("===================================");
		
		System.out.println("To exit, enter: exit()");
		
		while(true){
			
			// TODO: Listen for Mouse clicks ...
			// TODO: Listen for End Signal
			String input = null;
			try {
				input = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			if(input.equals("exit()")) {
				break;
			}

		}
	}
	
	public static void end() {
		endDate = new Date();
		System.out.println("End Uhrzeit: " + endDate.getHours() + ":" + endDate.getMinutes() + ":" + endDate.getSeconds());
		int runnedHours = Math.abs(startDate.getHours() - endDate.getHours());
		int runnedMinutes = Math.abs(startDate.getMinutes() - endDate.getMinutes());
		int runnedSeconds = Math.abs(startDate.getSeconds() - endDate.getSeconds());
		System.out.println("Programm lief: " + runnedHours + ":" + runnedMinutes + ":" + runnedSeconds);
		
	}
}
