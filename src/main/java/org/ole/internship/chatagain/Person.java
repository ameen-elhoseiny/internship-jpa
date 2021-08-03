package org.ole.internship.chatagain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    private String name;

    @JoinColumn(referencedColumnName ="person" )
    @ManyToMany
    private List<ChatRoom> chatRooms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}