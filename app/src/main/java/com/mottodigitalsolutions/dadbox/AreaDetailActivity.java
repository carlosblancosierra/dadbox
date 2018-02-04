package com.mottodigitalsolutions.dadbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by carlosblanco on 2/3/18.
 */

public class AreaDetailActivity extends AppCompatActivity {

    @BindView(R.id.area_detail_genius) TextView geniusTextView;
    @BindView(R.id.area_detail_genius_description) TextView geniusDescriptionTextView;
    
    @BindView(R.id.area_detail_intelligence) TextView areaIntelligenceTextView;
    @BindView(R.id.area_detail_intelligence_description) TextView areaIntelligenceDescriptionTextView;
    
    @BindView(R.id.area_detail_challenge_main_name) TextView mainChallengeName;
    @BindView(R.id.area_detail_challenge_main_instrucctions) TextView mainChallengeInstructions;
    @BindView(R.id.area_detail_challenge_main_goal) TextView mainChallengeGoal;

    @BindView(R.id.area_detail_challenge_secondary_name) TextView secondaryChallengeName;
    @BindView(R.id.area_detail_challenge_secondary_instructionstions) TextView secondaryChallengeInstructions;
    @BindView(R.id.area_detail_challenge_secondary_goal) TextView secondaryChallengeGoal;

    @BindView(R.id.area_detail_challenge_bonus_name) TextView bonusChallengeName;
    @BindView(R.id.area_detail_challenge_bonus_instructions) TextView bonusChallengeInstructions;
    @BindView(R.id.area_detail_challenge_bonus_goal) TextView bonusChallengeGoal;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        int geniusID =
                intent.getIntExtra(getResources().getString(R.string.genius_id_key), 0);

        String genius =
                getResources().getStringArray(R.array.geniuses)[geniusID];
        String geniusDescription =
                getResources().getStringArray(R.array.geniuses_description)[geniusID];

        String intelligence =
                getResources().getStringArray(R.array.geniuses_intelligences)[geniusID];
        String intelligenceDescription =
                getResources().getStringArray(R.array.geniuses_intelligences_descriptions)[geniusID];

        ChallengeObject mainChallenge = (ChallengeObject)
                intent.getSerializableExtra(getResources().getString(R.string.challenge_main_key));

        ChallengeObject secondaryChallenge = (ChallengeObject)
                intent.getSerializableExtra(getResources().getString(R.string.challenge_secondary_key));

        ChallengeObject bonusChallenge = (ChallengeObject)
                intent.getSerializableExtra(getResources().getString(R.string.challenge_bonus_key));


        geniusTextView.setText(genius);
        geniusDescriptionTextView.setText(geniusDescription);

        areaIntelligenceTextView.setText(intelligence);
        areaIntelligenceDescriptionTextView.setText(intelligenceDescription);

        mainChallengeName.setText(mainChallenge.getName());
        mainChallengeInstructions.setText(mainChallenge.getInstructions());
        mainChallengeGoal.setText(mainChallenge.getGoal());

        secondaryChallengeName.setText(secondaryChallenge.getName());
        secondaryChallengeInstructions.setText(secondaryChallenge.getInstructions());
        secondaryChallengeGoal.setText(secondaryChallenge.getGoal());

        bonusChallengeName.setText(bonusChallenge.getName());
        bonusChallengeInstructions.setText(bonusChallenge.getInstructions());
        bonusChallengeGoal.setText(bonusChallenge.getGoal());

    }
}
