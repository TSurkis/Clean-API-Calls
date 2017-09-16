package com.tsurkis.networkcallsautomation.screens.main;

import com.tsurkis.networkcallsautomation.network.NetworkManager;
import com.tsurkis.networkcallsautomation.network.NetworkResponseListener;
import com.tsurkis.networkcallsautomation.network.apiobjects.BreedRandomImage;

import java.lang.ref.WeakReference;

/**
 * Created by T.Surkis on 09-Sep-17.
 */
class Presenter implements ViewContract.IPresenter {
    private WeakReference<ViewContract.IView> view;

    Presenter(ViewContract.IView view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void onRandomImageButtonPressed() {
        if (view.get() != null && view != null) {
            view.get().showProgressBar();
        }
        NetworkManager.getInstance().requestRandomDogImage(new NetworkResponseListener<BreedRandomImage>() {
            @Override
            public void onResponseReceived(BreedRandomImage s) {
                if (view.get() != null && view != null && s != null) {
                    view.get().hideProgressBar();
                    view.get().displayImage(s.getRandomImageUrl());
                } else {
                    view.get().hideProgressBar();
                }
            }

            @Override
            public void onError() {
                view.get().hideProgressBar();
            }
        });
    }
}
