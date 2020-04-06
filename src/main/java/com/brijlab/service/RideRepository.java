package com.brijlab.service;

import java.util.*;

public class RideRepository {
    Map<String, ArrayList<NoumberOfRide>> userRides =null;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, NoumberOfRide[] rides) {
        ArrayList<NoumberOfRide> rideArrayList = this.userRides.get(userId);
        if (rideArrayList == null){
            this.userRides.put(userId,new ArrayList<>(Arrays.asList(rides)));
        }
    }

    public NoumberOfRide[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new NoumberOfRide[0]);
    }
}
