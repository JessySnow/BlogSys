package com.jessysnow.boot.entity;

/**
 * 包装一个 Banner 图片对象
 */
public enum Banner {
    TECH("Technology.jpg"), HEALTH("Healthy.jpg"), AFFECTION("Emotion.jpg"), ANI("Animation.jpg"), GAME("Game.jpg"), RUMOR("Gossip.jpg"), TEST("Test.jpg"),
    FOOD("Food.jpg"), TRAVEL("Travel.jpg"), CODE("Code.jpg"), LIFE("Life.jpg"), STUDY("Study.jpg"), DEFAULT("Default.jpg");

    private String path;

    Banner(String path){
        this.path = "/photo/" + path;
    }

    public String getPath() {
        return this.path;
    }
}
