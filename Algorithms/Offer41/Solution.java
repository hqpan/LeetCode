class MedianFinder {
    private PriorityQueue<Integer> smaller;
    private PriorityQueue<Integer> larger;

    /** initialize your data structure here. */
    public MedianFinder() {
        smaller = new PriorityQueue<>((val1, val2) -> val2 - val1);
        larger = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (smaller.size() == larger.size()) {
            smaller.add(num);
            larger.add(smaller.poll());
        } else {
            larger.add(num);
            smaller.add(larger.poll());
        }
    }
    
    public double findMedian() {
        return smaller.size() != larger.size() ? larger.peek() : (smaller.peek() + larger.peek()) / 2.0;
    }
}