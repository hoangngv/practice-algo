from typing import List

class Solution:
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

solution = Solution()
print(solution.two_sum([2, 7, 11, 15], 9))
print(solution.reverse(1534236469))
