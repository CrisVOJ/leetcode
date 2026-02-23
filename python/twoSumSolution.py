''' Two Sum

Problem link: https://leetcode.com/problems/two-sum/

Idea: This time, I tried a different approach. When iterating through the list, I start from index 1. I had seen this solution before but didn't fully understand it until I applied it myself. Starting from index 1 makes the iteration more efficient by eliminating at least one unnecessary comparison. Additionally, this approach avoids use duplicated indices.

Complexity: O(n^2)
'''

from typing import List

def twoSum(nums: List[int], target: int) -> List[int]:
    m = {}
    for i,num in enumerate(nums):
        if target-num in m:
            return [i,m[target-num]]
        m[num] = i

print(f"Solution {twoSum([2, 7, 11, 15], 9)}")
print(f"Solution {twoSum([3, 2, 4], 6)}")
print(f"Solution {twoSum([3, 3], 6)}")