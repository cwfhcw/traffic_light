package trafficlight.states;

import org.junit.jupiter.api.Test;

class RedStateIntegrationTest extends AbstractStateIntegrationTest {

    @Test
    void is_red_followed_by_yellow_in_traffic_light_cycle() {
        assertCycle(ctrl.getYellowState(), ctrl.getRedState(), 1, ctrl.getYellowState());
    }

    @Test
    void does_full_cycle_beginning_with_red_return_to_red() {
        assertCycle(ctrl.getYellowState(), ctrl.getRedState(), 4, ctrl.getRedState());
    }

    @Test
    void does_red_turn_light_red_in_gui() {
        assertStateColor(ctrl.getRedState(), TrafficLightColor.RED);
    }
}
