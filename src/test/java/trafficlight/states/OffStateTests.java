package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class OffStateTests {
    @Test
    void testOffSelfTransitionAllowed() {
        System.out.println("------------------------------");
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getOffState());
        ctrl.setPreviousState(ctrl.getOffState());
        ctrl.nextState();
        assertEquals(ctrl.getOffState(), ctrl.getPreviousState());
    }

    @Test
    void testOffIsFollowedByRed() {
        System.out.println("------------------------------");
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getOffState());
        ctrl.nextState();
        assertEquals(ctrl.getRedState(), ctrl.getCurrentState());
    }

    @Test
    void testOffTurnsLightOff() {
        System.out.println("------------------------------");
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getOffState());
        assertEquals(TrafficLightColor.OFF, ctrl.getCurrentState().getState());
    }
}