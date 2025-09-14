package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class GreenStateTest {
    @Test
    void testNextStateFromGreen() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getGreenState());
        ctrl.setPreviousState(ctrl.getRedState());
        ctrl.getGreenState().nextState(ctrl);
        assertEquals(ctrl.getYellowState(), ctrl.getCurrentState());
    }
    @Test
    void testGetState() {
        assertEquals(TrafficLightColor.GREEN, new GreenState().getState());
    }
}
