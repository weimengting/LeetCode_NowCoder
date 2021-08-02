class Solution:
    def isValid(self, s):
        while '{}' in s or '()' in s or '[]' in s:
            s = s.replace('{}', '')
            s = s.replace('[]', '')
            s = s.replace('()', '')
        return s == ''

if __name__ == '__main__':
    ss = Solution()
    s  = ss.isValid("()[]{}")
    print(s)