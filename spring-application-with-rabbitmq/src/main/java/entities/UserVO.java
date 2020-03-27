package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserVO {

    @JsonProperty("idUser")
    public String idUser;

    @JsonProperty("name")
    public String name;

    @JsonProperty("password")
    public String password;

    public UserVO(String idUser, String name, String password) {
        this.idUser = idUser;
        this.name = name;
        this.password = password;
    }

    public UserVO() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
