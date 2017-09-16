package com.tsurkis.networkcallsautomation.network;

/**
 * Created by T.Surkis on 25-Aug-17.
 *
 * General interface for receiving API responses.
 */
public interface NetworkResponseListener<Response> {

    void onResponseReceived(Response response);

    void onError();
}
