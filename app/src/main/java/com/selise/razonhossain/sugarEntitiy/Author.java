package com.selise.razonhossain.sugarEntitiy;

import com.orm.SugarRecord;

/**
 * Created by razon.hossain on 2/6/2018.
 */

public class Author extends SugarRecord {

    public Author(){}

    String name;
    String birthday;
    String authoId;

    public Author(String name, String birthday, String authoId) {
        this.name = name;
        this.birthday = birthday;
        this.authoId = authoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAuthoId() {
        return authoId;
    }

    public void setAuthoId(String authoId) {
        this.authoId = authoId;
    }
}
