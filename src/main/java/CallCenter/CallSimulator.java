package CallCenter;

import IncomingCall.Call;
import Queues.IncomingQueue;

public class CallSimulator implements Runnable {
	
	private IncomingQueue calls;
	
	public CallSimulator(IncomingQueue calls){
		this.calls = calls;
	}


	public void run() {
		
		for(int i=1;i<=5;i++){
			int level = i%3;
			Call newCall = new Call(i,level);
			calls.put(newCall);
		}
	}

}
