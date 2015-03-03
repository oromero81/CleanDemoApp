package com.oromero.cleandemoapp.data.model.bean;

/**
 * Created by oromero on 02/03/15.
 */
public class ResultBean {

    private UserBean user;
        private String seed;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }
}
