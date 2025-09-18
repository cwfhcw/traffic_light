package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class OffState implements State {
    private static OffState instance;

    private OffState() {}

    public static OffState getInstance() {
        if (instance == null) {
            instance = new OffState();
            System.out.println("OffState instance created");
        }
        return instance;
    }

    @Override
    public void nextState(TrafficLightCtrl context) {
        context.setPreviousState(context.getCurrentState());
        context.setCurrentState(context.getRedState());
    }

    @Override
    public TrafficLightColor getState() {
        return TrafficLightColor.OFF;
    }
}
