// Last updated: 10/11/2025, 8:47:19 PM
class ExamTracker {
    private TreeMap<Integer,Long> map;
    private long t;
    public ExamTracker() {
        map= new TreeMap<>();
        t=0;
    }
    
    public void record(int time, int score) {
        t+=score;
        map.put(time,t);
    }
    
    public long totalScore(int startTime, int endTime) {
        long s=0,e=0;
        Integer key = map.floorKey(startTime-1);
        if(key !=null) s=map.get(key);
        key=map.floorKey(endTime);
        if(key != null) e=map.get(key);
        return e-s;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */