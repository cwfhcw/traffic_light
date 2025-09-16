package trafficlight.states;

import org.junit.jupiter.api.Test;

class YellowStateTests extends AbstractStateTests {

    @Test
    void testYellowIsFollowedByGreenWhenPrecededByRed() {
        assertCycle(ctrl.getRedState(), ctrl.getYellowState(), 1, ctrl.getGreenState());
    }

    @Test
    void testYellowIsFollowedByRedWhenPrecededByGreen() {
        assertCycle(ctrl.getGreenState(), ctrl.getYellowState(), 1, ctrl.getRedState());
    }

    @Test
    void testYellowHalfCycleReturnsToYellow() {
        assertCycle(ctrl.getRedState(), ctrl.getYellowState(), 2, ctrl.getYellowState());
    }

    @Test
    void testYellowFullCycleReturnsToYellow() {
        assertCycle(ctrl.getRedState(), ctrl.getYellowState(), 4, ctrl.getYellowState());
    }

    @Test
    void testYellowTurnsLightYellow() {
        assertStateColor(ctrl.getYellowState(), TrafficLightColor.YELLOW);
    }
}
