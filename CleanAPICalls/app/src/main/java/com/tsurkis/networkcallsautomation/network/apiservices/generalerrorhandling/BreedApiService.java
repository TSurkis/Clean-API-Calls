package com.tsurkis.networkcallsautomation.network.apiservices.generalerrorhandling;

import android.support.annotation.NonNull;

import com.tsurkis.networkcallsautomation.network.DogAPI;
import com.tsurkis.networkcallsautomation.network.NetworkResponseListener;
import com.tsurkis.networkcallsautomation.network.apiobjects.BreedRandomImage;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by T.Surkis on 12-Aug-17.
 *
 * Manager of all breed related API calls.
 *
 * This class is an example of a class that only handles the retrieval of data.
 * Any error is handled by the NetworkResponse class.
 */
public class BreedApiService {

    public void requestRandomDogImage(final NetworkResponseListener<BreedRandomImage> listener, DogAPI api) {
        api.requestRandomDogImage().enqueue(new NetworkResponse<BreedRandomImage>(listener) {
            @Override
            public void onResponse(@NonNull Call<BreedRandomImage> call, @NonNull Response<BreedRandomImage> response) {
                if (listener != null) {
                    listener.onResponseReceived(response.body());
                }
            }
        });
    }
}
