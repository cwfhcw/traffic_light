package trafficlight.states;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

public abstract class AbstractStateTests {
    protected TrafficLightCtrl ctrl;

    @BeforeEach
    void setUp() {
        ctrl = new TrafficLightCtrl();
    }

    // Helper to assert the traffic light cycle
    protected void assertCycle(State previous, State current, int steps, State result) {
        ctrl.setPreviousState(previous);
        ctrl.setCurrentState(current);
        for (int i = 0; i < steps; i++) {
            ctrl.nextState();
        }
        assertEquals(result, ctrl.getCurrentState());
    }

    // Abstract test for verifying color of a state
    protected void assertStateColor(State state, TrafficLightColor expectedColor) {
        ctrl.setCurrentState(state);
        assertEquals(expectedColor, ctrl.getCurrentState().getState());
    }
}
