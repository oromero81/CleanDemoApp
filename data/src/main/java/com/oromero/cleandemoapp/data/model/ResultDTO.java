package com.oromero.cleandemoapp.data.model;

/**
 * Created by oromero on 02/03/15.
 */
public class ResultDTO {

    private UserDTO user;
        private String seed;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }
}
