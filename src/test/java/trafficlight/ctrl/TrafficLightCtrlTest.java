package trafficlight.ctrl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trafficlight.states.State;
import trafficlight.states.TrafficLightColor;

import static org.junit.jupiter.api.Assertions.*;

//-------------------------------------------
// We only test the exception handling here!
//-------------------------------------------

class TrafficLightCtrlTest {
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
        assertEquals(ctrl.getOffState(), ctrl.getCurrentState());
        assertEquals(ctrl.getOffState(), ctrl.getPreviousState());
    }

    @Test
    void testNullCurrentStateExceptionHandling() {
        ctrl.setCurrentState(null);
        ctrl.setPreviousState(ctrl.getRedState());
        ctrl.nextState();
        assertEquals(ctrl.getOffState(), ctrl.getCurrentState());
        assertEquals(ctrl.getOffState(), ctrl.getPreviousState());
        }

    @Test
    void testNullPreviousStateExceptionHandling() {
        ctrl.setCurrentState(ctrl.getRedState());
        ctrl.setPreviousState(null);
        ctrl.nextState();
        assertEquals(ctrl.getOffState(), ctrl.getCurrentState());
        assertEquals(ctrl.getOffState(), ctrl.getPreviousState());
    }

    @Test
    void testInvalidYellowTransitionExceptionHandling() {
        ctrl.setCurrentState(ctrl.getYellowState());
        ctrl.setPreviousState(ctrl.getYellowState());
        ctrl.nextState();
        assertEquals(ctrl.getOffState(), ctrl.getCurrentState());
        assertEquals(ctrl.getOffState(), ctrl.getPreviousState());
    }

    @Test
    void testUnexpectedExceptionHandling() {
        State throwingState = new State() {
            @Override
            public void nextState(TrafficLightCtrl ctrl) {
                throw new RuntimeException();
            }

            @Override
            public TrafficLightColor getState() {
                return TrafficLightColor.RED;
            }
        };
        ctrl.setCurrentState(throwingState);
        ctrl.setPreviousState(ctrl.getRedState());
        assertDoesNotThrow(() -> ctrl.nextState());
        assertEquals(throwingState, ctrl.getCurrentState());
    }
}
