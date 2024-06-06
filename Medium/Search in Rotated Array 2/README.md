<h2><a href="https://www.geeksforgeeks.org/problems/search-in-rotated-array-2/1">Search in Rotated Array 2</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 14pt;">Given a sorted and rotated array <strong>arr</strong> of<strong> n</strong> elements and a target <strong>key</strong> which is rotated at some point, and may contain duplicates and given an element key. Check whether the key is present in array A or not.</span></p>
<p><span style="font-size: 14pt;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input:</strong>
n = 7
arr[] = {2,5,6,0,0,1,2}
key = 0
<strong>Output</strong>:
1
<strong>Explanation</strong>:
0 is found at index 3.</span></pre>
<p><span style="font-size: 14pt;"><strong>Example 2</strong>:</span></p>
<pre><span style="font-size: 14pt;"><strong>Input</strong>:
n = 7
arr[] = {2,5,6,0,0,1,2}
key = 3<strong>
Output</strong>:
0<strong>
Explanation</strong>:
There is no element that has value 3.</span></pre>
<p><span style="font-size: 14pt;"><strong>Your Task</strong>:</span></p>
<p><span style="font-size: 14pt;">You don't need to read input or print anything. Your task is to complete the function <strong>Search()</strong> which takes an integer N and an array A and the Key as input parameters and returns the answer.</span><br><br><span style="font-size: 14pt;"><strong>Expected Time Complexity</strong>: O(log n).</span><br><span style="font-size: 14pt;"><strong>Expected Auxiliary Space</strong>:&nbsp;O(1).</span></p>
<p><span style="font-size: 14pt;"><strong>Constraints</strong>:</span><br><span style="font-size: 14pt;">1 ≤ n ≤ 10<sup>5</sup></span><br><span style="font-size: 14pt;">0 ≤ arr[i] ≤ 10<sup>8</sup></span><br><span style="font-size: 14pt;">1 ≤ key ≤ 10<sup>8</sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Binary Search</code>&nbsp;<code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;