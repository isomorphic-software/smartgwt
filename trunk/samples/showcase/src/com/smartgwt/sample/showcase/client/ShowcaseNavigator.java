package com.smartgwt.sample.showcase.client;

/**
 * This interface represents actions on the Showcase allowed to the TileView.
 */
interface ShowcaseNavigator {
    // search forward from the current origin using text
    public void incrementalSearch(String text);

    // jump to next match if text equals current match
    public boolean iterateCurrentMatch(String text);

    // clear any selected sample tree rows
    public void clearSelectedSamples();
}
