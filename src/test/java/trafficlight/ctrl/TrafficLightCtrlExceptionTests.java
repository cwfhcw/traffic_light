package trafficlight.ctrl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficlight.states.State;
import trafficlight.states.TrafficLightColor;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Disabled;

//@Disabled
class TrafficLightCtrlExceptionTests {
    private TrafficLightCtrl ctrl;

    @BeforeEach
    void setUp() {
        ctrl = new TrafficLightCtrl();
    }

    @Test
    void testBothStatesNullExceptionHandling() {
        ctrl.setCurrentState(null);
        ctrl.setPreviousState(null);
        ctrl.nextState();
        assertEquals(ctrl.getOffState(), ctrl.getCurrentState(), "Current state should be set to offState when both states are null");
        assertEquals(ctrl.getOffState(), ctrl.getPreviousState(), "Previous state should be set to offState when both states are null");
    }

    @Test
    void testNullCurrentStateExceptionHandling() {
    ctrl.setCurrentState(null);
    ctrl.setPreviousState(ctrl.getRedState());
    ctrl.nextState();
    assertEquals(ctrl.getOffState(), ctrl.getCurrentState(), "Current state should be set to OFF after null");
    assertEquals(ctrl.getOffState(), ctrl.getPreviousState(), "Previous state should be set to OFF after exception");
    }

    @Test
    void testNullPreviousStateExceptionHandling() {
    ctrl.setCurrentState(ctrl.getGreenState());
    ctrl.setPreviousState(null);
    ctrl.nextState();
    assertEquals(ctrl.getOffState(), ctrl.getCurrentState(), "Current state should be set to OFF after exception");
    assertEquals(ctrl.getOffState(), ctrl.getPreviousState(), "Previous state should be set to OFF after exception");
    }

    @Test
    void testInvalidYellowTransitionExceptionHandling() {
        ctrl.setCurrentState(ctrl.getYellowState());
        ctrl.setPreviousState(ctrl.getYellowState()); // Not RED or GREEN
        ctrl.nextState();
        assertEquals(ctrl.getOffState(), ctrl.getCurrentState(), "Current state should be set to offState after invalid yellow transition");
        assertEquals(ctrl.getOffState(), ctrl.getPreviousState(), "Previous state should be set to offState after invalid yellow transition");
    }

    @Test
    void testUnexpectedExceptionHandling() {
        State throwingState = new State() {
            @Override
            public void nextState(TrafficLightCtrl ctrl) {
                throw new RuntimeException("Dummy exception");
            }
            @Override
            public TrafficLightColor getState() {
                return TrafficLightColor.RED;
            }
        };
        ctrl.setCurrentState(throwingState);
        ctrl.setPreviousState(ctrl.getRedState());
        assertDoesNotThrow(ctrl::nextState, "nextState should catch unexpected exceptions and not throw");
        assertEquals(throwingState, ctrl.getCurrentState(), "Current state should remain unchanged after unexpected exception");
    }
}
