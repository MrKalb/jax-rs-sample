package org.example.pong.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person")
public class PongEntity implements Serializable {

    @Id
    private Long id;

    @Column
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
