package com.tsurkis.networkcallsautomation.screens.main;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.tsurkis.networkcallsautomation.R;

public class MainActivity extends AppCompatActivity implements ViewContract.IView {
    private ViewContract.IPresenter presenter;

    private ImageView dogImageView;
    private Button downloadImageButton;
    private ProgressBar imageLoadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);

        dogImageView = find(R.id.random_dog_image_view);
        downloadImageButton = find(R.id.random_image_submit_button);
        imageLoadingProgressBar = find(R.id.image_loading_progress_bar);

        downloadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenter != null) {
                    presenter.onRandomImageButtonPressed();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    private <ViewType extends View> ViewType find(@IdRes int viewId) {
        return (ViewType) findViewById(viewId);
    }

    @Override
    public void showProgressBar() {
        downloadImageButton.setClickable(false);
        downloadImageButton.setText("Downloading...");
        imageLoadingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        downloadImageButton.setClickable(true);
        downloadImageButton.setText("Download");
        imageLoadingProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayImage(String imageUrl) {
        Glide.with(this).asBitmap().load(imageUrl).into(dogImageView);
    }
}
