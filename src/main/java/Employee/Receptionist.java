package Employee;
import IncomingCall.Call;
import Queues.IncomingQueue;;

public class Receptionist extends Employee implements Runnable {
	private Supervisor supervisor;
	private IncomingQueue calls;
	

	public IncomingQueue getCalls() {
		return calls;
	}

	public void setCalls(IncomingQueue calls) {
		this.calls = calls;
	}

	public Receptionist(int id) {
		super(id);
		// TODO Auto-generated constructor stub
		this.title = "Receptionist";
	}
	
	private Boolean canHandle(Call call){
		boolean bool = call.getHandledLevel().toString()== "Normal" ? true:false;
		return bool;
	}
	
	public void handleCall(Call call){
		if(canHandle(call)){
			try {
				System.out.format("employee %d is dealing call: %d\n", id, call.id);
				Thread.sleep((long)(Math.random()*100));
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			supervisor.handleCall(call);
		}
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public void run() {
		// TODO Auto-generated method stub
		handleCall(calls.take());
	}

}
