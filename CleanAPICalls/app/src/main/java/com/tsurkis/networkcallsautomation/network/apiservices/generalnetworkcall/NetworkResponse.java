package com.tsurkis.networkcallsautomation.network.apiservices.generalnetworkcall;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.tsurkis.networkcallsautomation.App;
import com.tsurkis.networkcallsautomation.network.NetworkResponseListener;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by T.Surkis on 25-Aug-17.
 *
 * A wrapper class around the response to handle the data extraction and retrieval
 * to the requesting listener.
 */
class NetworkResponse<ResponseType> implements Callback<ResponseType> {
    private WeakReference<NetworkResponseListener<ResponseType>> listener;

    NetworkResponse(NetworkResponseListener<ResponseType> listener) {
        this.listener = new WeakReference<>(listener);
    }

    @Override
    public void onResponse(@NonNull Call<ResponseType> call, @NonNull Response<ResponseType> response) {
        if (listener.get() != null && listener != null) {
            listener.get().onResponseReceived(response.body());
        }
    }

    @Override
    public void onFailure(@NonNull Call<ResponseType> call, @NonNull Throwable t) {
        if (App.getInstance() != null) {
            Toast.makeText(
                    App.getInstance(),
                    "An error occurred: " + t.getMessage(),
                    Toast.LENGTH_SHORT
            ).show();
        }

        if (listener.get() != null && listener != null) {
            listener.get().onError();
        }
    }
}
