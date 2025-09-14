package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class GreenState implements State {
    public void nextState(TrafficLightCtrl context) {
        context.setPreviousState(context.getCurrentState());
        context.setCurrentState(context.getYellowState());
    }
    public trafficlight.states.TrafficLightColor getState() {
        return TrafficLightColor.GREEN;
    }
}
