package com.interview.sde.algorithm.datastructure;

public class ParkingSystem {

    int[] parkingSpaces;

    public ParkingSystem(int big, int medium, int small) {
        this.parkingSpaces = new int[4];
        this.parkingSpaces[1] = big;
        this.parkingSpaces[2] = medium;
        this.parkingSpaces[3] = small;
    }

    public boolean addCar(int carType) {
        if (this.parkingSpaces[carType] > 0) {
            this.parkingSpaces[carType]--;
            return true;
        }
        return false;
    }
}