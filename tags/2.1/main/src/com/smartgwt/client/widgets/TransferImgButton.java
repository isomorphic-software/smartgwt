package com.smartgwt.client.widgets;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.events.ClickHandler;

/**
 * Convenience ImgButton subclass for various transfer icons typically used in a dual list for transferring
 * items or reordering them within a list.
 */
public class TransferImgButton extends ImgButton {

    public static TransferImg LEFT = new TransferImg("[SKIN]/TransferIcons/left.png");
    public static TransferImg LEFT_ALL = new TransferImg("[SKIN]/TransferIcons/left_all.png");
    public static TransferImg RIGHT = new TransferImg("[SKIN]/TransferIcons/right.png");
    public static TransferImg RIGHT_ALL = new TransferImg("[SKIN]/TransferIcons/right_all.png");
    public static TransferImg UP = new TransferImg("[SKIN]/TransferIcons/up.png");
    public static TransferImg UP_FIRST = new TransferImg("[SKIN]/TransferIcons/up_first.png");
    public static TransferImg DOWN = new TransferImg("[SKIN]/TransferIcons/down.png");
    public static TransferImg DOWN_LAST = new TransferImg("[SKIN]/TransferIcons/down_last.png");
    public static TransferImg DELETE = new TransferImg("[SKIN]/TransferIcons/delete.png");

    /**
     * Create a new HeaderControl with the specific icon.
     *
     * @param transferImg the icon
     */
    public TransferImgButton(TransferImg transferImg) {
        setSrc(transferImg.url);
        setWidth(24);
        setHeight(22);
        setLayoutAlign(Alignment.CENTER);
        setShowRollOver(true);
        setShowDownIcon(false);
        setShowDown(false);
    }

    /**
     * Create a new HeaderControl with the specific icon.
     *
     * @param transferImg  the icon
     * @param clickHandler the header control click handler
     */
    public TransferImgButton(TransferImg transferImg, ClickHandler clickHandler) {
        this(transferImg);
        addClickHandler(clickHandler);
    }

    public static class TransferImg {
        private String url;

        public TransferImg(String url) {
            this.url = url;
        }
    }
}
