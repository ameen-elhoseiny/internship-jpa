package org.ole.internship.chatagain;

import java.sql.SQLException;
import java.util.Random;

public class ChatRoomHandler {


    public static void createNewChatRoom(Person createChatRoomPerson, String chatRoomName) throws SQLException {
        ChatRoom newChatRoom = new ChatRoom();
        newChatRoom.setName(chatRoomName);
        newChatRoom.setActive(true);
        newChatRoom.getPersons().add(createChatRoomPerson);
        Person person2 = new Person();
        person2.setName(new Random().nextInt() + "");
        newChatRoom.getPersons().add(person2);
        DB.addChatRoom(newChatRoom);
    }

    public static void joinChatRoom(String roomName, Person person) throws SQLException {
        ChatRoom chatRoom = ChatRoomHandler.getChatRoomByName(roomName);
        chatRoom.getPersons().add(person);
        //
    }

    public static ChatRoom getChatRoomByName(String chatRoomName) throws SQLException {
        return DB.getChatRoomByName(chatRoomName);
        //chatRooms.get(chatRoomName);
    }
}
