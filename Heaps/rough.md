# PriorityQueue in Java: Precautions & Documentation

## What is PriorityQueue?
- A **PriorityQueue** is a queue where elements are ordered by their priority, not by insertion order.
- By default, it is a **min-heap** (smallest element at the top).
- You can customize ordering using a **Comparator**.

## Common Use Cases in Interviews (Amazon, Google, etc.)
- Top K Frequent Elements
- Kth Smallest/Largest Element
- Merge K Sorted Lists/Arrays
- Sliding Window Maximum/Minimum
- Task Scheduling

## Precautions

1. **Default Behavior**
   - `PriorityQueue<Integer>` is a min-heap.
   - For max-heap, use:  
     `PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());`

2. **Custom Objects**
   - For arrays or custom classes, always provide a comparator:
     ```java
     PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // min-heap by second element
     ```

3. **Comparator Logic**
   - `(a, b) -> a[1] - b[1]` → min-heap (smallest at top)
   - `(a, b) -> b[1] - a[1]` → max-heap (largest at top)
   - Be careful with integer overflow for large values; use `Integer.compare(a[1], b[1])`.

4. **Heap Size Management**
   - For top K problems, keep heap size at K.
   - Remove elements when size exceeds K (`pq.poll()`).

5. **Duplicates**
   - PriorityQueue does not remove duplicates automatically.

6. **Null Elements**
   - PriorityQueue does not allow null elements.

7. **Performance**
   - Insertion and removal: O(log n)
   - Access top element: O(1)

8. **Iteration**
   - Iterating over a PriorityQueue does **not** guarantee sorted order.

## Documentation Template

```java
/**
 * Uses a PriorityQueue to solve [problem name].
 * - Min-heap by default; use Collections.reverseOrder() for max-heap.
 * - For custom objects, provide a comparator.
 * - Always manage heap size for top K problems.
 * - Time complexity: O(n log k) for Kth smallest/largest/top K problems.
 * - Does not allow null elements.
 * - Iteration order is not guaranteed to be sorted.
 */
```

## Example: Kth Smallest Element

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
for (int num : arr) {
    maxHeap.add(num);
    if (maxHeap.size() > k) {
        maxHeap.poll();
    }
}
// maxHeap.peek() is the kth smallest element
```

## Example: Top K Frequent Elements

```java
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
for (int key : map.keySet()) {
    pq.add(new int[] { key, map.get(key) });
    if (pq.size() > k) pq.poll();
}
```

---

**Tip:**  
Always clarify heap type (min/max), comparator logic, and heap size management in your code and explanations during interviews.
