package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class RedStateTest {
    @Test
    void testNextStateFromRed() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getRedState());
        ctrl.setPreviousState(ctrl.getGreenState());
        ctrl.getRedState().nextState(ctrl);
        assertEquals(ctrl.getYellowState(), ctrl.getCurrentState());
    }
    @Test
    void testGetState() {
        assertEquals(TrafficLightColor.RED, new RedState().getState());
    }
}
