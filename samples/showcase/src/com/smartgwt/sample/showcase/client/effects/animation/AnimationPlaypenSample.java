package com.smartgwt.sample.showcase.client.effects.animation;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.AnimationCallback;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Slider;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DragRepositionStopEvent;
import com.smartgwt.client.widgets.events.DragRepositionStopHandler;
import com.smartgwt.client.widgets.events.DragResizeStopEvent;
import com.smartgwt.client.widgets.events.DragResizeStopHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AnimationPlaypenSample extends ShowcasePanel {

    private static final String DESCRIPTION = null;

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            AnimationPlaypenSample panel = new AnimationPlaypenSample();
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
        Canvas canvas = new Canvas();
        canvas.setWidth100();
        canvas.setHeight100();
        
        final Canvas dest = new Canvas();
        dest.setOverflow(Overflow.HIDDEN);
        dest.setAlign(Alignment.CENTER);
        dest.setShowEdges(true);
        dest.setEdgeSize(5);
        dest.setBackgroundColor("#FFFF88");
        dest.setCanDragReposition(true);
        dest.setCanDragResize(true);
        dest.setDragAppearance(DragAppearance.TARGET);
        dest.setContents("<b>Destination</b> (drag to move or resize)");
        dest.setLeft(400);
        dest.setTop(250);
        dest.setWidth(200);
        dest.setHeight(200);

        dest.addDragRepositionStopHandler(new DragRepositionStopHandler() {
            public void onDragRepositionStop(DragRepositionStopEvent event) {
                dest.sendToBack();
            }
        });

        dest.addDragResizeStopHandler(new DragResizeStopHandler() {
            public void onDragResizeStop(DragResizeStopEvent event) {
                dest.sendToBack();
            }
        });
        canvas.addChild(dest);

        final Canvas anim = new Canvas();
        anim.setOverflow(Overflow.HIDDEN);
        anim.setBorder("1px solid #6a6a6a");
        anim.setBackgroundColor("#C3D9FF");
        anim.setCanDragReposition(true);
        anim.setCanDragResize(true);
        anim.setDragAppearance(DragAppearance.TARGET);
        anim.setSmoothFade(true);
        anim.setContents("1<br>2<br>3<br><b>Animated Object</b> (drag to move or resize)<br>3<br>2<br>1");
        anim.setLeft(100);
        anim.setTop(250);
        anim.setWidth(100);
        anim.setHeight(100);
        canvas.addChild(anim);

        String numberStackHTML = "0";
        for (int i = 1; i < 100; i++) {
            numberStackHTML += "<br>" + i;
        }

        final HTMLPane scroller = new HTMLPane();
        scroller.setShowEdges(true);
        scroller.setEdgeSize(5);
        scroller.setCanDragReposition(true);
        scroller.setCanDragResize(true);
        scroller.setDragAppearance(DragAppearance.TARGET);
        scroller.setContents(numberStackHTML);
        scroller.setLeft(640);
        scroller.setTop(10);
        scroller.setWidth(100);
        scroller.setHeight(160);
        canvas.addChild(scroller);

        final Slider timeSlider = new Slider();
        timeSlider.setLeft(20);
        timeSlider.setTop(0);
        timeSlider.setVertical(false);
        timeSlider.setValue(1000);
        timeSlider.setMinValue(250);
        timeSlider.setMaxValue(4000);
        timeSlider.setNumValues(16);
        timeSlider.setTitle("Duration (ms)");
        timeSlider.setAnimateThumb(true);
        timeSlider.setAnimateThumbInit(true);
        canvas.addChild(timeSlider);

        IButton reset = new IButton("<b>Reset</b>");
        reset.setWidth(110);
        reset.setLeft(265);
        reset.setTop(180);
        reset.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                anim.setRect(100, 250, 100, 100);
                anim.setOpacity(100);
                anim.scrollTo(0, 0);
                anim.show();
                dest.setRect(400, 250, 200, 200);
                scroller.setRect(640, 10, 100, 160);
                scroller.scrollTo(0, 0);
            }
        });
        canvas.addChild(reset);

        VStack vStackButtons = new VStack();
        vStackButtons.setMembersMargin(5);
        vStackButtons.setHeight(60);
        vStackButtons.setLeft(20);
        vStackButtons.setTop(80);

        HStack hStackButtons1 = new HStack();
        hStackButtons1.setHeight(30);
        hStackButtons1.setMembersMargin(12);

        HStack hStackButtons2 = new HStack();
        hStackButtons2.setMembersMargin(12);
        hStackButtons2.setHeight(30);
        
        vStackButtons.addMember(hStackButtons1);
        vStackButtons.addMember(hStackButtons2);
        
        IButton move = new IButton("Move");
        move.setWidth(110);
        move.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                anim.animateMove(dest.getLeft(), dest.getTop(), null, (int) timeSlider.getValue());
            }
        });
        hStackButtons1.addMember(move);

        IButton resize = new IButton("Resize");
        resize.setWidth(110);
        resize.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                anim.animateResize(dest.getLeft(), dest.getTop(), null, (int) timeSlider.getValue());
            }
        });
        hStackButtons2.addMember(resize);

        IButton moveResize = new IButton("Move &amp; Resize");
        moveResize.setWidth(110);
        moveResize.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                anim.animateRect(dest.getLeft(), dest.getTop(), dest.getWidth(), dest.getHeight(), null, (int) timeSlider.getValue());
            }
        });
        hStackButtons1.addMember(moveResize);

        IButton moveFollowedByResize = new IButton("Move, Resize");
        moveFollowedByResize.setWidth(110);
        moveFollowedByResize.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                anim.animateMove(dest.getLeft(), dest.getTop(), new AnimationCallback() {
                    public void execute(boolean earlyFinish) {
                        anim.animateResize(dest.getWidth(), dest.getHeight(), null, (int) timeSlider.getValue());
                    }
                }, (int) timeSlider.getValue());
            }
        });
        hStackButtons2.addMember(moveFollowedByResize);

        IButton fadeOut = new IButton("Fade Out");
        fadeOut.setWidth(110);
        fadeOut.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                anim.animateHide(AnimationEffect.FADE, null, (int) timeSlider.getValue());
            }
        });
        hStackButtons1.addMember(fadeOut);

        IButton fadeIn = new IButton("Fade In");
        fadeIn.setWidth(110);
        fadeIn.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                anim.animateShow(AnimationEffect.FADE, null, (int) timeSlider.getValue());
            }
        });
        hStackButtons2.addMember(fadeIn);

        IButton slideOut = new IButton("Slide Out");
        slideOut.setWidth(110);
        slideOut.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                anim.animateHide(AnimationEffect.SLIDE, null, (int) timeSlider.getValue());
            }
        });
        hStackButtons1.addMember(slideOut);

        IButton slideIn = new IButton("Slide In");
        slideIn.setWidth(110);
        slideIn.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                anim.animateShow(AnimationEffect.SLIDE, null, (int) timeSlider.getValue());
            }
        });
        hStackButtons2.addMember(slideIn);

        IButton wipeOut = new IButton("Wipe Out");
        wipeOut.setWidth(110);
        wipeOut.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                anim.animateHide(AnimationEffect.WIPE, null, (int) timeSlider.getValue());
            }
        });
        hStackButtons1.addMember(wipeOut);

        IButton wipeIn = new IButton("Wipe In");
        wipeIn.setWidth(110);
        wipeIn.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                anim.animateShow(AnimationEffect.WIPE, null, (int) timeSlider.getValue());
            }
        });
        hStackButtons2.addMember(wipeIn);
        
        canvas.addChild(vStackButtons);
        
        VStack vStackScrollButtons = new VStack();
        vStackScrollButtons.setMembersMargin(10);
        vStackScrollButtons.setLeft(760);
        vStackScrollButtons.setTop(50);
        
        IButton scrollTop = new IButton("Scroll Top");
        scrollTop.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                scroller.animateScroll(0, 0, null, (int) timeSlider.getValue());
            }
        });
        vStackScrollButtons.addMember(scrollTop);

        IButton scrollMiddle = new IButton("Scroll Middle");
        scrollMiddle.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                scroller.animateScroll(0, (scroller.getScrollHeight() - scroller.getHeight()) / 2, null, (int) timeSlider.getValue());
            }
        });
        vStackScrollButtons.addMember(scrollMiddle);

        IButton scrollEnd = new IButton("Scroll End");
        scrollEnd.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                scroller.animateScroll(0, scroller.getScrollBottom(), null, (int) timeSlider.getValue());
            }
        });
        vStackScrollButtons.addMember(scrollEnd);
        
        canvas.addChild(vStackScrollButtons);

        DynamicForm form = new DynamicForm();
        form.setLeft(150);
        form.setTop(550);
        form.setWidth(300);
        form.setBackgroundColor("white");
        form.setBorder("1px solid #6a6a6a");
        form.setTitlePrefix("<b>");
        form.setTitleSuffix("<b>");

        RadioGroupItem radioGroupItem = new RadioGroupItem();
        radioGroupItem.setName("Acceleration");
        radioGroupItem.setValueMap("smoothStart", "smoothEnd", "smoothStartEnd", "none", "custom");
        radioGroupItem.setDefaultValue("smoothEnd");
        radioGroupItem.addChangedHandler(new ChangedHandler() {
            public void onChanged(ChangedEvent event) {
                String value = event.getValue().toString();
                if (value.equals("custom")) {

                } else {

                }
            }
        });
        form.setFields(radioGroupItem);
        //canvas.addChild(form);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}