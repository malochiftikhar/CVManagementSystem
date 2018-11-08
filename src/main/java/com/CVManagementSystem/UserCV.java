package com.CVManagementSystem;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CV")
@EntityListeners(AuditingEntityListener.class)
public class UserCV implements Serializable {

    @Id
    private String userName;

//    @Lob
//    @Basic(fetch = FetchType.LAZY)
////    private byte[] cv;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String cv;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserModel user;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public byte[] getCv() {
//        return cv;
//    }
//
//    public void setCv(byte[] cv) {
//        this.cv = cv;
//    }


    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
