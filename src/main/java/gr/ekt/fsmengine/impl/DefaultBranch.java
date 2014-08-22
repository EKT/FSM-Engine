package gr.ekt.fsmengine.impl;

import gr.ekt.fsmengine.api.Branch;
import gr.ekt.fsmengine.api.StateContext;
import gr.ekt.fsmengine.api.Transition;

import java.util.List;
import java.util.Collections;

/**
 * @author Dimitris Zavaliadis
 */
public class DefaultBranch implements Branch {

    private List<Transition> possibleTransitions;

    public List<Transition> getPossibleTransitions() {
        if(possibleTransitions == null) {
            return Collections.emptyList();
        }
        return possibleTransitions;
    }

    public void setPossibleTransitions(List<Transition> possibleTransitions) {
        this.possibleTransitions = possibleTransitions;
    }

    public void execute(StateContext stateContext) {
        for(Transition transition : getPossibleTransitions()) {
            transition.execute(stateContext);
        }
    }
}
