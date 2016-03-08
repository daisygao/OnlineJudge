3Sum: easy

3Sum Closest: easy

4Sum: O(n^3) consider efficiency of ArrayList expansion operation

Add Binary: * all in one 

Add Digits: math n - 1

Add Two Numbers: easy

Anagrams: easy

Balanced Binary Tree: easy

Best Time to Buy and Sell Stock: easy

Best Time to Buy and Sell Stock II: DP thinking with one variable 

Best Time to Buy and Sell Stock III: DP

Best Time to Buy and Sell Stock with Cooldown: DP O(n^2)

Binary Search Tree Iterator: build in constructor

Binary Tree Inorder Traversal: iteratively

Binary Tree Level Order Traversal: one queue solution. queue size = row size 

Binary Tree Level Order Traversal II: DFS is cool...BFS using one queue 

Binary Tree Maximum Path Sum: hard

Binary Tree Paths: vector merge

Binary Tree Postorder Traversal: medium pop condition

Binary Tree Preorder Traversal: stack, exit condition..

Bulb Switcher: math

Bulls and Cows: * one pass counter...brilliant

Binary Tree Zigzag Level Order Traversal: medium

Candy ※: medium. Greedy algorithm. Similar to Dijsktra

Climbing Stairs: DP with O(1) space

Clone Graph: BFS + hash

Combination Sum: recursion

Combination Sum II: recursion

Combination Sum III: recursion

Combinations: both iterative and recursion

Compare Version Numbers: multiple dots scenarios

Construct Binary Tree from Inorder and Postorder Traversal: easy

Construct Binary Tree from Preorder and Inorder Traversal: easy

Container With Most Water: * greedy scan

Contains Duplicates: cannot sort an empty array; C++ set insert return value is pair

Contains Duplicate II: 1) greedy 2) sliding window

Convert Sorted Array to Binary Search Tree: for C++, new TreeNode 

Convert Sorted List to Binary Search Tree: medium global pointer bottom-up recursion 

Copy List with Random Pointer: deep copy queue

Count and Say: start with 1..

Count Primes: upperBound, i*j, smaller than n...details...

Decode Ways: DP medium

Delete Node in a Linked List: fill instead of "real" deletion

Distinct Subsequences: DP medium

Divide Two Integers: binary medium

Edit Distance: DP medium

Evaluate Reverse Polish Notation: easy

Excel Sheet Column Number: no brainer

Excel Sheet Column Title: * n-- && overflow 

Factor Trailing Zeroes: math mod. similiar to Add Digits. 

Find Minimum in Sorted Array: infinity loop

First Bad Version: binary search, invariant: target in [i, j]

First Missing Positive: classic

Flatten Binary Tree to Linked List: easy

Game of Life: * trick - bit + state iteration

Gas Station: easy greedy algorithm. Similar to Longest Consecutive Seq

Generate Parentheses: 1) recursion, last case 2) iterative using queues

Gray Code: classic trick generating subsets or binary numbers

Happy Number: all about hash

House Robber: DP two params in equation = two variables

Implement Stack Using Queues: brilliant idea to use only one queue...making push() an O(n) operation...

Implement strStr(): KMP. DP. psl=prefix, suffix, equal length. psl[i] = length of prefix same with suffix to current i. if not match, start from the next element of the latest matched prefix.

Insert Interval: medium

Insertion Sort List: medium

Integer to Roman: no map needed. %5 trick. 

Interleaving String: DP

Intersection of Two Linked Lists: count number & GOD algo: length(A+B) = length(B+A), you will encounter either the common node or null

Invert Binary Tree: recursive

Isomorphic Strings: double way unique: *position map but can't use index directly, must plus 1 to differentiate first time char and pos 0 char; 2)  map + set

Jump Game: Greedy O(n) BFS or DFS

Kth Smallest Element in a BST: bottom up, modify k

Jump Game II ※: DP BFS hard

Largest Rectangle in Histogram: left right idx problem. Non-descending sequence using stack

Length of Last Word: length increment

Letter Combinations of a Phone Number: easy

Linked List Cycle: fast and slow pointer

Longest Common Prefix: 1) empty char = '\0' 2) size() - 1 overflow

Longest Consecutive Sequence ※: hash

Longest Increasing Subsequence: * active list DP, store only the last element of the list

Longest Palindromic Substring: DP 

Longest Substring Without Repeating Characters: O(n) using hash 

Longest Valid Parentheses ※: stack + DP + max O(n) time complexity

Lowest Common Ancestor of a Binary Search Tree: easy

Lowest Common Ancestor of a Binary Tree: recursion does everything 

Majority Element: median or Moore voting algorithm

Maximum Product of Word Lengths: size_type can't deduct 1! pruning

Maximal Rectangle ※: use union-find set to construct the monotone queue instead of the stack. Stack will exceed time limit for large judge. 

Maximum Depth of Binary Tree: easy

Maximum Product Subarray: medium DP

Maximum Subarray: initialize min ans max value.. 

Median of Two Sorted Arrays: binary search hard 

Merge Intervals: lambda comparactor 

Merge k Sorted Lists: priority queue of size k

Merge Sorted Array: easy extremely short code

Merge Two Sorted List: easy...became stupid...think nums1 value moving is needed...

