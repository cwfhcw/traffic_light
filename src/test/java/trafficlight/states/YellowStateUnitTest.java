package trafficlight.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trafficlight.ctrl.TrafficLightCtrl;

class YellowStateUnitTest {

    private YellowState yellowState;

    private TrafficLightCtrl mockCtrl;
    private State mockGreenState;
    private State mockRedState;

    @BeforeEach
    void setUp() {
        yellowState = new YellowState();
        mockCtrl = Mockito.mock(TrafficLightCtrl.class);
        mockGreenState = Mockito.mock(State.class);
        mockRedState = Mockito.mock(State.class);
        Mockito.when(mockCtrl.getGreenState()).thenReturn(mockGreenState);
        Mockito.when(mockCtrl.getRedState()).thenReturn(mockRedState);
        Mockito.when(mockCtrl.getCurrentState()).thenReturn(yellowState);
    }

    private void setPreviousState(State state) {
        Mockito.when(mockCtrl.getPreviousState()).thenReturn(state);
    }

    @Test
    void testNextState_FromRed_TransitionsToGreen() {
        // Given: previous state is Red
        setPreviousState(mockRedState);

        // When: nextState is called
        yellowState.nextState(mockCtrl);

        // Then: previousState and currentState are updated correctly
        Mockito.verify(mockCtrl).setPreviousState(yellowState);
        Mockito.verify(mockCtrl).setCurrentState(mockGreenState);
    }

    @Test
    void testNextState_FromGreen_TransitionsToRed() {
        // Given: previous state is Green
        setPreviousState(mockGreenState);

        // When: nextState is called
        yellowState.nextState(mockCtrl);

        // Then: previousState and currentState are updated correctly
        Mockito.verify(mockCtrl).setPreviousState(yellowState);
        Mockito.verify(mockCtrl).setCurrentState(mockRedState);
    }
}
