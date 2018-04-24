import java.io.*;
import java.util.*;

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
	
	public void printProcessList(List<String> processes){
		System.out.println("===================================");
		Iterator<String> it = processes.iterator();
	      int i = 0;
	      
	      while (it.hasNext()) {
	    	  System.out.println(""+i+": "+it.next());

	      }
		System.out.println("===================================");
	}
	
	
}
