package com.smartgwt.client.util;

import com.smartgwt.client.widgets.PrintWindow;
import com.smartgwt.client.widgets.PrintCanvas;

public interface PrintPreviewCallback {

    void execute(PrintCanvas printCanvas, PrintWindow printWindow);
}
