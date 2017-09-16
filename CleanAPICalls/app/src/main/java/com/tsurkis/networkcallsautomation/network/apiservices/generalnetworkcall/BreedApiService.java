package com.tsurkis.networkcallsautomation.network.apiservices.generalnetworkcall;

import com.tsurkis.networkcallsautomation.network.DogAPI;
import com.tsurkis.networkcallsautomation.network.NetworkResponseListener;
import com.tsurkis.networkcallsautomation.network.apiobjects.BreedRandomImage;

/**
 * Created by T.Surkis on 12-Aug-17.
 *
 * Manager of all breed related API calls.
 *
 * This class is an example of a class that lets the NetworkResponse object handle the
 * retrieval of data and errors.
 */
public class BreedApiService {

    public void requestRandomDogImage(NetworkResponseListener<BreedRandomImage> listener, DogAPI api) {
        api.requestRandomDogImage().enqueue(new NetworkResponse<>(listener));
    }
}
