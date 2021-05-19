from typing import List
from functools import cmp_to_key

class LargerNumKey(str):
    def __lt__(x, y):
        return x+y > y+x

class Solution:

    # Merge Intervals
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # sort intervals by start value
        intervals.sort(key= lambda num: num[0])
        merged = []
        for interval in intervals:
            if not merged or merged[len(merged)-1][1] < interval[0]:
                merged.append(interval)
            else:
                # overlap
                merged[-1][1] = max(merged[-1][1], interval[1])
        return merged

    # Largest Number
    def largest_number(self, nums: List[int]) -> str:
        if len(nums) < 1:
            return str(0)
        elif len(nums) == 1:
            return str(nums[0])
        else:
            nums = list(map(str, nums))
            nums.sort(key=LargerNumKey)
            print(nums)
            target_number = ""
            for i in range(len(nums)):
                target_number += nums[i]
            return target_number

    # return a negative value (< 0) when the left item should be sorted before the right item
    # return a positive value (> 0) when the left item should be sorted after the right item
    # return 0 when both the left and the right item have the same weight and should be ordered “equally” without precedence
    
    # H-index
    def h_index(self, citations: List[int]) -> int:
        return 0

solution = Solution()
#print(solution.merge([[1,3],[2,6],[8,10],[15,18]]))
print(solution.largest_number([3,30,34,5,9]))
