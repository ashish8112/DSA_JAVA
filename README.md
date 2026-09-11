# DSA with Java

MCA student, placement prep. Strong C/C++ base from UG — LinkedList (single, double, circular,
polynomial), Stack, Queue sab manually implement kiye the with pointers and structs.
Java sirf DSA ke liye.

Sheets: **Striver A2Z** (primary) + **NeetCode 75** (parallel)

---

## Progress

**Total: 145 problems solved**

| Topic | Solved | Status |
|-------|--------|--------|
| Arrays | 55 | Completed |
| Binary Search | 32 | Completed |
| LinkedList | 23 | Near complete |
| Strings | 12 | Completed |
| Binary Trees | 12 | Ongoing |
| Math | 8 | Completed |
| Sliding Window | 2 | Ongoing |
| Binary Search Tree | 1 | Just started |
| Stack / Queue | — | Remaining |
| Recursion (formal) | — | Remaining |
| Heaps | — | Remaining |
| Bit Manipulation | — | Remaining |
| Greedy | — | Remaining |
| Graphs | — | Remaining |
| DP | — | Remaining |

Alag se: **7** sorting algorithms, **22** star pattern programs, aur Java basics
(OOP, Threads, Exception Handling, Generics, Collections).

---

## Folder Structure

```
Array/             Easy · Rotation · Medium · Hard
String/            Basic · EasyAndMedium · Medium
BinarySearch/      01 se 31 tak, numbered order me
BinaryTree/        traversals, construction, height-based problems
BinarySearchTree/
LinkedList/        SingleLinkedList · DoubleLinkedList
SlidingWindow/
MAP/               HashMap ke notes aur experiments
Math/
Recursion/
Sorting/           Bubble · Insertion · Selection · Quick · Merge
Stack/
Pattern_Star/
Basic/             OOP · Threads · Exceptions · Polymorphism
WrapperAndGeneric/
Collections/
```

Zyada tar files me ek hi problem ke **multiple approaches** hain —
brute se optimal tak, complexity ke saath.

---

## Patterns Learned

**Arrays & Strings**
1. Two Pointers
2. Prefix / Suffix Tracking
3. Sliding Window — fixed aur variable dono
4. Sliding Window with Stale Max (non-shrinking window)
5. Count Based (parentheses)
6. Running Min / Max
7. Expand Around Center (palindrome)
8. Array Mapping — `int[26]` / `int[256]` instead of HashMap
9. Prefix Sum + HashMap (subarray sum)
10. Frequency Count + Bucket Sort
11. Kadane — negative prefix ko chhod do

**Binary Search**

12. Save & Eliminate
13. Rotated Sorted Array — ek half hamesha sorted hota hai
14. Slope Based (peak finding)
15. Binary Search on Answer — values pe search karo, indices pe nahi
16. Partition Binary Search (median of two sorted arrays)
17. Decimal BSoA — fixed iterations

**LinkedList**

18. Slow / Fast Pointers
19. Cycle Detection — Floyd, aur `L = nC − X` ka proof
20. k-gap Two Pointer
21. Merge Sort on LinkedList — relink karo, nodes copy mat karo
22. Two-Pointer Switch (intersection, O(1) space)
23. Divide & Conquer merge — O(N log k)

**Trees**

24. Recursive traversals — preorder, inorder, postorder
25. Iterative traversals via Stack
26. Iterative Postorder — reversed modified preorder
27. Level Order BFS — `q.size()` se level boundary
28. Bottom-Up Recursion — child ka return combine karo
29. Bottom-Up + Side Accumulator — return value ≠ answer value
30. Sentinel Return — ek return slot me do information (`-1` = unbalanced)
31. Simultaneous Recursion on Two Trees
32. Construction from Traversals — index calculate mat karo, **consume** karo

---

## Java Gotchas Collected

- `(long)a * b`, kabhi `(long)(a*b)` nahi — overflow pehle hi ho jaata hai
- `==` on `Integer` `−128..127` cache ke bahar fail karta hai — `Objects.equals()` use karo
- `Objects.equals(a,b)` = `(a==b) || (a!=null && a.equals(b))` — null-safe via short-circuit
- Java pass-by-value only hai — `int[] index = {0}` mutable counter ka idiomatic tarika
- `map.put(ch, j++)` — post-increment second argument store hone se pehle evaluate hota hai
- `char` array indexing ke liye auto-widen hota hai — koi boxing nahi, HashMap ke ulat
- `ArrayList.get/set` O(1) · `LinkedList.get(i)` O(n) — reverse loops me farak padta hai
- `Arrays.fill` fixed-size array pe O(1) hai, O(n) nahi
- `Math.ceil((double)a/b)` — explicit cast zaroori hai
- String immutable hai — loops me `StringBuilder`
- Tree recursion space **O(h) hai, O(n) nahi** — total frames created ≠ max frames alive
- `&&` short-circuit karta hai — recursion me manual early-exit check ki zaroorat nahi

---

## TLE Budget

Judge ~10^7 operations jhel leta hai (ceiling 10^8, par plan 10^7 pe karo).

| Constraint | Target |
|---|---|
| n ≤ 20 | O(2^n) |
| n ≤ 300 | O(n^3) |
| n ≤ 3000 | O(n^2) |
| n ≤ 10^5 | O(n log n) |
| n ≤ 10^7 | O(n) |
| n > 10^7 | O(log n) / O(1) |

Constraints hint section hain, decoration nahi.

---

## How I Work

- Har problem **brute → better → optimal**, har version ki complexity likhi hui
- Timebox: Easy 20 min · Medium 40 min · Hard 60 min. Alarm laga ke.
- Solution dekhne ke baad **blank file se dobara likhna**, bina kuch khole
- 3 din baad blind re-attempt
- Non-intuitive patterns ki alag **Hard Recall list** — sab questions ki nahi,
  sirf wo jo 2 mahine baad blank page pe re-derive nahi kar paunga

---

## Connect

- GitHub — https://github.com/ashish8112
- LinkedIn — https://www.linkedin.com/in/ashish-shukla81/
- LeetCode — https://leetcode.com/ashish-shukla81
- Email — ashishkrshukla.dev@gmail.com

---

*One pattern at a time.*
