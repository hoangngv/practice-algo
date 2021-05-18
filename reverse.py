def reverse(x: int) -> int:
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

print(reverse(1534236469))