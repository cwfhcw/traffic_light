package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class RedState implements State {
    private static RedState instance;

    private RedState() {}

    public static RedState getInstance() {
        if (instance == null) {
            instance = new RedState();
            System.out.println("RedState instance created");
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
        return TrafficLightColor.RED;
    }
}
