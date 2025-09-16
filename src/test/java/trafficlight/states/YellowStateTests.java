package trafficlight.states;

import org.junit.jupiter.api.Test;

class YellowStateTests extends AbstractStateTests {


    @Test
    void testYellowIsFollowedByGreenWhenPrecededByRed() {
    assertCycle(ctrl.getYellowState(),ctrl.getRedState(), 1, ctrl.getGreenState());
    }

    @Test
    void testYellowIsFollowedByRedWhenPrecededByGreen() {
    assertCycle(ctrl.getYellowState(),ctrl.getGreenState(), 1, ctrl.getRedState());
    }
    
    @Test
    void testYellowHalfCycleReturnsToYellow() {
    assertCycle(ctrl.getYellowState(), ctrl.getRedState(), 2, ctrl.getYellowState());
    }

    @Test
    void testYellowFullCycleReturnsToYellow() {
    assertCycle(ctrl.getYellowState(), ctrl.getRedState(), 4, ctrl.getYellowState());
    }

    @Test
    void testYellowTurnsLightYellow() {
        assertStateColor(ctrl.getYellowState(), TrafficLightColor.YELLOW);
    }
}
