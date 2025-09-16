package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class YellowStateTests {
    @Test
    void testYellowSelfTransitionPrevention() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        ctrl.setPreviousState(ctrl.getYellowState());
        ctrl.getYellowState().nextState(ctrl);
        assertNotEquals(ctrl.getYellowState(), ctrl.getCurrentState());
    }

    @Test
    void testInvalidPreviousStateForYellow() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        ctrl.setPreviousState(ctrl.getOffState()); // Invalid previous state for Yellow
        ctrl.getYellowState().nextState(ctrl);
        assertEquals(ctrl.getOffState(), ctrl.getCurrentState()); // Should fallback to OFF
    }
    @Test
    void testYellowFullCycleReturnsToYellow() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        for (int i = 0; i < 4; i++) {
            ctrl.getCurrentState().nextState(ctrl);
        }
        assertEquals(ctrl.getYellowState(), ctrl.getCurrentState());
    }

    void testYellowHalfCycleReturnsToYellow() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        for (int i = 0; i < 2; i++) {
            ctrl.getCurrentState().nextState(ctrl);
        }
        assertEquals(ctrl.getYellowState(), ctrl.getCurrentState());
    }

    @Test
    void testYellowIsFollowedByRedWhenPrecededByGreen() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        ctrl.setPreviousState(ctrl.getGreenState());
        ctrl.getYellowState().nextState(ctrl);
        assertEquals(ctrl.getRedState(), ctrl.getCurrentState());
    }

    @Test
    void testYellowIsFollowedByGreenWhenPrecededByRed() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        ctrl.setPreviousState(ctrl.getRedState());
        ctrl.getYellowState().nextState(ctrl);
        assertEquals(ctrl.getGreenState(), ctrl.getCurrentState());
    }

    @Test
    void testYellowTurnsLightYellow() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        assertEquals(TrafficLightColor.YELLOW, ctrl.getCurrentState().getState());
    }
}
