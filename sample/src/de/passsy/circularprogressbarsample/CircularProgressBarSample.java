package de.passsy.circularprogressbarsample;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.passsy.holocircularprogressbar.HoloCircularProgressBar;

/**
 * The Class CircularProgressBarSample.
 * 
 * @author Pascal Welsch
 * @since 05.03.2013
 */
public class CircularProgressBarSample extends Activity {

	/**
	 * The Switch button.
	 */
	private Button mSwitchButton;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		if (getIntent() != null) {
			final Bundle extras = getIntent().getExtras();
			if (extras != null) {
				final int theme = extras.getInt("theme");
				if (theme != 0) {
					setTheme(theme);
				}
			}
		}

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		mSwitchButton = (Button) findViewById(R.id.switch_theme);
		mSwitchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(final View v) {
				switchTheme();
			}
		});

		final HoloCircularProgressBar progress = (HoloCircularProgressBar) findViewById(R.id.holoCircularProgressBar1);
		animate(progress, new AnimatorListener() {

			@Override
			public void onAnimationCancel(final Animator animation) {
			}

			@Override
			public void onAnimationEnd(final Animator animation) {
				animate(progress, this);
			}

			@Override
			public void onAnimationRepeat(final Animator animation) {
			}

			@Override
			public void onAnimationStart(final Animator animation) {
			}
		});
	}

	/**
	 * Animate.
	 * 
	 * @param progressBar
	 *            the progress bar
	 * @param listener
	 *            the listener
	 */
	private void animate(final HoloCircularProgressBar progressBar, final AnimatorListener listener) {
		final float progress = (float) (Math.random() * 2);
		final ObjectAnimator progressBarAnimator = ObjectAnimator.ofFloat(progressBar, "progress", progress);
		progressBarAnimator.setDuration(3000);

		progressBarAnimator.addListener(new AnimatorListener() {

			@Override
			public void onAnimationCancel(final Animator animation) {
			}

			@Override
			public void onAnimationEnd(final Animator animation) {
				progressBar.setProgress(progress);
			}

			@Override
			public void onAnimationRepeat(final Animator animation) {
			}

			@Override
			public void onAnimationStart(final Animator animation) {
			}
		});
		progressBarAnimator.addListener(listener);
		progressBarAnimator.reverse();
		progressBarAnimator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(final ValueAnimator animation) {
				progressBar.setProgress((Float) animation.getAnimatedValue());
			}
		});
		progressBar.setMarkerProgress(progress);
		progressBarAnimator.start();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.circular_progress_bar_sample, menu);
		return true;
	}

	/**
	 * Switch theme.
	 */
	public void switchTheme() {

		final Intent intent = getIntent();
		final Bundle extras = getIntent().getExtras();
		if (extras != null) {
			final int theme = extras.getInt("theme", -1);
			if (theme == R.style.AppThemeLight) {
				getIntent().removeExtra("theme");
			} else {
				intent.putExtra("theme", R.style.AppThemeLight);
			}
		} else {
			intent.putExtra("theme", R.style.AppThemeLight);
		}
		finish();
		startActivity(intent);
	}

}
