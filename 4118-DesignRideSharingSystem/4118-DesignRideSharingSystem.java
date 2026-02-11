// Last updated: 2/11/2026, 7:20:06 AM
class RideSharingSystem {
    Set<Integer>  ar;
    Queue<Integer> rider;
    Queue<Integer> driver;
    public RideSharingSystem() {
        rider = new LinkedList<>();
        driver = new LinkedList<>();
        ar = new HashSet<>();
    }
    
    public void addRider(int riderId) {
        rider.add(riderId);
        ar.add(riderId);
    }
    
    public void addDriver(int driverId) {
        driver.add(driverId);
    }
    
    public int[] matchDriverWithRider() {
        // agar cancel ho gya ho
        while(!rider.isEmpty() && !ar.contains(rider.peek())){
            rider.poll();
        }

        if(rider.isEmpty() || driver.isEmpty()){
            return new int[]{-1,-1};
        }

        int d =driver.poll();
        int r = rider.poll();
        ar.remove(r);

        return new int[]{d,r};
    }
    
    public void cancelRider(int riderId) {
        if(ar.contains(riderId)){
            ar.remove(riderId);
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */