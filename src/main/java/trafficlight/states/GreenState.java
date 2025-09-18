package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class GreenState implements State {
    private static GreenState instance;
    private GreenState() {}

    public static GreenState getInstance() {
        if (instance == null) {
            instance = new GreenState();
        }
        return instance;
    }

    public void nextState(TrafficLightCtrl context) {
        context.setPreviousState(context.getCurrentState());
        context.setCurrentState(context.getYellowState());
    }
    public trafficlight.states.TrafficLightColor getState() {
        return TrafficLightColor.GREEN;
    }
}
