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

    public static ArrayList<AreaObject> getAreaObjects (String JsonResponse){
        ArrayList<AreaObject> areaObjectArrayList = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(JsonResponse);
            JSONArray areas = root.getJSONArray("areas");

            for (int i = 0; i < areas.length(); i++){
                JSONObject areaObject = areas.getJSONObject(i);

                String geniusId = areaObject.getString("genius_id");

                JSONObject mainChallengeJsonObject = areaObject.getJSONObject("challenge_main");

                String mainChallengeName = mainChallengeJsonObject.getString("name");
                String mainChallengeInstructions = mainChallengeJsonObject.getString("instructions");
                String mainChallengeGoal = mainChallengeJsonObject.getString("goal");

                ChallengeObject mainChallenge = new ChallengeObject(
                        mainChallengeName,
                        mainChallengeInstructions,
                        mainChallengeGoal);

                areaObjectArrayList.add(new AreaObject(
                        Integer.valueOf(geniusId),
                        mainChallenge
                ));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return areaObjectArrayList;
    }

}
