package trafficlight.states;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import trafficlight.ctrl.TrafficLightCtrl;

public abstract class AbstractStateUnitTest {
    protected TrafficLightCtrl mockCtrl;

    @BeforeEach
    void setUpBase() {
        mockCtrl = Mockito.mock(TrafficLightCtrl.class); //this includes nextState( )
    }

    protected void verifyTransition(State state, State expectedNextState) {
        Mockito.verify(mockCtrl).setPreviousState(state);
        Mockito.verify(mockCtrl).setCurrentState(expectedNextState);
    }
}
