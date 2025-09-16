package trafficlight.states;

import org.junit.jupiter.api.Test;

class OffStateTests extends AbstractStateTests {

    @Test
    void testOffIsFollowedByRed() {
        assertCycle(ctrl.getOffState(), ctrl.getOffState(), 1, ctrl.getRedState());
    }

    @Test
    void testOffTurnsLightOff() {
        assertStateColor(ctrl.getOffState(), TrafficLightColor.OFF);
    }
}
