package common.business.exceptions;

public abstract class BaseTravelCheckedExceptions extends Exception {

    abstract public int getCode();

    abstract public String getMessageExceptions();
}
