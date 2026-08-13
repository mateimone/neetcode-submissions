class PrefixTree:

    def __init__(self):
        self.root = (-1, [None for i in range(26)])

    def insert(self, word: str) -> None:
        trie = self.root
        for i in range(len(word)):
            pos = 25 - (ord('z') - ord(word[i]))
            end = False
            if i == len(word) - 1:
                end = True
            if trie[1][pos] is None:
                trie[1][pos] = (end, [None for i in range(26)])
            elif end:
                (_, children) = trie[1][pos]
                trie[1][pos] = (end, children)
            trie = trie[1][pos] 


    def search(self, word: str) -> bool:
        trie = self.root
        for i in range(len(word)):
            pos = 25 - (ord('z') - ord(word[i]))
            print(trie, pos)
            if trie[1][pos] is None:
                return False
            if i == len(word) - 1:
                (end, children) = trie[1][pos]
                if end:
                    return True
                else:
                    return False
            trie = trie[1][pos]
        
        return True
        

    def startsWith(self, prefix: str) -> bool:
        trie = self.root
        for i in range(len(prefix)):
            pos = 25 - (ord('z') - ord(prefix[i]))
            if trie[1][pos] is None:
                return False
            trie = trie[1][pos]
        return True
