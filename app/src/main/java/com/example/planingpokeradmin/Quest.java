package com.example.planingpokeradmin;

public class Quest {
    String id;
    String QuestCode;
    String QuestName;


    public Quest(){


    }

    public Quest(String id, String questCode, String questName) {
        this.id = id;
        QuestCode = questCode;
        QuestName = questName;
    }

    public String getId() {
        return id;
    }

    public String getQuestCode() {
        return QuestCode;
    }

    public String getQuestName() {
        return QuestName;
    }
}
