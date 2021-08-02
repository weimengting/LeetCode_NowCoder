import re

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        #s为待匹配的字符串，p为用来匹配的模板
        s1 = re.compile(p).findall(s)
        print(re.compile(p))
        print(s)
        print(s1)
        if s1 == []:
            return False
        if s1[0] == s:
            return True
        else:
            return False



if __name__ == '__main__':
    ss = Solution()
    ss.isMatch('aa', 'a*')