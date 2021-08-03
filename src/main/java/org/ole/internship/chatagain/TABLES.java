package org.ole.internship.chatagain;

public enum TABLES {
    CHAT_ROOM_PERSONS("chat_room_persons"), CHAT_ROOM("chat_room");
    private final String name;

    TABLES(String tableName) {
        this.name = tableName;
    }

    public String getName() {
        return name;
    }
}
