package com.tsurkis.networkcallsautomation.screens.main;

/**
 * Created by T.Surkis on 09-Sep-17.
 */
interface ViewContract {
    interface IPresenter {
        void onRandomImageButtonPressed();
    }

    interface IView {
        void showProgressBar();

        void hideProgressBar();

        void displayImage(String imageUrl);
    }
}
