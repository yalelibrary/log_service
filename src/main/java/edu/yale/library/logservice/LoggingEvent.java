package edu.yale.library.logservice;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

/**
 * Logging Event
 * @author Osman Din
 */
public class LoggingEvent implements java.io.Serializable {

    public static final long serialVersionUID = 1L;
    public Long eventId;
    public long timestmp;
    public String formattedMessage;
    public String loggerName;
    public String levelString; //TODO done for PFs
    public String threadName;
    public Short referenceFlag;
    public String arg0;
    public String arg1;
    public String arg2;
    public String arg3;
    public String callerFilename;
    public String callerClass;
    public String callerMethod;
    public String callerLine;
    public Set loggingEventExceptions = new HashSet(0);
    public Set loggingEventProperties = new HashSet(0);

    public LoggingEvent() {
    }

    public LoggingEvent(long timestmp, String formattedMessage, String loggerName,
                        String levelString, String callerFilename, String callerClass,
                        String callerMethod, String callerLine) {
        this.timestmp = timestmp;
        this.formattedMessage = formattedMessage;
        this.loggerName = loggerName;
        this.levelString = levelString;
        this.callerFilename = callerFilename;
        this.callerClass = callerClass;
        this.callerMethod = callerMethod;
        this.callerLine = callerLine;
    }

    public LoggingEvent(long timestmp, String formattedMessage, String loggerName,
                        String levelString, String threadName, Short referenceFlag,
                        String arg0, String arg1, String arg2, String arg3, String callerFilename,
                        String callerClass, String callerMethod, String callerLine,
                        Set loggingEventExceptions, Set loggingEventProperties) {
        this.timestmp = timestmp;
        this.formattedMessage = formattedMessage;
        this.loggerName = loggerName;
        this.levelString = levelString;
        this.threadName = threadName;
        this.referenceFlag = referenceFlag;
        this.arg0 = arg0;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.callerFilename = callerFilename;
        this.callerClass = callerClass;
        this.callerMethod = callerMethod;
        this.callerLine = callerLine;
        this.loggingEventExceptions = loggingEventExceptions;
        this.loggingEventProperties = loggingEventProperties;
    }

    public Long getEventId() {
        return this.eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public long getTimestmp() {
        return this.timestmp;
    }

    public void setTimestmp(long timestmp) {
        this.timestmp = timestmp;
    }

    public String getFormattedMessage(){
        return this.formattedMessage;
    }

    public void setFormattedMessage(String formattedMessage) {
        this.formattedMessage = formattedMessage;
    }

    public String getLoggerName() {
        return this.loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public String getLevelString() {
        return this.levelString;
    }

    public void setLevelString(String levelString) {
        this.levelString = levelString;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public Short getReferenceFlag() {
        return this.referenceFlag;
    }

    public void setReferenceFlag(Short referenceFlag) {
        this.referenceFlag = referenceFlag;
    }

    public String getArg0() {
        return this.arg0;
    }

    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    public String getArg1() {
        return this.arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return this.arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getArg3() {
        return this.arg3;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    public String getCallerFilename() {
        return this.callerFilename;
    }

    public void setCallerFilename(String callerFilename) {
        this.callerFilename = callerFilename;
    }

    public String getCallerClass() {
        return this.callerClass;
    }

    public void setCallerClass(String callerClass) {
        this.callerClass = callerClass;
    }

    public String getCallerMethod() {
        return this.callerMethod;
    }

    public void setCallerMethod(String callerMethod) {
        this.callerMethod = callerMethod;
    }

    public String getCallerLine() {
        return this.callerLine;
    }

    public void setCallerLine(String callerLine) {
        this.callerLine = callerLine;
    }


    public Set getLoggingEventExceptions() {
        return this.loggingEventExceptions;
    }


    public void setLoggingEventExceptions(Set loggingEventExceptions) {
        this.loggingEventExceptions = loggingEventExceptions;
    }

    public Set getLoggingEventProperties() {
        return this.loggingEventProperties;
    }

    public void setLoggingEventProperties(Set loggingEventProperties) {
        this.loggingEventProperties = loggingEventProperties;
    }
}