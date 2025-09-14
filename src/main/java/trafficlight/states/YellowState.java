package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class YellowState implements State {
    public void nextState(TrafficLightCtrl context) {
        State prev = context.getPreviousState();
        context.setPreviousState(context.getCurrentState());
        if (prev == context.getRedState()) {
            context.setCurrentState(context.getGreenState());
        } else {
            context.setCurrentState(context.getRedState());
        }
    }
    public trafficlight.states.TrafficLightColor getState() {
        return TrafficLightColor.YELLOW;
    }
}
