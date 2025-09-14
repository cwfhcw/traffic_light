package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class OffStateTest {
    @Test
    void testNextStateFromOff() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getOffState());
        ctrl.setPreviousState(ctrl.getOffState());
        ctrl.getOffState().nextState(ctrl);
        assertEquals(ctrl.getRedState(), ctrl.getCurrentState());
    }
    @Test
    void testGetState() {
        assertEquals(TrafficLightColor.OFF, new OffState().getState());
    }
}
