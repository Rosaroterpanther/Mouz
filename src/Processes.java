import java.io.*;
import java.util.*;

import com.sun.jna.Native;
import com.sun.jna.PointerType;

public class Processes {

	public List<String> processes;
	
	public static List<String> listRunningProcesses() {
	    List<String> processes = new ArrayList<String>();
	    try {
	      String line;
	      Process p = Runtime.getRuntime().exec("tasklist.exe /fo csv /nh");
	      BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	      while ((line = input.readLine()) != null) {
	          if (!line.trim().equals("")) {
	              line = line.substring(1);
	              processes.add(line);
	          }

	      }
	      input.close();
	    }
	    catch (Exception err) {
	      err.printStackTrace();
	    }
	    return processes;
	  }
	
	
	public void printProcess(List<String> processes) {
		printProcessList(processes);
		printForegroundWindow();
	}
	
	public void printProcess(List<String> processes, Frame frame) {
		printProcessList(processes, frame);
		printForegroundWindow(frame);
	}
	
	public void printProcessList(List<String> processes, Frame frame) {
		String taskList = "";
		Iterator<String> it = processes.iterator();
	      int i = 0;
	      
	      while (it.hasNext()) {
	    	  taskList = taskList + System.lineSeparator() + i + ": " + it.next(); 
	      }
	      
	      frame.setTaskList(taskList);
	}
	
	public void printProcessList(List<String> processes){
		System.out.println("===================================");
		Iterator<String> it = processes.iterator();
	      int i = 0;
	      
	      while (it.hasNext()) {
	    	  System.out.println(""+i+": "+it.next());

	      }
	}
	
	public void printForegroundWindow() {
		/*
		 * Source: https://stackoverflow.com/questions/5767104/using-jna-to-get-getforegroundwindow
		 * Libarys: https://github.com/java-native-access/jna
		 * 
		 * */
		
		  byte[] windowText = new byte[512];

	      PointerType hwnd = User32.INSTANCE.GetForegroundWindow(); // then you can call it!
	      User32.INSTANCE.GetWindowTextA(hwnd, windowText, 512);
	      System.out.println("#####::"+Native.toString(windowText)+"::####");
	      System.out.println("===================================");
	}
	
	public void printForegroundWindow(Frame frame) {
		/*
		 * Source: https://stackoverflow.com/questions/5767104/using-jna-to-get-getforegroundwindow
		 * Libarys: https://github.com/java-native-access/jna
		 * 
		 * */
		
		  byte[] windowText = new byte[512];

	      PointerType hwnd = User32.INSTANCE.GetForegroundWindow(); // then you can call it!
	      User32.INSTANCE.GetWindowTextA(hwnd, windowText, 512);
	      frame.setCurrentTask(""+Native.toString(windowText));
	}
	
	
}
