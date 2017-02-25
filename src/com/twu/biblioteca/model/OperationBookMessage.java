package com.twu.biblioteca.model;

/**
 * Created by zhaoqiaoying on 2017/2/24.
 */
public class OperationBookMessage {
    private Object obj;
    private boolean ifOperationSuccess;
    private String errorMessage;

    public OperationBookMessage(){
    }

    public OperationBookMessage(boolean ifOperationSuccess,String errorMessage){
        this.ifOperationSuccess = ifOperationSuccess;
        this.errorMessage = errorMessage;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public boolean isIfOperationSuccess() {
        return ifOperationSuccess;
    }

    public void setIfOperationSuccess(boolean ifOperationSuccess) {
        this.ifOperationSuccess = ifOperationSuccess;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
