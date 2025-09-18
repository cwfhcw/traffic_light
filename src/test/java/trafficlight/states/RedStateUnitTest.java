package trafficlight.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RedStateUnitTest extends AbstractStateUnitTest {

    private RedState redState;
    private State mockYellowState;

    @BeforeEach
    void setUp() {
        redState = RedState.INSTANCE;
        mockYellowState = org.mockito.Mockito.mock(State.class);
    }

    @Test
    void does_nextState_invoke_yellow_when_called_from_red() {
        // Given
        org.mockito.Mockito.when(mockCtrl.getYellowState()).thenReturn(mockYellowState);
        org.mockito.Mockito.when(mockCtrl.getCurrentState()).thenReturn(redState);

        // When
        redState.nextState(mockCtrl);

        // Then
        verifyTransition(redState, mockYellowState);
    }
}
