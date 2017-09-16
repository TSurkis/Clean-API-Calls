package com.tsurkis.networkcallsautomation.network;

import com.tsurkis.networkcallsautomation.network.apiobjects.BreedRandomImage;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by T.Surkis on 12-Aug-17.
 * <p>
 * This API represents an API found on the website:
 * https://dog.ceo/dog-api/
 */
public interface DogAPI {

    @GET("breeds/image/random")
    Call<BreedRandomImage> requestRandomDogImage();
}
