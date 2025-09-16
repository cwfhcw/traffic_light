package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class OffStateTests {
    @Test
    void testOffIsFollowedByRed() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getOffState());
        ctrl.getOffState().nextState(ctrl);
        assertEquals(ctrl.getRedState(), ctrl.getCurrentState());
    }

    @Test
    void testOffTurnsLightOff() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getOffState());
        assertEquals(TrafficLightColor.OFF, ctrl.getCurrentState().getState());
    }
}
