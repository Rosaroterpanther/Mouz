import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Date;

import com.sun.jna.*;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;



public class Controller implements Runnable{
	
	/*
	 *  Prototyp V.1
	 * 
	 * */
	
	public static Date startDate;
	public static Date lastDate;
	public static Date curDate;
	public static Date endDate;
	
	public static int clicksCounter;
	public static boolean exit;
	
	public static BufferedReader reader;
	
	public static Processes p;
	
	//Threads
	public static Thread thread_exit;
	
	//Frame
	public static Frame window;
	
	public static void main(String[] args) {
		System.out.println("Initalize...");
		
		init();
		System.out.println("Aktuelle Uhrzeit: " + startDate.getHours() + ":" + startDate.getMinutes() + ":" + startDate.getSeconds());
		listen();
		end();
	}
	
	
	public static void init() {
		// Init Dates
		startDate = new Date();
		lastDate = new Date();
		
		// TODO: Init Observer/Mouse Listener
		reader = new BufferedReader(new InputStreamReader(System.in));
		
		// TODO: Init values
		clicksCounter = 0;
		exit = false;
		
		// Init Processes
		p = new Processes();
		
		// Init Threads
		thread_exit = new Thread( new Controller() );
		
		/**
		 * Launch the application.
		 */
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						window = new Frame();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
	
	public static void listen(){
		
		System.out.println("To exit, enter: exit()");
		
		/* WARNING Wir brauchen diesen normalen Otuput derzeit sonst Kacken unsere Threas ab ... */
		p.processes = p.listRunningProcesses();
		p.printProcess(p.processes);
		
		//Start Thread
		thread_exit.start();
		
		
		while(true){
			
			// TODO: Listen for Mouse clicks ...
			// TODO: Listen for End Signal
			
			//TODO: Fix this
			curDate = new Date();
			
			if((curDate.getMinutes()-lastDate.getMinutes()) > 1) {
				lastDate = new Date();
				
				
			}
			
			p.processes = p.listRunningProcesses();
			p.printProcess(p.processes, window);
			
			if(exit) {
				break;
			}
			
			try{
			    Thread.sleep(1000);
			}catch(InterruptedException ex){
			    Thread.currentThread().interrupt();
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


	public void run() {
		while(true){
			String input = null;
			try {
				input = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			if(input.equals("exit()")) {
				exit = true;
				break;
			}

		}	
	}
	
}
