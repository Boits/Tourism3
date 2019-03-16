package common.business.exceptions;

public abstract class BaseTravelUncheckedExceptions extends Exception {

    abstract public int getCode();

    abstract public String getMessageExceptions();
}
