package trafficlight.states;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

public abstract class AbstractStateIntegrationTest {
    protected TrafficLightCtrl ctrl;

    @BeforeEach
    void setUp() {
        ctrl = new TrafficLightCtrl();
    }

    // asserting the traffic light cycle
    protected void assertCycle(State previous, State current, int steps, State result) {
        ctrl.setPreviousState(previous);
        ctrl.setCurrentState(current);
        for (int i = 0; i < steps; i++) {
            ctrl.nextState();
        }
        assertEquals(result, ctrl.getCurrentState());
    }

    // asserting correct gui color for states
    protected void assertStateColor(State state, TrafficLightColor expectedColor) {
        ctrl.setCurrentState(state);
        assertEquals(expectedColor, ctrl.getCurrentState().getState());
    }
}
