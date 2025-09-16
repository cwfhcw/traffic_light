package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class YellowStateTests {
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
