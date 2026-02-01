// Last updated: 2/1/2026, 8:13:23 AM
1class RideSharingSystem {
2    Set<Integer>  ar;
3    Queue<Integer> rider;
4    Queue<Integer> driver;
5    public RideSharingSystem() {
6        rider = new LinkedList<>();
7        driver = new LinkedList<>();
8        ar = new HashSet<>();
9    }
10    
11    public void addRider(int riderId) {
12        rider.add(riderId);
13        ar.add(riderId);
14    }
15    
16    public void addDriver(int driverId) {
17        driver.add(driverId);
18    }
19    
20    public int[] matchDriverWithRider() {
21        // agar cancel ho gya ho
22        while(!rider.isEmpty() && !ar.contains(rider.peek())){
23            rider.poll();
24        }
25
26        if(rider.isEmpty() || driver.isEmpty()){
27            return new int[]{-1,-1};
28        }
29
30        int d =driver.poll();
31        int r = rider.poll();
32        ar.remove(r);
33
34        return new int[]{d,r};
35    }
36    
37    public void cancelRider(int riderId) {
38        if(ar.contains(riderId)){
39            ar.remove(riderId);
40        }
41    }
42}
43
44/**
45 * Your RideSharingSystem object will be instantiated and called as such:
46 * RideSharingSystem obj = new RideSharingSystem();
47 * obj.addRider(riderId);
48 * obj.addDriver(driverId);
49 * int[] param_3 = obj.matchDriverWithRider();
50 * obj.cancelRider(riderId);
51 */