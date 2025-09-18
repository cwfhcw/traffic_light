package trafficlight.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YellowStateUnitTest extends AbstractStateUnitTest {

    private YellowState yellowState;
    private State mockGreenState;
    private State mockRedState;

    @BeforeEach
    void setUp() {
        yellowState = new YellowState();
        mockGreenState = org.mockito.Mockito.mock(State.class);
        mockRedState = org.mockito.Mockito.mock(State.class);
        org.mockito.Mockito.when(mockCtrl.getGreenState()).thenReturn(mockGreenState);
        org.mockito.Mockito.when(mockCtrl.getRedState()).thenReturn(mockRedState);
        org.mockito.Mockito.when(mockCtrl.getCurrentState()).thenReturn(yellowState);
    }

    private void setPreviousState(State state) {
        org.mockito.Mockito.when(mockCtrl.getPreviousState()).thenReturn(state);
    }

    @Test
    void does_nextState_invoke_green_when_called_from_yellow_preceded_by_red() {
        // Given
        setPreviousState(mockRedState);

        // When
        yellowState.nextState(mockCtrl);

        // Then
        verifyTransition(yellowState, mockGreenState);
    }

    @Test
    void does_nextState_invoke_red_when_called_from_yellow_preceded_by_green() {
        // Given
        setPreviousState(mockGreenState);

        // When
        yellowState.nextState(mockCtrl);

        // Then
        verifyTransition(yellowState, mockRedState);
    }
}
