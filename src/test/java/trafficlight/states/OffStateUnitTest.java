package trafficlight.states;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OffStateUnitTest extends AbstractStateUnitTest {

    private OffState offState;
    private State mockRedState;

    @BeforeEach
    void setUp() {
        offState = OffState.getInstance();
        mockRedState = org.mockito.Mockito.mock(State.class);
    }

    @Test
    void does_nextState_invoke_red_when_called_from_off() {
        // Given
        org.mockito.Mockito.when(mockCtrl.getRedState()).thenReturn(mockRedState);
        org.mockito.Mockito.when(mockCtrl.getCurrentState()).thenReturn(offState);

        // When
        offState.nextState(mockCtrl);

        // Then
        verifyTransition(offState, mockRedState);
    }
}
