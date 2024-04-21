<h2><a href="https://www.geeksforgeeks.org/problems/rearrange-an-array-such-that-arri-i3618/1?page=8&category=Arrays&difficulty=Easy&status=unsolved&sortBy=submissions">Rearrange an array such that arr[i] = i</a></h2><h3>Difficulty Level : Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array of size N that has elements ranging from 0 to N-1. All elements may not be present in the array. If the element is not present then there will be -1 present in the array. Rearrange the array such that A[i] = i, and if i is not present, display -1 at that place.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>â€‹Input :</strong> arr[ ] = {-1, -1, 6, 1, 9, 3, 2, 
                              -1, 4, -1}
<strong>Output :</strong> -1 1 2 3 4 -1 6 -1 -1 9
<strong>Explanation:</strong>
In range 0 to 9, all except 0, 5, 7 and 8 
are present. Hence, we print -1 instead of 
them.

</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input :</strong> arr[ ] = {0, 1, 2, 3, 4, 5} <strong>
Output :</strong> 0 1 2 3 4 5</span></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong></span></p>

<p><span style="font-size:18px">This is a function problem. The input is already taken care of by the driver code. You only need to complete the function <strong>modifyArray()</strong> that takes an array <strong>(arr)</strong>, sizeOfArray <strong>(n)</strong>, and return the modified array. The driver code takes care of the printing.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N).<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1).</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>5</sup><br>
0 ≤ A[i] ≤ N-1</span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Hash</code>&nbsp;<code>Data Structures</code>&nbsp;