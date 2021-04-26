package com.wazny;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogEntry {
    private  Integer gain;
    private  String location;
    private Date date;
    private String outcome;
    LogEntry(String location, Integer gain) {

        this.date = new Date();
        this.location = location;
        this.gain = gain;
    }

    public Integer getGain() {
        return this.gain;
    }

    public String getOutcome() {
        return this.outcome;
    }
    @Override
    public String toString() {
    SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-dd H:mm:ss a");
    this.outcome = gain <0? "lost" : "won";
    return String.format("%s: Went to the %s and %s %d gold",df.format(this.date),this.location, this.outcome, Math.abs(gain));
    }
}
