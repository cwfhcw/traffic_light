package trafficlight.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GreenStateUnitTest extends AbstractStateUnitTest {

    private GreenState greenState;
    private State mockYellowState;

    @BeforeEach
    void setUp() {
        greenState = new GreenState();
        mockYellowState = org.mockito.Mockito.mock(State.class);
    }

    @Test
    void does_nextState_invoke_yellow_when_called_from_green() {
        // Given
        org.mockito.Mockito.when(mockCtrl.getYellowState()).thenReturn(mockYellowState);
        org.mockito.Mockito.when(mockCtrl.getCurrentState()).thenReturn(greenState);

        // When
        greenState.nextState(mockCtrl);

        // Then
        verifyTransition(greenState, mockYellowState);
    }
}
