package com.kasprzak.kamil.demoapp.demoapp.invite;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@Getter
@Setter
public class Invite {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name = "USER_SENDER_ID")
    private String userSenderId;
    @Column(name = "USER_RECEIVER_ID")
    private String userReceiverId;

    @Column(name = "ACCEPTED")
    private String accepted;

    public Invite(String userSenderId, String userReceiverId) {
        this.userSenderId = userSenderId;
        this.userReceiverId = userReceiverId;
    }
}
