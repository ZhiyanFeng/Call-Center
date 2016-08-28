package Employee;
import IncomingCall.Call;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Employee {
	protected int id;
	protected String title;
	protected Queue<Call> waitingCalls = new LinkedList<Call>();
	
	public Employee(int id){
		this.id = id;
	}
	
	protected void handleCall(Call call){
		
	}
}
