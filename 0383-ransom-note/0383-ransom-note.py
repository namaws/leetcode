class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        arr = [0] * 26

        for char in magazine:
            arr[ord(char) - ord('a')] += 1
        
        for char in ransomNote:
            if arr[ord(char) - ord('a')] == 0:
                return False
            arr[ord(char) - ord('a')] -= 1
        return True
