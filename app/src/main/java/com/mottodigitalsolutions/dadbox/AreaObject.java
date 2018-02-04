package com.mottodigitalsolutions.dadbox;

/**
 * Created by carlosblanco on 2/3/18.
 */

public class AreaObject {
    private int mGeniusId;
    private ChallengeObject mMainChallenge;
    private ChallengeObject mSecondaryChallenge;
    private ChallengeObject mBonusChallenge;

    public AreaObject(int geniusId,
                      ChallengeObject mainChallenge){
        mGeniusId = geniusId;
        mMainChallenge = mainChallenge;
    }


    public AreaObject(int geniusId,
                      ChallengeObject mainChallenge,
                      ChallengeObject secondaryChallenge,
                      ChallengeObject bonusChallenge){
        mGeniusId = geniusId;
        mMainChallenge = mainChallenge;
        mSecondaryChallenge = secondaryChallenge;
        mBonusChallenge = bonusChallenge;
    }

    public int getGeniusId(){
        return mGeniusId;
    }

    public ChallengeObject getMainChallenge(){
        return mMainChallenge;
    }

    public ChallengeObject getSecondaryChallenge(){
        return mSecondaryChallenge;
    }
    public ChallengeObject getBonusChallenge(){
        return mBonusChallenge;
    }


}
