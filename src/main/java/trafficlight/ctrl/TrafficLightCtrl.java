package trafficlight.ctrl;

import trafficlight.gui.TrafficLightGui;
import trafficlight.states.State;


public class TrafficLightCtrl {

    private State offState;

    private State greenState;
    private State redState;
    private State yellowState;

    private State currentState;
    private State previousState;
    private TrafficLightGui gui;


    public TrafficLightCtrl() {
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setVisible(true);
    }

    private void initStates() {
    // Create states
    greenState = new trafficlight.states.GreenState();
    yellowState = new trafficlight.states.YellowState();
    redState = new trafficlight.states.RedState();
    offState = new trafficlight.states.OffState();
    // Set initial state
    currentState = offState;
    previousState = offState;

    }

    public State getOffState() {
        return offState;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getPreviousState() {
        return previousState;
    }

    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }

    public void run() {
        gui.run();
    }

    public void nextState() {
    // Advance to next state and update GUI
    currentState.nextState(this);
    gui.setLight(currentState.getState());
    System.out.println("Prev State: " + previousState.getState());
    System.out.println("Curr State: " + currentState.getState());
    System.out.println("----------------------------");

    
    }
}