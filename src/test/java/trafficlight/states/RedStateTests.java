package trafficlight.states;

import org.junit.jupiter.api.Test;

class RedStateTests extends AbstractStateTests {

    @Test
    void testRedIsFollowedByYellow() {
    assertCycle(ctrl.getYellowState(), ctrl.getRedState(), 1, ctrl.getYellowState());
    }

    @Test
    void testRedFullCycleReturnsToRed() {
    assertCycle(ctrl.getYellowState(), ctrl.getRedState(), 4, ctrl.getRedState());
    }

    @Test
    void testRedTurnsLightRed() {
        assertStateColor(ctrl.getRedState(), TrafficLightColor.RED);
    }
}
