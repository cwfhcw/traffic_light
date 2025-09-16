package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class GreenStateTests {
    @Test
    void testGreenSelfTransitionPrevention() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getGreenState());
        ctrl.setPreviousState(ctrl.getGreenState());
        ctrl.getGreenState().nextState(ctrl);
        assertNotEquals(ctrl.getGreenState(), ctrl.getCurrentState());
    }
    @Test
    void testGreenFullCycleReturnsToGreen() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getGreenState());
        for (int i = 0; i < 4; i++) {
            ctrl.getCurrentState().nextState(ctrl);
        }
        assertEquals(ctrl.getGreenState(), ctrl.getCurrentState());
    }
    @Test
    void testGreenIsFollowedByYellow() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getGreenState());
        ctrl.getGreenState().nextState(ctrl);
        assertEquals(ctrl.getYellowState(), ctrl.getCurrentState());
    }
    @Test
    void testGreenTurnsLightGreen() {
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getGreenState());
        assertEquals(TrafficLightColor.GREEN, ctrl.getCurrentState().getState());
    }
}
