package com.smartgwt.client.widgets;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.events.ClickHandler;

/**
 * Convenience ImgButton subclass for various transfer icons typically used in a dual list for transferring
 * items or reordering them within a list.
 */
public class TransferImgButton extends ImgButton {

    private static String IMG_TYPE = getImgType();

    private static native String getImgType() /*-{
        var imgType = $wnd.isc.transferImgType;
        return imgType == null || imgType === undefined ? "png" : imgType;
    }-*/;

    public static TransferImg LEFT = new TransferImg("[SKIN]/TransferIcons/left." + IMG_TYPE);
    public static TransferImg LEFT_ALL = new TransferImg("[SKIN]/TransferIcons/left_all." + IMG_TYPE);
    public static TransferImg RIGHT = new TransferImg("[SKIN]/TransferIcons/right." + IMG_TYPE);
    public static TransferImg RIGHT_ALL = new TransferImg("[SKIN]/TransferIcons/right_all." + IMG_TYPE);
    public static TransferImg UP = new TransferImg("[SKIN]/TransferIcons/up." + IMG_TYPE);
    public static TransferImg UP_FIRST = new TransferImg("[SKIN]/TransferIcons/up_first." + IMG_TYPE);
    public static TransferImg DOWN = new TransferImg("[SKIN]/TransferIcons/down." + IMG_TYPE);
    public static TransferImg DOWN_LAST = new TransferImg("[SKIN]/TransferIcons/down_last." + IMG_TYPE);
    public static TransferImg DELETE = new TransferImg("[SKIN]/TransferIcons/delete." + IMG_TYPE);

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
