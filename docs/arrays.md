
# Arrays

## Unique Subarrays

https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/unique-subarrays/

A contiguous subarray is defined as unique if all the integers contained within
it occur exactly once. There is a unique weight associated with each of the
subarray. Unique weight for any subarray equals it's length if it's unique, 0
otherwise. Your task is to calculate the sum of unique weights of all the
contiguous subarrays contained within a given array.

#### Input

First line of the input contains an integer T, denoting the number of testcases.

2 * T lines follow, where first line of each testcase contains an integer N
denoting the number of integers in the given array. Last line of each testcase
then contains N single space separated integers

#### Output

Print the summation of unique weights of all the subarrays for each test case in a separate line.

#### Constraints

    1 <= T,N <=10^5
    0 <= Ai <= 10^9
    Summation of N for all T does not exceed 10^5

#### Sample Input
1
5
1 2 3 4 5
#### Sample Output
35

Sample Case 1: Since, all integers are distinct within any contiguous
subarray, therefore the unique weight will be the summation of lengths of all
subarrays. Hence, this sums up to 5 + 4*2 + 3*3 + 2*4 + 1*5 = 35


### Solution notes

See `ArraySubarrays`

Array.sliding(len).distinct is a brute force option, but takes too long.  The
two-pointer algorithm and formula is more efficient. See commentary on this and
similar applications of the two-pointer algorithm at
- https://tp-iiita.quora.com/The-Two-Pointer-Algorithm

