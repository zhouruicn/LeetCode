public class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        Node temp;
        char[] chars = word.toCharArray();
        for (Character ch : chars) {
            temp = node.leaves[ch];
            if (null == temp) {
                temp = new Node();
                node.leaves[ch] = temp;
            }
            node = temp;
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        Node node = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            node = node.leaves[chars[i]];
            if (null == node) {
                return false;
            }
        }
        return ((null != node) && node.wordEnd);
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            node = node.leaves[chars[i]];
            if (null == node) {
                return false;
            }
        }
        return (null != node);
    }

    private class Node {

        private boolean wordEnd = false;

        private Node[] leaves = new Node[128];

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("appq"));
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
