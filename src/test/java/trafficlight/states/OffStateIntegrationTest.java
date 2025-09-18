package trafficlight.states;

import org.junit.jupiter.api.Test;

class OffStateIntegrationTest extends AbstractStateIntegrationTest {

    @Test
    void is_off_followed_by_red_in_traffic_light_cycle() {
        assertCycle(ctrl.getOffState(), ctrl.getOffState(), 1, ctrl.getRedState());
    }

    @Test
    void does_off_turn_light_turn_off_in_gui() {
        assertStateColor(ctrl.getOffState(), TrafficLightColor.OFF);
    }
}
