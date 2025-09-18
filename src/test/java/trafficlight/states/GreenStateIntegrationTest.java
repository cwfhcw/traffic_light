package trafficlight.states;

import org.junit.jupiter.api.Test;

class GreenStateIntegrationTest extends AbstractStateIntegrationTest {

    @Test
    void is_green_followed_by_yellow_in_traffic_light_cycle() {
        assertCycle(ctrl.getYellowState(), ctrl.getGreenState(), 1, ctrl.getYellowState());
    }

    @Test
    void does_full_cycle_beginning_with_green_return_to_green() {
        assertCycle(ctrl.getYellowState(), ctrl.getGreenState(), 1, ctrl.getYellowState());
    }

    @Test
    void does_green_turn_light_green_in_gui() {
        assertStateColor(ctrl.getGreenState(), TrafficLightColor.GREEN);
    }
}
