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
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensor sensor;
    TrainUser user;
    TrainController ctr;


    @Before
    public void before(){
        user = mock(TrainUser.class);
        ctr = mock(TrainController.class);
        sensor = new TrainSensorImpl(ctr, user);

        when(ctr.getReferenceSpeed()).thenReturn(100);
    }

/*    @Test
    public void ThisIsAnExampleTestStub() {
        sensor.overrideSpeedLimit(100);
        Assert.assertEquals(100, sensor.getSpeedLimit());
    }*/

    @Test
    public void SpeedLimitSetToNegative100AlarmTurnsOn(){
        sensor.overrideSpeedLimit(-100);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void SpeedLimitSetTo600AlarmTurnsOn(){
        sensor.overrideSpeedLimit(600);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void SpeedLimitSetToNormalAlarmRemainsTurnedOff(){
        sensor.overrideSpeedLimit(200);
        verify(user, times(0)).setAlarmState(false);
    }

    //at first, this test case failed, resolve incoming...
    @Test
    public void SpeedLimitSetToSmallerThanHalfOfRefExactly49SpeedAlarmTurnsOn(){
        sensor.overrideSpeedLimit(49);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void SpeedLimitSetToNotSmallerThanHalfOfRefSpeedExactly50AlarmRemainsTurnedOff(){
        sensor.overrideSpeedLimit(50);
        verify(user, times(0)).setAlarmState(false);
    }
}
