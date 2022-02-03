package com.smartgwt.sample.showcase.client.other;

import com.google.gwt.user.client.Timer;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Progressbar;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ProgressBarSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "Demonstration of ProgressBar.";
    
    private int hBar1Value;
    private int hBar2Value;

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ProgressBarSample panel = new ProgressBarSample();
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

    public Canvas getViewPanel() {
                    
        VLayout horizontalBars = new VLayout(4);
        horizontalBars.setWidth(300);

        
        final Label hBar1Label = new Label("Current File Progress");
        hBar1Label.setHeight(16);
        horizontalBars.addMember(hBar1Label);
        
        final Progressbar hBar1 = new Progressbar();
        hBar1.setHeight(24);
        hBar1.setVertical(false);
        horizontalBars.addMember(hBar1);
        
        final Label hBar2Label = new Label("Total Progress");
        hBar2Label.setHeight(16);
        horizontalBars.addMember(hBar2Label);

        final Progressbar hBar2 = new Progressbar();
        hBar2.setVertical(false);
        hBar2.setHeight(24);
        horizontalBars.addMember(hBar2);    

        
        final IButton buttonStart = new IButton("Start Demo");
        buttonStart.setAutoFit(true);
        buttonStart.addClickHandler(new ClickHandler(){
            public void onClick(ClickEvent event) {
                buttonStart.setDisabled(true);
                hBar1Value = 0;
                hBar2Value = 0;
                hBar1.setPercentDone(hBar1Value);
                hBar1Label.setContents("Current File Progress");
                hBar2.setPercentDone(hBar2Value);
                hBar2Label.setContents("Total Progress");

                new Timer() {
                    public void run() {
                        hBar1Value += 1 + (int) (10 * Math.random());
                        if (hBar1Value > 100) {
                            
                            hBar1Value = 0;
                            hBar2Value += 1 + (int) (5 * Math.random());
                            if (hBar2Value >= 100)
                                hBar1Value = hBar2Value = 100;
                            
                            hBar2.setPercentDone(hBar2Value);
                            hBar2Label.setContents("Total Progress: "+hBar2Value+"%");
                        }
                        hBar1.setPercentDone(hBar1Value);
                        hBar1Label.setContents("Current File Progress: "+hBar1Value+"%");
           
                        if(hBar2Value!=100)
                            schedule(5 + (int) (50 * Math.random()));
                        else
                            buttonStart.setDisabled(false);
                    }
                }.schedule(50);
            }
        });
        
        HLayout buttonCanvas = new HLayout();
        buttonCanvas.setMargin(10);
        buttonCanvas.addMember(buttonStart);

        horizontalBars.addMember(buttonCanvas);           
        
        Canvas canvas = new Canvas();
        canvas.addChild(horizontalBars);
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}