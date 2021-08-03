package org.ole.internship.chatagain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "chat_room")
public class ChatRoom {

    @Id
    private String name;
    private boolean active;

    @JoinColumn
    @JoinTable(name = "chat_room_persons")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Person> persons;

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }


    public ChatRoom() {
        persons = new ArrayList<>();
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
