package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class GreenState implements State {
    private static GreenState instance;

    private GreenState() {}

    public static GreenState getInstance() {
        if (instance == null) {
            instance = new GreenState();
            System.out.println("GreenState instance created");
        }
        return instance;
    }

    @Override
    public void nextState(TrafficLightCtrl context) {
        context.setPreviousState(context.getCurrentState());
        context.setCurrentState(context.getYellowState());
    }

    @Override
    public trafficlight.states.TrafficLightColor getState() {
        return TrafficLightColor.GREEN;
    }
}
