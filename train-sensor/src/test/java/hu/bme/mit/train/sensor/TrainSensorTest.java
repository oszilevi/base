package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.system.TrainSystem;

public class TrainSensorTest {
    TrainSensor sensor;

    @Before
    public void before() {
        TrainSystem system = new TrainSystem();
        sensor = system.getSensor();
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        sensor.overrideSpeedLimit(100);
        Assert.assertEquals(100, sensor.getSpeedLimit());
    }
}
