package leetcode_hot_100.graph;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple"); // 返回 True
        trie.search("app"); // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app"); // 返回 True
    }

    class TreeNode {
        char value;
        TreeNode[] next = new TreeNode[26];
        boolean isEnd = false;

        public TreeNode() {
        }

        public TreeNode(char value) {
            this.value = value;
        }
    }

    TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = root;
        for (int j = 0; j < word.length(); j++) {
            if (node.next[word.charAt(j) - 97] == null)
                node.next[word.charAt(j) - 97] = new TreeNode(word.charAt(j));
            node = node.next[word.charAt(j) - 97];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode node = root;
        for (int j = 0; j < word.length(); j++) {
            if (node.next[word.charAt(j) - 97] == null)
                return false;
            node = node.next[word.charAt(j) - 97];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (int j = 0; j < prefix.length(); j++) {
            if (node.next[prefix.charAt(j) - 97] == null)
                return false;
            node = node.next[prefix.charAt(j) - 97];
        }
        return true;
    }
}
