package user.exceptions;

import common.business.exceptions.BaseTravelCheckedExceptions;

public class UserHasNoOrdersException extends BaseTravelCheckedExceptions {

    private int code = 20;
    private String messageExceptions = "User has no orders!";

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessageExceptions() {
        return messageExceptions;
    }
}
