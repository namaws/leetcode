class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        mapping = {}
        for c1, c2 in zip(s, t):
            if c1 not in mapping:
                if c2 in mapping.values():
                    return False
                mapping[c1] = c2
            else:
                if mapping[c1] != c2:
                    return False
            
        return True
