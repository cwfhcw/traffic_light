package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class OffState implements State {
    private static OffState instance;
    private OffState() {}

    public void nextState(TrafficLightCtrl context) {
        context.setPreviousState(context.getCurrentState());
        context.setCurrentState(context.getRedState());
    }
    public TrafficLightColor getState() {
        return TrafficLightColor.OFF;
    }
    
    public static OffState getInstance() {
        if (instance == null) {
            instance = new OffState();
        }
        return instance;
    }
}
