package com.mottodigitalsolutions.dadbox.Utils;

import com.mottodigitalsolutions.dadbox.AreaObject;
import com.mottodigitalsolutions.dadbox.ChallengeObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by carlosblanco on 2/3/18.
 */

public class AreaJsonUtil {
    private static String LOG_TAG = AreaJsonUtil.class.getSimpleName();

    public static ArrayList<AreaObject> getAreaObjects(String JsonResponse) {
        ArrayList<AreaObject> areaObjectArrayList = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(JsonResponse);
            JSONArray areas = root.getJSONArray("areas");

            for (int i = 0; i < areas.length(); i++) {
                JSONObject areaObject = areas.getJSONObject(i);

                String geniusId = areaObject.getString("genius_id");


//                main challenge
                JSONObject mainChallengeJsonObject = areaObject.getJSONObject("challenge_main");

                String mainChallengeName = mainChallengeJsonObject.getString("name");
                String mainChallengeInstructions = mainChallengeJsonObject.getString("instructions");
                String mainChallengeGoal = mainChallengeJsonObject.getString("goal");

                ChallengeObject mainChallenge = new ChallengeObject(
                        mainChallengeName,
                        mainChallengeInstructions,
                        mainChallengeGoal);

//                secondary challenge
                JSONObject secondaryChallengeJsonObject = areaObject.getJSONObject("challenge_secondary");

                String secondaryChallengeName = secondaryChallengeJsonObject.getString("name");
                String secondaryChallengeInstructions = secondaryChallengeJsonObject.getString("instructions");
                String secondaryChallengeGoal = secondaryChallengeJsonObject.getString("goal");

                ChallengeObject secondaryChallenge = new ChallengeObject(
                        secondaryChallengeName,
                        secondaryChallengeInstructions,
                        secondaryChallengeGoal);

//                bonus challenge
                JSONObject bonusChallengeJsonObject = areaObject.getJSONObject("challenge_bonus");

                String bonusChallengeName = bonusChallengeJsonObject.getString("name");
                String bonusChallengeInstructions = bonusChallengeJsonObject.getString("instructions");
                String bonusChallengeGoal = bonusChallengeJsonObject.getString("goal");

                ChallengeObject bonusChallenge = new ChallengeObject(
                        bonusChallengeName,
                        bonusChallengeInstructions,
                        bonusChallengeGoal);

                areaObjectArrayList.add(new AreaObject(
                        Integer.valueOf(geniusId),
                        mainChallenge,
                        secondaryChallenge,
                        bonusChallenge
                ));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return areaObjectArrayList;
    }

}
