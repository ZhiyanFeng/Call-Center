package IncomingCall;


import Queues.*;

public class Call{
	
	public int id;
	private HandledLevel level;
	
	public Call(int id, int level){
		this.id = id;
		setHandledLevel(level);
	}
	
	/**
	 * @return the handledLevel
	 */
	public HandledLevel getHandledLevel() {
		return level;
	}

	/**
	 * @param handledLevel the handledLevel to set
	 */
	public void setHandledLevel(int level) {
		switch(level){
		case 0:
			this.level = HandledLevel.Normal;
			break;
		case 1:
			this.level = HandledLevel.Supervisor;
			break;
		case 2:
			this.level = HandledLevel.Manager;
			break;
		default :
			break;
		}
	}
}
