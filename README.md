# Heap DataStructure.
#### A heap is represented as a tree just for understanding purpose. It is actually implemented as an array.
- Implementing it as an array will save space (No need to store left link and right link).
- The way elements are stored in the array makes it a heap. 
- For an element at index i, the left element is at index 2i+1 and right element at index 2i+2.    
#### Heap is a complete binary tree. 
#### We can have a relation between the maximum number of nodes and height of the heap. 
#### maxNoOfNodes = 2^(h+1) - 1.
#### Height of heap is floor of log(no.of.nodes). Proof: [Quora](https://www.quora.com/Why-must-a-heap-of-size-n-have-height-floor-log-n) 