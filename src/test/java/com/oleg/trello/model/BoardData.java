package com.oleg.trello.model;

//public class BoardData {
//    private String boardName;
//    String team;
//
//
//    public BoardData(String boardName) {
//        this.boardName = boardName;
//    }
//
//    public BoardData() {
//
//    }
//
//    public String getBoardName() {
//        return boardName;
//    }
//
//
//}

public class BoardData {
    private String boardName;

    public String getBoardName() {
        return boardName;
    }

    public BoardData setBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }
}