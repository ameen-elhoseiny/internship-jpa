package org.ole.internship.chatagain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {


    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("batee5");


    public static void addChatRoom(ChatRoom newChatRoom) throws SQLException {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(newChatRoom);
        em.getTransaction().commit();
        em.close();
    }

    public static ChatRoom getChatRoomByName(String chatRoomName) throws SQLException {
        EntityManager em = entityManagerFactory.createEntityManager();
        ChatRoom chatRoom = em.find(ChatRoom.class, chatRoomName);
        return chatRoom;
    }

}
