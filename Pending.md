# Deferred Approaches — Topic-Blocked Revisits

Ye un questions ki list hai jo **solve ho chuke hain**, lekin jinka ek aur (ya better) approach abhi nahi kiya
kyunki wo topic formally padha nahi gaya.

## Blocked on: HEAPS / PriorityQueue

### 1. Merge K Sorted Lists (LC 23)
- **Kiya hua:** Collect + `Collections.sort` - O(N log N) time, O(N) space
- **Kiya hua:** Divide & Conquer pairwise merge - O(N log k) time, O(log k) space
- **Pending:** Min-Heap approach
  - Har list ka head PriorityQueue mein daalo (size k)
  - Sabse chhota nikalo, result mein attach karo, uske `next` ko queue mein push karo
  - Repeat jab tak queue khaali na ho
- **Expected complexity:** O(N log k) time, **O(k) space**
- **Note:** Time same hai, space D&C se *kharaab* hai. Ye industry mein famous zyada hai, better nahi. Karne ka reason: heap ka usage samajhna, aur interview mein "aur koi approach?" ka jawab dena.

### 2. Top K Frequent Elements (LC 347)
- **Kiya hua:** HashMap + Bucket Sort — O(n) time, O(n) space
- **Pending:** Min-Heap of size k
  - Frequency map banao, phir har entry heap mein daalo
  - Heap size k se badi ho jaye toh smallest frequency nikaal do
  - Ant mein heap mein top-k bacha rahega
- **Expected complexity:** O(n log k) time, O(n + k) space
- **Note:** Bucket Sort **better hai** (O(n) vs O(n log k)). Heap wala isliye karna hai kyunki "Top K" ka standard heap pattern har jagah repeat hota hai (Kth Largest, K Closest Points, etc.)

---

## Blocked on: STACK

*(Abhi tak koi solved question yahan pending nahi hai - Trees ke iterative traversals mein Stack already use kar liya hai.)*

Jab Stack formally start ho, ye pattern aayenge (ye naye questions honge, revisit nahi):
Next Greater Element, Largest Rectangle in Histogram, Trapping Rain Water (stack approach - array approach already kiya hai prefix/suffix se)

**Note:** Trapping Rain Water agar Arrays mein kiya tha prefix/suffix se, toh Stack topic aane par usko stack approach se dobara attempt karna hai. — *confirm karna hai ki ye question kiya tha ya nahi*

---

## Blocked on: RECURSION (formal)

*(Recursion informally already use kar raha hai — Reverse LL recursive, tree traversals, Merge Sort. Formal topic aane par backtracking-based approaches khulenge.)*

---

## NOT topic-blocked — sirf pending hain

Ye wo hain jinka optimal approach **abhi ke knowledge se ho sakta hai**, bas kiya nahi:

| Question | Kiya hua | Pending |
|---|---|---|
| Reorder List (LC 143) | ArrayList brute — O(n) space | Middle + Reverse + Weave - O(1) space |
| Flatten Multilevel LinkedList | Concatenate + sort — O(n log n) | Merge-based fold (Sort List ka `merge` reuse) — O(1) space |
| Longest Repeating Character Replacement (LC 424) | Brute O(n²) | Sliding window O(n) |

---

## Rules for this file

1. Jab bhi koi question solve karo aur pata chale ki "iska ek aur approach hai jo abhi nahi kar sakta" - **turant yahan likho**, baad mein yaad nahi rahega
2. Har entry mein likhna: kya kiya, kya pending, expected complexity, aur **kya pending wala actually better hai ya sirf alternative hai**
3. Topic start hone par: pehle blind attempt, phir ye file kholo
4. Jo approach kar liya, usko yahan se hata do aur main notes mein le jao

---

*Last updated: 27 Aug 2026*
