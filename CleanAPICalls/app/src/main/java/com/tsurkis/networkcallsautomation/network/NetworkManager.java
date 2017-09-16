package com.tsurkis.networkcallsautomation.network;

import com.tsurkis.networkcallsautomation.network.apiobjects.BreedRandomImage;
import com.tsurkis.networkcallsautomation.network.apiservices.generalnetworkcall.BreedApiService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by T.Surkis on 12-Aug-17.
 */
public class NetworkManager {
    private static final NetworkManager instance = new NetworkManager();
    private final DogAPI api;

    private final BreedApiService breedApiService;

    private NetworkManager() {
        Retrofit retrofitCore =
                new Retrofit
                        .Builder()
                        .baseUrl("https://dog.ceo/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient())
                        .build();

        api = retrofitCore.create(DogAPI.class);

        breedApiService = new BreedApiService();
    }

    public static NetworkManager getInstance() {
        return instance;
    }

    public void requestRandomDogImage(NetworkResponseListener<BreedRandomImage> listener) {
        breedApiService.requestRandomDogImage(listener, api);
    }
}
