from typing import List

class Solution:

    # Two Sum
    def two_sum(self, nums: List[int], target: int) -> List[int]:
        hash_map = {}
        result = []
        for index, number in enumerate(nums):
            difference = target - number
            if difference in hash_map.keys():
                result.append(hash_map[difference])
                result.append(index)
                break
            else:
                hash_map[number] = index
        return result

    # Reverse
    def reverse(self, x: int) -> int:
        result = 0
        input = x
        if x == 0:
            return 0
        else:
            while input != 0:
                input = abs(input)
                remainder = input % 10
                result = (result*10) + remainder
                input //= 10
            
            if result > 2**31-1 or result < -2**31:
                return 0
            else:
                if x > 0:
                    return result
                else:
                    return -result

    
    # Valid Anagram
    def is_anagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        else:
            sorted_source = sorted(s)
            sorted_target = sorted(t)
            for source_char, target_char in zip(sorted_source, sorted_target):
                if source_char != target_char:
                    return False
            return True

    # Intersection of Two Arrays
    def contain(self, number: int, int_array: List[int]) -> bool:
        if len(int_array) < 1:
            return False
        else:
            for num in int_array:
                if num == number:
                    return True
            return False

    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        intersect_part = []
        if len(nums1) < len(nums2):
            for number in nums1:
                if self.contain(number, nums2) and not self.contain(number, intersect_part):
                    intersect_part.append(number)
            return intersect_part
        else:
            for number in nums2:
                if self.contain(number, nums1) and not self.contain(number, intersect_part):
                    intersect_part.append(number)
            return intersect_part
    

solution = Solution()
# print(solution.two_sum([2, 7, 11, 15], 9))
# print(solution.reverse(1534236469))
# print(solution.is_anagram("rat", "car"))
# print(solution.intersection([4,9,5], [9,4,9,8,4]))
