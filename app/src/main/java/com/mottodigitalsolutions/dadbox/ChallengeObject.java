package com.mottodigitalsolutions.dadbox;

import java.io.Serializable;

/**
 * Created by carlosblanco on 2/3/18.
 */

public class ChallengeObject implements Serializable {
    private String mName;
    private String mInstructions;
    private String mGoal;

    public ChallengeObject (String name,
                            String instructions,
                            String goal){
        mName = name;
        mInstructions = instructions;
        mGoal = goal;
    }

    public String getName(){
        return mName;
    }

    public String getInstructions(){
        return mInstructions;
    }

    public String getGoal(){
        return mGoal;
    }

}
