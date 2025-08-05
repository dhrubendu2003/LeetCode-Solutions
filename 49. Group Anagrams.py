class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        anagram_groups = {}
        
        for s in strs:
            # Sort the characters to get the key for anagrams
            sorted_str = ''.join(sorted(s))
            
            # Add the string to its anagram group
            if sorted_str in anagram_groups:
                anagram_groups[sorted_str].append(s)
            else:
                anagram_groups[sorted_str] = [s]
        
        # Return all groups as a list of lists
        return list(anagram_groups.values())
