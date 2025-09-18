package trafficlight.states;

import trafficlight.ctrl.TrafficLightCtrl;

public class YellowState implements State {
    private static YellowState instance;

    private YellowState() {}

    public static YellowState getInstance() {
        if (instance == null) {
            instance = new YellowState();
            System.out.println("YellowState instance created");
        }
        return instance;
    }

    @Override
    public void nextState(TrafficLightCtrl context) {
        State prev = context.getPreviousState();
        context.setPreviousState(context.getCurrentState());
        if (prev == context.getRedState()) {
            context.setCurrentState(context.getGreenState());
        } else if (prev == context.getGreenState()) {
            context.setCurrentState(context.getRedState());
        }
    }

    @Override
    public trafficlight.states.TrafficLightColor getState() {
        return TrafficLightColor.YELLOW;
    }
}
