package com.smartgwt.sample.showcase.client.effects.animation;

import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AnimateComplexSequenceSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "Click to select and zoom each piece.";
    
    protected ZoomImg zoomedObject = null;

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            AnimateComplexSequenceSample panel = new AnimateComplexSequenceSample();
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
        VLayout layout = new VLayout();
        layout.setMembersMargin(10);
        layout.addChild(new ZoomImg(this, 0, "cube_blue.png"));
        layout.addChild(new ZoomImg(this, 100, "pawn_yellow.png"));
        layout.addChild(new ZoomImg(this, 200, "piece_green.png"));
        return layout;
    }

    public static class ZoomImg extends Img {
        private AnimateComplexSequenceSample sample;
        private int zoomTime;
        private int shrinkTime;
        private Integer originalLeft = null;

        public ZoomImg(final AnimateComplexSequenceSample sample, int left, String src) {
            final ZoomImg _this = this;
            this.sample = sample;
            setLeft(left);
            setSrc(src);
            setWidth(48);
            setHeight(48);
            setAppImgDir("pieces/48/");
            zoomTime = 1000;
            shrinkTime = 300;
            addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {
                    // remember original position
                    if (originalLeft == null)
                        originalLeft = getLeft();
                    if (sample.zoomedObject == null) { // nothing expanded, so just expand
                        zoom();
                    } else if (_this.equals(sample.zoomedObject)) { // already expanded, so just shrink
                        shrink();
                        sample.zoomedObject = null;
                    } else { // another object is expanded; shrink it and then expand this object
                        sample.zoomedObject.shrink(new AnimationCallback() {
                            public void execute(boolean earlyFinish) {
                                zoom();
                            }
                        });
                    }
                }
            });
        }

        public void zoom() {
            animateRect(25, 100, 200, 200, null, zoomTime);
            sample.zoomedObject = this;
        }

        public void shrink() {
            shrink(null);
        }

        public void shrink(AnimationCallback postShrinkScript) {
            animateRect(originalLeft, 0, 48, 48, postShrinkScript, shrinkTime);
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}