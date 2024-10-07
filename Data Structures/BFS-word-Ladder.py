
def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
    arr = set(wordList)
    q = collections.deque([(beginWord, 1)])
    visited = set()
    alpha = string.ascii_lowercase
    
    while q:
        start, lenght = q.popleft()
        
        if start == endWord:
            return lenght
        
        for i in range(len(start)):
            for ch in alpha:
                new_word = start[:i] + ch + start[i+1:]
                if new_word in arr and new_word not in visited:
                    q.append((new_word, lenght+1))
                    
                    visited.add(new_word)
                    
    return 0
