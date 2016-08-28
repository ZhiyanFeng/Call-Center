package Queues;

import java.util.LinkedList;
import java.util.Queue;

import IncomingCall.Call;

public class IncomingQueue {
	private static IncomingQueue instance=null;
	private Queue<Call> calls =null;
	private boolean empty = true;

	private IncomingQueue(){
		calls = new LinkedList<Call>();
	}
	
	public static IncomingQueue getInstance(){
		if(instance == null){
			instance = new IncomingQueue();
		}
		return instance;
	}
	
	public synchronized Call take(){
		while (empty){
			try{
				wait();
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
			}
			empty = calls.isEmpty()? true:false;
			
			notify();
			return calls.poll();
	}
	
	public synchronized void put(Call call){
		calls.add(call);
		empty = false;
		notify();
	}
}
