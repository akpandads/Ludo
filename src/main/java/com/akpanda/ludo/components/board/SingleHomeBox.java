package com.akpanda.ludo.components.board;

import com.akpanda.ludo.components.enums.Color;

public class SingleHomeBox {
    private Color color;
    private boolean isFinalBox;
    private SingleHomeBox next;
    private int position;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFinalBox() {
        return isFinalBox;
    }

    public void setFinalBox(boolean finalBox) {
        isFinalBox = finalBox;
    }

    public SingleHomeBox getNext() {
        return next;
    }

    public void setNext(SingleHomeBox next) {
        this.next = next;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
