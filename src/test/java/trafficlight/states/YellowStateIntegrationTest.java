package trafficlight.states;

import org.junit.jupiter.api.Test;

class YellowStateIntegrationTest extends AbstractStateIntegrationTest {

    @Test
    void is_yellow_followed_by_green_when_preceded_by_red_in_traffic_light_cycle() {
        assertCycle(ctrl.getRedState(), ctrl.getYellowState(), 1, ctrl.getGreenState());
    }

    @Test
    void is_yellow_followed_by_red_when_preceded_by_green_in_traffic_light_cycle() {
        assertCycle(ctrl.getGreenState(), ctrl.getYellowState(), 1, ctrl.getRedState());
    }

    @Test
    void does_yellow_half_cycle_return_to_yellow() {
        assertCycle(ctrl.getRedState(), ctrl.getYellowState(), 2, ctrl.getYellowState());
    }

    @Test
    void does_yellow_full_cycle_return_to_yellow() {
        assertCycle(ctrl.getRedState(), ctrl.getYellowState(), 4, ctrl.getYellowState());
    }

    @Test
    void does_yellow_turn_light_yellow_in_gui() {
        assertStateColor(ctrl.getYellowState(), TrafficLightColor.YELLOW);
    }
}
