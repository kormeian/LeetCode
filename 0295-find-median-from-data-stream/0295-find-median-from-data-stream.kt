class MedianFinder() {

    private val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    private val minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
        maxHeap.add(num)

        if (maxHeap.isNotEmpty() && minHeap.isNotEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll())
        }

        if (maxHeap.size > minHeap.size + 1) {
            minHeap.add(maxHeap.poll())
        } else if (minHeap.size > maxHeap.size) {
            maxHeap.add(minHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size > minHeap.size) {
            maxHeap.peek().toDouble()
        } else {
            (maxHeap.peek() + minHeap.peek()) / 2.0
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */