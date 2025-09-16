package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class RedStateTests {
    @Test
    void testRedIsFollowedByYellow() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getRedState());
        ctrl.getRedState().nextState(ctrl);
        assertEquals(ctrl.getYellowState(), ctrl.getCurrentState());
    }

    @Test
    void testRedTurnsLightRed() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getRedState());
        assertEquals(TrafficLightColor.RED, ctrl.getCurrentState().getState());
    }
}
