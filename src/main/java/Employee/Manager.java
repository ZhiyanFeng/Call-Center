package Employee;

import IncomingCall.Call;

public class Manager extends Employee {
	private static Manager instance = null;

	private Manager(int id) {
		super(id);
		// TODO Auto-generated constructor stub
		this.title = "Manager";
	}

	public static Manager getInstance(int id){
		if(instance == null){
			instance = new Manager(id);
		}
		return instance;
	}
	
	public void handleCall(Call call){
		
			try {
				System.out.format("manager %d is dealing call: %d\n", id, call.id);
				Thread.sleep((long)(Math.random()*100));
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
