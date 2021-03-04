package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.controller.TrainControllerImpl;

public class TrainSensorTest {
    TrainSensor sensor;
    TrainUser user;
    TrainController ctr;


    @Before
    public void before(){
        ctr = new TrainControllerImpl();
        user = new TrainUserImpl(ctr);
        sensor = new TrainSensorImpl(ctr, user);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        sensor.overrideSpeedLimit(100);
        Assert.assertEquals(100, sensor.getSpeedLimit());
    }
}
