package edu.yale.library.logservice;

import java.util.Date;
import java.util.Set;

public class LoggingEventBuilder {
    private int eventId;
    private Date timestmp;
    private String formattedMessage;
    private String loggerName;
    private String levelString;
    private String threadName;
    private Short referenceFlag;
    private String arg0;
    private String arg1;
    private String arg2;
    private String arg3;
    private String callerFilename;
    private String callerClass;
    private String callerMethod;
    private String callerLine;
    private Set loggingEventExceptions;
    private Set loggingEventProperties;

    public LoggingEventBuilder setEventId(int eventId) {
        this.eventId = eventId;
        return this;
    }

    public LoggingEventBuilder setTimestmp(Date timestmp) {
        this.timestmp = timestmp;
        return this;
    }

    public LoggingEventBuilder setFormattedMessage(String formattedMessage) {
        this.formattedMessage = formattedMessage;
        return this;
    }

    public LoggingEventBuilder setLoggerName(String loggerName) {
        this.loggerName = loggerName;
        return this;
    }

    public LoggingEventBuilder setLevelString(String levelString) {
        this.levelString = levelString;
        return this;
    }

    public LoggingEventBuilder setThreadName(String threadName) {
        this.threadName = threadName;
        return this;
    }

    public LoggingEventBuilder setReferenceFlag(Short referenceFlag) {
        this.referenceFlag = referenceFlag;
        return this;
    }

    public LoggingEventBuilder setArg0(String arg0) {
        this.arg0 = arg0;
        return this;
    }

    public LoggingEventBuilder setArg1(String arg1) {
        this.arg1 = arg1;
        return this;
    }

    public LoggingEventBuilder setArg2(String arg2) {
        this.arg2 = arg2;
        return this;
    }

    public LoggingEventBuilder setArg3(String arg3) {
        this.arg3 = arg3;
        return this;
    }

    public LoggingEventBuilder setCallerFilename(String callerFilename) {
        this.callerFilename = callerFilename;
        return this;
    }

    public LoggingEventBuilder setCallerClass(String callerClass) {
        this.callerClass = callerClass;
        return this;
    }

    public LoggingEventBuilder setCallerMethod(String callerMethod) {
        this.callerMethod = callerMethod;
        return this;
    }

    public LoggingEventBuilder setCallerLine(String callerLine) {
        this.callerLine = callerLine;
        return this;
    }

    public LoggingEventBuilder setLoggingEventExceptions(Set loggingEventExceptions) {
        this.loggingEventExceptions = loggingEventExceptions;
        return this;
    }

    public LoggingEventBuilder setLoggingEventProperties(Set loggingEventProperties) {
        this.loggingEventProperties = loggingEventProperties;
        return this;
    }

    public LoggingEvent createLoggingEvent() {
        return new LoggingEvent(eventId, timestmp, formattedMessage, loggerName, levelString, threadName,
                referenceFlag, arg0, arg1,
                arg2, arg3, callerFilename, callerClass,
                callerMethod, callerLine, loggingEventExceptions, loggingEventProperties);
    }
}