package com.akpanda.ludo.components.board;

public class CommonPathBox extends Box{
    private boolean isSafeBox;
    private boolean hasGatewayToHome;
    private boolean isStartBox;
    private CommonPathBox nextNode;
    private HomePathBox gateWayToHome;

    public boolean isStartBox() {
        return isStartBox;
    }

    public void setStartBox(boolean startBox) {
        isStartBox = startBox;
    }

    public boolean isSafeBox() {
        return isSafeBox;
    }

    public void setSafeBox(boolean safeBox) {
        isSafeBox = safeBox;
    }

    public boolean isHasGatewayToHome() {
        return hasGatewayToHome;
    }

    public void setHasGatewayToHome(boolean hasGatewayToHome) {
        this.hasGatewayToHome = hasGatewayToHome;
    }

    public CommonPathBox getNextNode() {
        return nextNode;
    }

    public void setNextNode(CommonPathBox nextNode) {
        this.nextNode = nextNode;
    }

    public HomePathBox getGateWayToHome() {
        return gateWayToHome;
    }

    public void setGateWayToHome(HomePathBox gateWayToHome) {
        this.gateWayToHome = gateWayToHome;
    }
}
