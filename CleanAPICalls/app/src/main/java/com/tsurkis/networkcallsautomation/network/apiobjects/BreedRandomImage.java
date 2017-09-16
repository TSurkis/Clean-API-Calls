package com.tsurkis.networkcallsautomation.network.apiobjects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by T.Surkis on 12-Aug-17.
 *
 * An object response to the call: https://dog.ceo/api/breeds/image/random
 */
public class BreedRandomImage extends ApiObjectBase {

    @SerializedName("message")
    private String randomImageUrl;

    public BreedRandomImage(String status, String randomImageUrl) {
        super(status);
        this.randomImageUrl = randomImageUrl;
    }

    public String getRandomImageUrl() {
        return randomImageUrl;
    }
}
