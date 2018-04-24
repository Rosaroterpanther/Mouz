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
	
	public void printProcessList(List<String> processes){
		System.out.println("===================================");
		Iterator<String> it = processes.iterator();
	      int i = 0;
	      
	      while (it.hasNext()) {
	    	  System.out.println(""+i+": "+it.next());

	      }
	}
	
	public void printForegroundWindow() {
		byte[] windowText = new byte[512];

	      PointerType hwnd = User32.INSTANCE.GetForegroundWindow(); // then you can call it!
	      User32.INSTANCE.GetWindowTextA(hwnd, windowText, 512);
	      System.out.println("#####::"+Native.toString(windowText)+"::####");
	      System.out.println("===================================");
	}
	
	
}
