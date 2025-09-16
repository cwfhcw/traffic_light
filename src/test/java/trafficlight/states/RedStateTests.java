package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class RedStateTests {
    @Test
    void testRedSelfTransitionPrevention() {
        System.out.println("------------------------------");
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getRedState());
        ctrl.setPreviousState(ctrl.getRedState());
        ctrl.nextState();
        assertNotEquals(ctrl.getRedState(), ctrl.getCurrentState());
    }

    @Test
    void testRedFullCycleReturnsToRed() {
        System.out.println("------------------------------");
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getRedState());
        for (int i = 0; i < 4; i++) {
            ctrl.nextState();
        }
        assertEquals(ctrl.getRedState(), ctrl.getCurrentState());
    }

    @Test
    void testRedIsFollowedByYellow() {
        System.out.println("------------------------------");
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getRedState());
        ctrl.nextState();
        assertEquals(ctrl.getYellowState(), ctrl.getCurrentState());
    }

    @Test
    void testRedTurnsLightRed() {
        System.out.println("------------------------------");
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getRedState());
        assertEquals(TrafficLightColor.RED, ctrl.getCurrentState().getState());
    }
}
