package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import hu.bme.mit.train.interfaces.*;
import hu.bme.mit.train.sensor.TrainSensorImpl;

public class TrainSensorTest {

    TrainController controller;
    TrainUser user;
    TrainSensorImpl sensor;

    @Before
    public void before() {
        controller = mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(controller,user);
    }

    /* Test, whether alarm state will be triggered, as specified, in case the speed limit is set negative.
     * 1: User not in alarm state, speed limit is at the default 10
     * 2: overrideSpeedLimit(-1)
     * 3: User must be in alarm state
     */
    @Test
    public void AlarmFeatureTest_Negative() {
        sensor.overrideSpeedLimit(-1);
	verify(user,times(1)).setAlarmState(true);        
    }

    /* Test, whether the alarm state will be triggered, as specified, in case the speed limit is set above 500.
     * 1: User not in alarm state, speed limit is at the default 10
     * 2: overrideSpeedLimit(501)
     * 3: User must be in alarm state
     */
    @Test
    public void AlarmFeatureTest_Above500() {
        sensor.overrideSpeedLimit(501);
	verify(user,times(1)).setAlarmState(true);
    }

    /* Test, whether the alarm state will be triggered, as specified, in case the speed limit is set below half of its previous value.
     * 1: User not in alarm state, speed limit is at the default 10
     * 2: overrideSpeedLimit(4)
     * 3: User must be in alarm state
     */
    @Test
    public void AlarmFeatureTest_LessThanHalf() {
        sensor.overrideSpeedLimit(4);
	verify(user,times(1)).setAlarmState(true);
    }

    /* Test, whether the alarm state will not be triggered, as specified, in case the speed limit is set from 10 to 20.
     * 1: User not in alarm state, speed limit is at the default 10
     * 2: overrideSpeedLimit(20)
     * 3: User must not be in alarm state
     */
    @Test
    public void AlarmFeatureTest_Normal() {
        sensor.overrideSpeedLimit(20);
	verify(user,times(0)).setAlarmState(true);
    }

}
