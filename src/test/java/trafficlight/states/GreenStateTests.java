package trafficlight.states;

import org.junit.jupiter.api.Test;

class GreenStateTests extends AbstractStateTests {

    @Test
    void testGreenIsFollowedByYellow() {
        assertCycle(ctrl.getYellowState(), ctrl.getGreenState(), 1, ctrl.getYellowState());
    }

    @Test
    void testGreenFullCycleReturnsToGreen() {
        assertCycle(ctrl.getYellowState(), ctrl.getGreenState(), 1, ctrl.getYellowState());
    }

    @Test
    void testGreenTurnsLightGreen() {
        assertStateColor(ctrl.getGreenState(), TrafficLightColor.GREEN);
    }
}
