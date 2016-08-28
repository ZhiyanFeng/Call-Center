package Employee;

import IncomingCall.Call;
import Queues.IncomingQueue;

public class Supervisor extends Employee implements Runnable {
	private static Supervisor instance = null;
	private Manager manager;
	private boolean busy=false;
	private IncomingQueue calls;

	
	private Supervisor(int id) {
		super(id);
		// TODO Auto-generated constructor stub
		this.title = "Supervisor";
	}
	
	public static Supervisor getInstance(int id){
		if(instance == null){
			instance = new Supervisor(id);
		}
		return instance;
	}

	private Boolean canHandle(Call call){
		boolean bool = call.getHandledLevel().toString()== "Supervisor" || !busy ? true:false;
		return bool;
	}
	
	public void handleCall(Call call){
		if(canHandle(call)){
			try {
				busy=true;
				System.out.format("Supervisor %d is dealing call: %d\n", id, call.id);
				Thread.sleep((long)(Math.random()*1000));
				busy=false;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			manager.handleCall(call);
		}
	}
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public void run() {
		// TODO Auto-generated method stub
		handleCall(calls.take());
	}

}
