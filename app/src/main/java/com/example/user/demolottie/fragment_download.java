package com.example.user.demolottie;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class fragment_download extends Fragment {


    @BindView(R.id.download_lottie_animation_view)
    LottieAnimationView mLottie;
    private Unbinder mUnbinder;

    public static Fragment newInstance(Context context) {
        return (fragment_download) fragment_download.instantiate(context, fragment_download.class.getName());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_download, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLottie.addAnimatorListener(new Animator.AnimatorListener() {
            @Override public void onAnimationStart(Animator animation) {
                Toast.makeText(getActivity(), "Downloading...", Toast.LENGTH_SHORT).show();
            }

            @Override public void onAnimationEnd(Animator animation) {
                Toast.makeText(getActivity(), "Finished lets cheer up..!", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).showEndFragment();
            }

            @Override public void onAnimationCancel(Animator animation) {
            }

            @Override public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        mLottie.cancelAnimation();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @OnClick(R.id.download_lottie_animation_view)
    public void onViewClicked() {
        mLottie.setProgress(0f);
        mLottie.playAnimation();
    }
}
