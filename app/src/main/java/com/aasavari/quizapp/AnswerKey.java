package com.aasavari.quizapp;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import static android.media.CamcorderProfile.get;

/**
 * Created by Aasavari on 2/14/2017.
 */

public class AnswerKey {

    private Map<Integer, String> map = new HashMap<>();


    public AnswerKey(Context c){
        //we create a hash-map in the constructor of this utility class that maps the correct button id
        // with the correct answer string.
        map.put(R.id.rb3grp1, c.getString(R.string.sac));
        map.put(R.id.rb2grp2, c.getString(R.string.alb));
        map.put(R.id.rb1grp3, c.getString(R.string.aus));
        map.put(R.id.check2Q4, c.getString(R.string.missi));
        map.put(R.id.check4Q4, c.getString(R.string.potomac));
        map.put(R.id.check1Q5, c.getString(R.string.rockies));
        map.put(R.id.check3Q5, c.getString(R.string.cascades));
        map.put(R.id.check3Q6, c.getString(R.string.liberty));
        map.put(R.id.check4Q6, c.getString(R.string.ggate));
        map.put(R.id.editOne, c.getString(R.string.alaska));
        map.put(R.id.editTwo, c.getString(R.string.hawaii));
    }

    public Boolean IsRightAnswer(int id, String key){

        String answer =  map.get(id);
        if (answer.equals(key))
            return true;
        else
             return false;
    }

}

