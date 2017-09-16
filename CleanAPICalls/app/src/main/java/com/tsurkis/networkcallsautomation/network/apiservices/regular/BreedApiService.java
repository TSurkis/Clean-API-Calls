package com.tsurkis.networkcallsautomation.network.apiservices.regular;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.tsurkis.networkcallsautomation.App;
import com.tsurkis.networkcallsautomation.network.DogAPI;
import com.tsurkis.networkcallsautomation.network.NetworkResponseListener;
import com.tsurkis.networkcallsautomation.network.apiobjects.BreedRandomImage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by T.Surkis on 12-Aug-17.
 *
 * Manager of all breed related API calls.
 *
 * This class is an example of a regular Retrofit call.
 */
public class BreedApiService {

    public void requestRandomDogImage(final NetworkResponseListener<BreedRandomImage> listener, DogAPI api) {

        Call<BreedRandomImage> call = api.requestRandomDogImage();
        call.enqueue(new Callback<BreedRandomImage>() {
            @Override
            public void onResponse(@NonNull Call<BreedRandomImage> call, @NonNull Response<BreedRandomImage> response) {
                if (listener != null) {
                    listener.onResponseReceived(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<BreedRandomImage> call, @NonNull Throwable t) {
                if (App.getInstance() != null) {
                    Toast.makeText(
                            App.getInstance(),
                            "An error occurred: " + t.getMessage(),
                            Toast.LENGTH_SHORT
                    ).show();
                }

                if (listener != null) {
                    listener.onError();
                }
            }
        });
    }
}
