package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class OffState implements State {
    public static final OffState INSTANCE = new OffState();
    private OffState() {}

    public void nextState(TrafficLightCtrl context) {
        context.setPreviousState(context.getCurrentState());
        context.setCurrentState(context.getRedState());
    }
    public TrafficLightColor getState() {
        return TrafficLightColor.OFF;
    }
}
