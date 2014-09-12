package com.smartgwt.sample.showcase.client;

// DetailsReport allows us to limit the reported error details, 
// if desired.  Note, we cannot extend final class StringBuffer.

public class DetailsReport {

    private StringBuffer buffer;
    private final int maxLength;

    DetailsReport() {
        buffer = new StringBuffer("");
        maxLength = ShowcaseConfiguration.getSingleton().getMaximumDetailsLength();
    }

    // append; remove excess and insert ellipsis if needed
    public void addDetails(String s) {
        if( maxLength > 0 ) {
            if (buffer.length() <= maxLength) {
                buffer.append(s);
                if (buffer.length() > maxLength) {
                    int extra = buffer.length() - maxLength;
                    int start = buffer.length() / 2 - extra / 2;
                    buffer.delete(start, start + extra);
                    buffer.insert(start, "...");
                }
            }
        } else {
            buffer.append(s);
        }
    }

    public boolean isEmpty() {
        return buffer.length() == 0;
    }
    public String toString() {
        return buffer.toString();
    }
}
