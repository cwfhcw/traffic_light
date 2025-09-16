package trafficlight.states;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

class YellowStateTests {
    @Test
    void testYellowSelfTransitionPrevention() {
            System.out.println("------------------------------");
            System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
            System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        ctrl.setPreviousState(ctrl.getYellowState());
            ctrl.nextState();
        assertNotEquals(ctrl.getYellowState(), ctrl.getCurrentState());
    }

    @Test
    void testInvalidPreviousStateForYellow() {
            System.out.println("------------------------------");
            System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
            System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        ctrl.setPreviousState(ctrl.getOffState()); // Invalid previous state for Yellow
            ctrl.nextState();
        assertEquals(ctrl.getOffState(), ctrl.getCurrentState()); // Should fallback to OFF
    }

    @Test
    void testYellowFullCycleReturnsToYellow() {
            System.out.println("------------------------------");
            System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
            System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setPreviousState(ctrl.getRedState());
        ctrl.setCurrentState(ctrl.getYellowState());
            for (int i = 0; i < 4; i++) {
                ctrl.nextState();
            }
            assertEquals(ctrl.getYellowState(), ctrl.getCurrentState());
    }

    @Test
    void testYellowHalfCycleReturnsToYellow() {
            System.out.println("------------------------------");
            System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
            System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setPreviousState(ctrl.getRedState());
        ctrl.setCurrentState(ctrl.getYellowState());
            for (int i = 0; i < 2; i++) {
                ctrl.nextState();
            }
            assertEquals(ctrl.getYellowState(), ctrl.getCurrentState());
    }

    @Test
    void testYellowIsFollowedByRedWhenPrecededByGreen() {
            System.out.println("------------------------------");
            System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
            System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        ctrl.setPreviousState(ctrl.getGreenState());
            ctrl.nextState();
        assertEquals(ctrl.getRedState(), ctrl.getCurrentState());
    }

    @Test
    void testYellowIsFollowedByGreenWhenPrecededByRed() {
            System.out.println("------------------------------");
            System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
            System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        ctrl.setPreviousState(ctrl.getRedState());
            ctrl.nextState();
        assertEquals(ctrl.getGreenState(), ctrl.getCurrentState());
    }

    @Test
    void testYellowTurnsLightYellow() {
            System.out.println("------------------------------");
            System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
            System.out.println("------------------------------");
        TrafficLightCtrl ctrl = new TrafficLightCtrl();
        ctrl.setCurrentState(ctrl.getYellowState());
        assertEquals(TrafficLightColor.YELLOW, ctrl.getCurrentState().getState());
    }
}
