package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class YellowStateTest {
    @Test
    void testNextStateFromYellowToRed() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        ctrl.setPreviousState(ctrl.getGreenState());
        ctrl.getYellowState().nextState(ctrl);
        assertEquals(ctrl.getRedState(), ctrl.getCurrentState());
    }
    @Test
    void testNextStateFromYellowToGreen() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        ctrl.setPreviousState(ctrl.getRedState());
        ctrl.getYellowState().nextState(ctrl);
        assertEquals(ctrl.getGreenState(), ctrl.getCurrentState());
    }
    @Test
    void testGetState() {
        assertEquals(TrafficLightColor.YELLOW, new YellowState().getState());
    }
}
