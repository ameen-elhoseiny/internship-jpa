package org.ole.internship.chatagain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Random;

public class ChatBetween2PersonsTest {
/*
for a person to be able to join a chat room and send messages to other persons and other persons can receive

- Person ,  [name ,chatrooms, messages ] , (join, send , recieve)
- chat room [active, Persons ] , (accept ,  )
- Message , [sender , content] ,

Scenarios:
 - a person create new chat room
 - a person join existed Chat room
 - a person send message to an already joined chat room
 - a person receives from an already joined chat room
 /// el server we23
*/

    @Test
    public void personCreateNewChatRoom() throws SQLException {
        Person createChatRoomPerson = new Person();
        createChatRoomPerson.setName("7amada");

        Long rand = new Random().nextLong();
        String chatRoomName = "chat room_" + rand;
        ChatRoomHandler.createNewChatRoom(createChatRoomPerson, chatRoomName);

        ChatRoom chatRoomByName = ChatRoomHandler.getChatRoomByName(chatRoomName);
        System.out.println("DB chatRoom" + chatRoomByName.getName());
        System.out.println("DB chatRoom Persons" + chatRoomByName.getPersons().size());
    }

    @Test
    public void joinChatRoom() throws SQLException {
        Person person = new Person();
        person.setName("ali");
        ChatRoomHandler.joinChatRoom("new chat room", person);
        System.out.println("the char room size : " + ChatRoomHandler.getChatRoomByName("new chat room").getPersons().size());
    }

    @Test
    public void printAllFields() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ChatRoom chatRoom = new ChatRoom();
        //   System.out.println("chat room name" + chatRoom.getName());

        Method method = ChatRoom.class.getDeclaredMethod("setName", String.class);
        method.invoke(chatRoom, "some name");
        // System.out.println("chat room name" + chatRoom.getName());
        String selectPart = "";
        for (Field field : Person.class.getDeclaredFields()) {
            System.out.println(field.getName() + "," + field.getType().getName() + "," + convertToSQLConv(field.getName()));
            selectPart += "," + field.getName();
        }
        System.out.println("select " + selectPart + " from " + Person.class.getName());
    }


    private String convertToSQLConv(String name) {
        return name.toLowerCase();
    }

}