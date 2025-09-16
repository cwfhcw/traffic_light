package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class RedStateTests {
    @Test
    void testRedSelfTransitionPrevention() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getRedState());
        ctrl.setPreviousState(ctrl.getRedState());
        ctrl.getRedState().nextState(ctrl);
        assertNotEquals(ctrl.getRedState(), ctrl.getCurrentState());
    }
    @Test
    void testRedFullCycleReturnsToRed() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getRedState());
        for (int i = 0; i < 4; i++) {
            ctrl.getCurrentState().nextState(ctrl);
        }
        assertEquals(ctrl.getRedState(), ctrl.getCurrentState());
    }
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
