from typing import List
from functools import cmp_to_key

class LargerNumKey(str):
    # sort() in python3 will override this
    def __lt__(x, y):
        return x+y < y+x

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
            nums.sort(key=LargerNumKey, reverse=True)
            print(nums)
            # for i in range(len(nums)-1):
            #     if int(nums[i]+nums[i+1]) < int(nums[i+1]+nums[i]):
            #         temp = nums[i]
            #         nums[i] = nums[i+1]
            #         nums[i+1] = temp
            #     else:
            #         continue 
            
            # print(nums)
            if int(nums[0]) == 0:
                return str(0)
            else:
                target_number = ""
                for i in range(len(nums)):
                    target_number += nums[i]
                return target_number
    
    # 274. H-Index
    def h_index(self, citations: List[int]) -> int:
        citations.sort()
        for index, citation in enumerate(citations):
            h_index = len(citations) - index
            # print(h_index, " ", citation)
            if h_index <= citation:
                return h_index
        return 0

    # [1,3,1] 
    # h = 1 paper (>= 1 citation) -> 3
    # n-h = 2 papers (<= 1 citation) -> 1, 1
    # => H-index = 1

    # [3,0,6,1,5]
    # h = 3 papers (>= 3 citations) -> 3, 6, 5
    # n-h = 2 papers (<= 3 citations) -> 0, 1
    # => H-index = 3

solution = Solution()
# print(solution.merge([[1,3],[2,6],[8,10],[15,18]]))
# print(solution.largest_number([74,21,33,51,77,51,90,60,5,56]))
# print(solution.h_index([3,0,6,1,5]))
