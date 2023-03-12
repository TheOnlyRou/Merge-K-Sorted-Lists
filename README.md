# Merge K Sorted Lists

## Problem Statement

You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order.

*Merge all the linked-lists into one sorted linked-list and return it.*

**Example 1:**

**Input:** lists = [[1,4,5],[1,3,4],[2,6]]
**Output:** [1,1,2,3,4,4,5,6]
**Explanation:** The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

**Example 2:**

**Input:** lists = []
**Output:** []

**Example 3:**

**Input:** lists = [[]]
**Output:** []

**Constraints:**

- `k == lists.length`
- `0 <= k <= 104`
- `0 <= lists[i].length <= 500`
- `-104 <= lists[i][j] <= 104`
- `lists[i]` is sorted in **ascending order**.
- The sum of `lists[i].length` will not exceed `104`.

## Explanation & Solution

The problem of merging K sorted linked lists involves combining K sorted linked lists into a single sorted linked list. One solution to this problem is to use a min heap data structure. The idea is to create a min heap of size K, where each element of the heap represents the head of one of the K linked lists. Then, we repeatedly extract the minimum element from the heap, append it to the result linked list, and replace the extracted element with its next node from its original linked list. We continue this process until all the linked lists are empty and the min heap is empty.



In this implementation, we first create a min heap of size K using a `PriorityQueue` in Java. We define a custom comparator to compare `ListNode` objects based on their values. We then add the heads of all K linked lists to the min heap. We then create a dummy node and a tail node for the result linked list. We repeatedly extract the minimum element from the min heap, append it to the result linked list, and replace the extracted element with its next node from its original linked list. We continue this process until all the linked lists are empty and the min heap is empty. Finally, we return the next node of the dummy node as the head of the result linked list.
