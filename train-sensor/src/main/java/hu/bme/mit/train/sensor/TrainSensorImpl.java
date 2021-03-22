package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private int speedLimit = 5;
	private TrainUser user;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.user = user;
		this.controller = controller;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		if(speedLimit > 500 || speedLimit < 0 || speedLimit <= this.speedLimit / 2){
			user.setAlarmState(true);
		}

		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}
}
