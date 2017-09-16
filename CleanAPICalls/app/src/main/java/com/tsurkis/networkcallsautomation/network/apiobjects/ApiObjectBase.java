package com.tsurkis.networkcallsautomation.network.apiobjects;

/**
 * Created by T.Surkis on 12-Aug-17.
 *
 * Base object for every API received response.
 */
class ApiObjectBase {
    private String status;

    ApiObjectBase(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
