class MovingAverage {

        private final int k;
        private final Queue<Integer> q;
        private long totalSumSoFar;
    
    public MovingAverage(int size) {
        this.k = size;
        this.q = new ArrayDeque<>();
        this.totalSumSoFar = 0L;

    }
    public double next(int val) {
        q.add(val);
        totalSumSoFar += val;

        if(q.size() > k) {
            totalSumSoFar -= q.poll();
        }
        
        return (double) totalSumSoFar/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */