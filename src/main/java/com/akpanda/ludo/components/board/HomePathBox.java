package com.akpanda.ludo.components.board;

public class HomePathBox extends Box {

    private boolean isFinalBox;
    private HomePathBox next;

    public boolean isFinalBox() {
        return isFinalBox;
    }

    public void setFinalBox(boolean finalBox) {
        isFinalBox = finalBox;
    }

    public HomePathBox getNext() {
        return next;
    }

    public void setNext(HomePathBox next) {
        this.next = next;
    }

}
