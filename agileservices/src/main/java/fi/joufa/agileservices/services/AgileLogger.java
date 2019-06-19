package fi.joufa.agileservices.services;

public interface AgileLogger {
    void error(Class clazz, String msg);
    void warn(Class clazz, String msg);
    void info(String msg);
    void debug(String msg);
    void trace(String msg);
}
