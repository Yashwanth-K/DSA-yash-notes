// Class representing a MinHeap
class MinHeap {
    int[] heap;       // Array to store heap elements
    int size;         // Current number of elements in heap
    int capacity;     // Maximum capacity of heap

    // Constructor
    MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0; // Initially empty
        heap = new int[capacity]; // Fixed-size array for heap
    }

    // Get parent index of node at i
    int parent(int i) { return (i - 1) / 2; }

    // Get left child index of node at i
    int leftChild(int i) { return 2 * i + 1; }

    // Get right child index of node at i
    int rightChild(int i) { return 2 * i + 2; }

    // Insert a new value into the heap
    void insert(int val) {
        if (size == capacity) { // If heap is full
            System.out.println("Heap full");
            return;
        }

        // Place new value at the end
        heap[size] = val;
        int current = size;
        size++;

        // Bubble up: compare with parent and swap if violated
        while (current > 0 && heap[current] < heap[parent(current)]) {
            // Swap current with its parent
            int temp = heap[current];
            heap[current] = heap[parent(current)];
            heap[parent(current)] = temp;

            // Move up the tree
            current = parent(current);
        }
    }

    // Remove and return the minimum element (root of the heap)
    int extractMin() {
        if (size <= 0) return Integer.MAX_VALUE; // Empty heap
        if (size == 1) return heap[--size];      // Only one element

        // Save root value (minimum)
        int root = heap[0];

        // Move last element to root and shrink size
        heap[0] = heap[--size];

        // Heapify to restore min-heap property
        heapify(0);

        return root;
    }

    // Heapify (fix min-heap property) at index i
    void heapify(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;

        // Compare with left child
        if (l < size && heap[l] < heap[smallest]) smallest = l;

        // Compare with right child
        if (r < size && heap[r] < heap[smallest]) smallest = r;

        // If smallest is not the current node, swap and recurse
        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            // Recursively heapify affected subtree
            heapify(smallest);
        }
    }
    public static void main(String[] args) {
        MinHeap mh = new MinHeap(10); // Create min-heap of capacity 10

        // Insert elements
        mh.insert(10);
        mh.insert(20);
        mh.insert(5);
        mh.insert(15);

        // Extract elements in order
        System.out.println("Extracted Min: " + mh.extractMin()); // should print 5
        System.out.println("Extracted Min: " + mh.extractMin()); // should print 10
    }
}
