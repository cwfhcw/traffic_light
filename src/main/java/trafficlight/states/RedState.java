package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class RedState implements State {
    public static final RedState INSTANCE = new RedState();
    private RedState() {}

    public void nextState(TrafficLightCtrl context) {
        context.setPreviousState(context.getCurrentState());
        context.setCurrentState(context.getYellowState());
    }
    public trafficlight.states.TrafficLightColor getState() {
        return TrafficLightColor.RED;
    }
}
