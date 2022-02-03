package com.smartgwt.sample.showcase.client.basics.sounds;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.Progressbar;
import com.smartgwt.client.widgets.Sound;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.data.events.TimeChangedEvent;
import com.smartgwt.client.widgets.data.events.TimeChangedHandler;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AudioPlaybackSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This sample uses the Sound class to load and play " +
        "an audio sample. Click the control buttons to play, pause and reset the sample. Note how "+
        "the progress-bar indicates the current playback position of the sample."; 

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	AudioPlaybackSample panel = new AudioPlaybackSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    private String formatTime (double durationInSeconds) {
        if (durationInSeconds == 0) return "--:--";
        double minutes = Math.floor(durationInSeconds / 60);
        String minutesString = (minutes >= 10) ? String.valueOf(minutes) : "0" + minutes;
        double seconds = Math.floor(durationInSeconds % 60);
        String secondsString = (seconds >= 10) ? String.valueOf(seconds) : "0" + seconds;
        return minutesString + ":" + secondsString;
    };

    public Canvas getViewPanel() {
        final Progressbar progressbar = new Progressbar();
        progressbar.setBreadth(16);
        progressbar.setShowTitle(true);
		
        boolean audioIsSupported = Sound.isSupported();
		
        if (!audioIsSupported) SC.warn("Your browser does not support HTML5 Audio");
		
        final Sound sound = new Sound();
        sound.setSrc("audios/crescendo.wav");
        sound.setAutoLoad(true);
        sound.addTimeChangedHandler(new TimeChangedHandler() {
            @Override
            public void onTimeChanged(TimeChangedEvent event) {
                double currentTime = event.getCurrentTimeAsDouble();
                progressbar.setPercentDone(Integer.parseInt((Math.floor((currentTime * 100) / sound.getDuration()))+""));
                progressbar.setTitle(formatTime(currentTime) + " / " + formatTime(sound.getDuration()));
            }
        });
		
        HLayout hLayout = new HLayout();
        hLayout.setMembersMargin(10);
        hLayout.setWidth(320);
        hLayout.setHeight(1);
        hLayout.setDisabled(!audioIsSupported);
		
        IButton playButton = new IButton();
        playButton.setTitle("Play");
        playButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                sound.play();
            }
        });
        IButton pauseButton = new IButton();
        pauseButton.setTitle("Pause");
        pauseButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                sound.pause();
            }
        });
        IButton resetButton = new IButton();
        resetButton.setTitle("Reset");
        resetButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                sound.pause();
                sound.reset();
            }
        });
        hLayout.addMembers(playButton, pauseButton, resetButton);
		
        VStack vStack = new VStack();
        vStack.setIsGroup(true);
        vStack.setGroupTitle("Audio Playback");
        vStack.setWidth(430);
        vStack.setHeight(80);
        vStack.setMembersMargin(10);
        vStack.setLayoutMargin(20);
        vStack.setDefaultLayoutAlign(Alignment.CENTER);
        vStack.addMembers(progressbar, hLayout);

        return vStack;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}