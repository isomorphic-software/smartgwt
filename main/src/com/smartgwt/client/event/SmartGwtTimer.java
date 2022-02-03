package com.smartgwt.client.event;

import com.google.gwt.user.client.Timer;

/**
 * <code>SmartGwtTimer</code> is an alternative to GWT's built-in 
 * {@link com.google.gwt.user.client.Timer Timer} class that may allow code to be
 * executed more efficiently.  The SmartClient Framework is aware of threads run using a
 * <code>SmartGwtTimer</code>, so extra work (e.g. reflowing
 * {@link com.smartgwt.client.widgets.layout.Layout Layout} members, refreshing 
 * {@link com.smartgwt.client.widgets.drawing.DrawItem DrawItem}s, etc.) queued by a timer's
 * <code>run()</code> method gets processed before it returns control to its caller, instead of
 * being scheduled to run in a future (second) timer call.
 * <P>
 * Note that if you are replacing or updating components in a
 * {@link com.google.gwt.user.client.Timer Timer} and notice a visible flash, switching to a
 * <code>SmartGwtTimer</code>, which offers identical public APIs to <code>Timer</code>, may
 * solve the issue.
 */
public abstract class SmartGwtTimer {

    private TimerHook hook = this.new TimerHook();

    private class TimerHook extends Timer {
        @Override
        public void run() {
            SmartGwtTimer.this.runAsFrameworkThread();
        }
    }

    private native void runAsFrameworkThread() /*-{
        var isc = $wnd.isc;
        isc.EH.setGwtTimerThread();
        this.@com.smartgwt.client.event.SmartGwtTimer::run()();
        isc.EH.clearGwtTimerThread();
    }-*/;

    /**
     * Cancels this timer. If the timer is not running, this is a no-op.
     */
    public void cancel() {
        hook.cancel();
    }

    /**
     * Returns true if the timer is running. Timer is running if and only if it is scheduled but
     * it is not expired or cancelled.
     * 
     * @return whether timer is running
     */
    public boolean isRunning() {
        return hook.isRunning();
    }

    /**
     * Schedules a timer to elapse in the future. If the timer is already running then it will
     * be first canceled before re-scheduling.
     *
     * @param delayMillis delay in milliseconds before timer fires
     */
    public void schedule(int delayMillis) {
        hook.schedule(delayMillis);
    }

    /**
     * Schedules a timer that elapses repeatedly. If the timer is already running then it will 
     * be first canceled before re-scheduling.
     *
     * @param periodMillis delay in milliseconds between timer fires
     */     
    public void	scheduleRepeating(int periodMillis) {
        hook.scheduleRepeating(periodMillis);
    }

    /**
     * This method will be called when a timer fires. Override it to implement the timer's 
     * logic.
     */
    public abstract void run();
}
