package CallCenter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Employee.Manager;
import Employee.Receptionist;
import Employee.Supervisor;
import IncomingCall.Call;
import Queues.*;

public class CallCenter {

	public static void main(String[] args) {
		System.out.println("begin:");
		//initialize employees and data structure
		IncomingQueue incomeCalls = IncomingQueue.getInstance();
		CallSimulator cs = new CallSimulator(incomeCalls);
		Manager man = Manager.getInstance(0);
		Supervisor sup = Supervisor.getInstance(1);
		sup.setManager(man);
		
		//suppose there only 5 receptionists, one supervisor, one manager
		ExecutorService employeePool = Executors.newFixedThreadPool(5);
		
		//make a thread for 
		Thread t= new Thread(cs);
		t.start();
		
  		for(int i=2;i<7;i++){
			Receptionist r = new Receptionist(i);
			r.setSupervisor(sup);
			r.setCalls(incomeCalls);
			//(new Thread(r)).start();
			employeePool.submit(r);                                
		}
		
  		//employeePool.shutdown();
	}

}
