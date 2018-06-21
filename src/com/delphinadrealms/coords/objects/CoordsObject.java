package com.delphinadrealms.coords.objects;

public class CoordsObject {

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    private String name;
    private double x;
    private double y;
    private double z;

    public CoordsObject(String name , double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
