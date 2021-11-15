package exercises;

public class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char [] arr = word.toCharArray();
        TrieNode [] curSuffix = root.suffix;
        for (int i = 0; i < arr.length; i++) {
            int char_index = (int)(arr[i] - 'a');
            if (null != curSuffix[char_index]) {
                curSuffix = curSuffix[char_index].suffix;
            } else {
                curSuffix[char_index] = new TrieNode();
                curSuffix = curSuffix[char_index].suffix;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (null == word || word.equals("")) {
            return true;
        }
        char [] arr = word.toCharArray();
        TrieNode [] curSuffix = root.suffix;
        for (int i = 0; i < arr.length; i++) {
            int char_index = (int)(arr[i] - 'a');
            if (null != curSuffix[char_index]) {
                curSuffix = curSuffix[char_index].suffix;
            } else {
                return false;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (null != curSuffix[i]) {
                return false;
            }
        }
        
        return true;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char [] arr = prefix.toCharArray();
        TrieNode [] curSuffix = root.suffix;
        for (int i = 0; i < arr.length; i++) {
            int char_index = (int)(arr[i] - 'a');
            if (null != curSuffix[char_index]) {
                curSuffix = curSuffix[char_index].suffix;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        
        t.insert("apple");
        t.search("apple");
        
    }
    
}

class TrieNode {
    TrieNode [] suffix;

    public TrieNode() {
        suffix = new TrieNode[26];
    }
}