package trafficlight.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trafficlight.ctrl.TrafficLightCtrl;

class OffStateUnitTest {

    private OffState offState;

    private TrafficLightCtrl mockCtrl;
    private State mockRedState;

    @BeforeEach
    void setUp() {
        offState = new OffState();
        mockCtrl = Mockito.mock(TrafficLightCtrl.class);
        mockRedState = Mockito.mock(State.class);
    }

    @Test
    void does_nextState_invoke_red_when_called_from_off() {
        // Given
        Mockito.when(mockCtrl.getRedState()).thenReturn(mockRedState);
        Mockito.when(mockCtrl.getCurrentState()).thenReturn(offState);

        // When
        offState.nextState(mockCtrl);

        // Then
        Mockito.verify(mockCtrl).setPreviousState(offState);
        Mockito.verify(mockCtrl).setCurrentState(mockRedState);
    }
}