Min Stack: struct

Minimum Depth of Binary Tree: make sure to understand the definition of minDepth which is to count the distance between root and the "leaf" node; when there is only one child...

Minimum Path Sum: DP 1) O(n) 2) init row & column value

Minimum Window Substring ※: ascii hash 

Missing Number: create duplicate then xor / deduction to extract the target

Move Zeros: think through different cases before coding

Multiply Strings: medium large number or string

N-Queens: easy

N-Queens II: easy

Next Permutation: classic 

Nim Game: math 

Number of 1 Bits: n & (n - 1) trick for sparse ones

Odd Even Linked List: odd and even head pointers

Palindrome Number: reverse half and compare 

Palindrome Partitioning: recursion

Palindrome Partitioning II: DP on sol and palindrome

Palindrome Linked List: 1) to string 2) * reverse first half in place

Partition List: easy but kindof tricky..

Pascal's Triangle: one row DP 

Pascal's Triangle II: one row DP direction reversed

Path Sum: when tree is null, no leaf so no sum, not even 0 

Path Sum II: easy 

Permutation Sequence: easy 

Permutations: deque or vector 

Permutations II: next permutation problem

Plus One: know where to stop 

Populating Next Right Pointers in Each Node: use previous next 

Populating Next Right Pointers in Each Node II: easy from right to left 

Pow(x, n): tricky Integer boundary

Power Of Three: zero handling and math

Product of Array Except Self: double-way DP

Range Sum Query - Immutable: DP but with i - 1 index!!!

Recover Binary Search Tree: both recursively and iteratively medium

Rectangle Area: overlap coordinates

Regular Expression Matching: medium recursion

Remove Duplicates from Sorted Array: cnt method... 

Remove Duplicates from Sorted Array II: easy

Remove Duplicates from Sorted List: slim code!

Remove Duplicates from Sorted List II: easy

Remove Element: fixing one side && cnt method

Remove Linked List Elements: dummy head

Remove Nth Node From End of List: dummy head

Reorder List: easy detail..

Restore IP Addresses: recursion easy corner cases..

Reverse Bits: divide and conquer or hash !!unsigned char converted to int != char converted to int

Reverse Integer: overflow at INT_MAX/10

Reverse Linked List: pointer initialization...*p = NULL

Reverse Linked List II: classic 

Reverse Nodes in k-Group: easy

Reverse Words in a String: easy & tricky

Roman to Integer: math trick: sum += cur - 2 * (sum % cur)

Rotate Array: reverse trick

Rotate Image: let j starts from i 

Rotate List: medium

Same Tree: easy

Scramble String: medium recursion & pruning

Search a 2D Matrix: 1) right = n or n - 1 2) while condition i < j or i <= j 3) update r = mid or mid - 1 4) return false or matrix[r/n][r%n] == target 

Search a 2D Matrix II: *greedy trick start from top right

Search for a Range: recursion or twice binary search

Search in Rotated Sorted Array: classic 

Search in Rotated Sorted Array II: medium

Search Insert Position: 1) invariant 2) while condition 3) return value, left or right 

Set Matrix Zeroes: details...

Simplify Path: easy details...

Single Number: easy classic xor

Single Number II : * 1) bit counter using decimal 2) bit counter using binary with mask generated to mod 

Single Number III: 1) init = 0 OK 2) diff & (-diff) to find flag

Sort Colors: Dutch National Flag Problem loop invariant -1 and size()

Spiral Matrix: classic

Spiral Matrix II: 1) layer offset 2) when n is odd

Sqrt(x): Newton and binary search 

String to Integer (atoi): 1) trim 2) overflow 3) "+/-" 4) > INT_MAX % 10 trick 

Subsets: easy

Subsets II: both iterative and recursion. Recursion is the same with Combination Sum. Subsets could also use this recursion solution.  

Substring with Concatenation of All Words: hash hash

Sudoku Solver: medium boolean recursion & bit masking & 2-d array to 1-d array

Sum Root to Leaf Numbers: easy top-down

Summary Ranges: j vs j + 1

Surrounded Regions: medium queue

Swap Nodes in Pairs: dummy head 

Symmetric Tree: recursion - input; iteration by using one queue 

Text Justification: medium

Trapping Rain Water: double-way DP O(n)

Triangle: DP O(n^2)

Two Sum: hash / quicksort + binary 

Ugly Number: corner case ZERO!

Unique Binary Search Trees: DP, iterate root and left, right number

Unique Binary Search Trees II: recursion

Unique Paths: DP 1d + init row / column

Unique Paths II: DP 1d

Valid Anagram: vector initialization

Valid Palindrome: shrink cases to three

Valid Parentheses: map + stack

Valid Sudoku: became stupid...use bit mask array = unordered set...cell index computation.. 

Validate Binary Search Tree : similar to Balanced Tree

Wildcard Matching: hard

Word Break: DP

Word Break II ※: DP + parent + recursion. Note time efficiency

Word Ladder: BFS using queue and HashMap 

Word Ladder II: medium 

Word Pattern: position map, c++ strsplit using stringstream + getline with sep * 

Word Search: recursion easy 

ZigZag Conversion: given formula size = numRows * 2 - 2 consider corner cases 
