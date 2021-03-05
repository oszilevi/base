import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTachograph {

    TrainController ctr;
    TrainSensor sensor;
    TrainUser user;
    TrainTachograph tacho;

    @Before
    public void before(){
        tacho = new TrainTachograph();
        ctr = new TrainControllerImpl();
        user = new TrainUserImpl(ctr);
    }

    @Test
    public void Test(){
        tacho.add(user.getJoystickPosition(), ctr.getReferenceSpeed());
        Assert.assertEquals(1, tacho.get_size());
    }
}
