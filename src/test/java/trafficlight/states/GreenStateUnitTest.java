package trafficlight.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import trafficlight.ctrl.TrafficLightCtrl;

class GreenStateUnitTest {

    private GreenState greenState;

    private TrafficLightCtrl mockCtrl;
    private State mockYellowState;

    @BeforeEach
    void setUp() {
        greenState = new GreenState();
        mockCtrl = Mockito.mock(TrafficLightCtrl.class);
        mockYellowState = Mockito.mock(State.class);
    }

    @Test
    void does_nextState_invoke_yellow_when_called_from_green() {
        // Given
        Mockito.when(mockCtrl.getYellowState()).thenReturn(mockYellowState);
        Mockito.when(mockCtrl.getCurrentState()).thenReturn(greenState);

        // When
        greenState.nextState(mockCtrl);

        // Then
        Mockito.verify(mockCtrl).setPreviousState(greenState);
        Mockito.verify(mockCtrl).setCurrentState(mockYellowState);
    }
}
