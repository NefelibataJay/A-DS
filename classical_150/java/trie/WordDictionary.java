package classical_150.java.trie;

import java.util.*;

public class WordDictionary {

    private Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Trie node) {
        if (index == word.length())
            return node.isEnd();

        char ch = word.charAt(index);
        if (Character.isLetter(ch)) {
            int childrenIndex = ch - 'a';
            Trie child = node.getChildren()[childrenIndex];
            if (child != null)
                return dfs(word, index + 1, child);
        } else {
            for (int i = 0; i < 26; i++) { // 获取每一个子节点
                Trie child = node.getChildren()[i];
                if (child != null && dfs(word, index + 1, child))
                    return true;
            }
        }
        return false;
    }
}
