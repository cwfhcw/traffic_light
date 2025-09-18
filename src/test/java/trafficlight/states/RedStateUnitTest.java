package trafficlight.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trafficlight.ctrl.TrafficLightCtrl;

class RedStateUnitTest {

    private RedState redState;
    
    private TrafficLightCtrl mockCtrl;
    private State mockYellowState;

    @BeforeEach
    void setUp() {
        redState = new RedState();
        mockCtrl = Mockito.mock(TrafficLightCtrl.class);
        mockYellowState = Mockito.mock(State.class);
    }

    @Test
    void does_nextState_invoke_yellow_when_called_from_red() {
        // Given
        Mockito.when(mockCtrl.getYellowState()).thenReturn(mockYellowState);
        Mockito.when(mockCtrl.getCurrentState()).thenReturn(redState);

        // When
        redState.nextState(mockCtrl);

        // Then
        Mockito.verify(mockCtrl).setPreviousState(redState);
        Mockito.verify(mockCtrl).setCurrentState(mockYellowState);
    }
}
