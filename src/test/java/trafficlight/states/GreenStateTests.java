package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class GreenStateTests {
    @Test
    void testGreenSelfTransitionPrevention() {
        System.out.println("------------------------------");
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getGreenState());
        ctrl.setPreviousState(ctrl.getGreenState());
        ctrl.nextState();
        assertNotEquals(ctrl.getGreenState(), ctrl.getCurrentState());
    }

    @Test
    void testGreenFullCycleReturnsToGreen() {
        System.out.println("------------------------------");
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getGreenState());
        for (int i = 0; i < 4; i++) {
            ctrl.nextState();
        }
        assertEquals(ctrl.getGreenState(), ctrl.getCurrentState());
    }

    @Test
    void testGreenIsFollowedByYellow() {
        System.out.println("------------------------------");
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getGreenState());
        ctrl.nextState();
        assertEquals(ctrl.getYellowState(), ctrl.getCurrentState());
    }

    @Test
    void testGreenTurnsLightGreen() {
        System.out.println("------------------------------");
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getGreenState());
        assertEquals(TrafficLightColor.GREEN, ctrl.getCurrentState().getState());
    }
}
