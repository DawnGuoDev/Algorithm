package string;

public class Trie {
    private TrieNode root = new TrieNode('/');

    /**
     * 往 Trie 树中插入字符串
     * @param text
     */
    public void insert(char[] text) {
        TrieNode p = this.root;

        for (char ch : text) {
            int i = ch - 'a'; // 计算相应的下标
            if (p.childrens[i] == null) {
                TrieNode newNode = new TrieNode(ch);
                p.childrens[i] = newNode;
            }

            p = p.childrens[i];
        }

        p.isEndingChar = true;
    }

    /**
     * 匹配字符串
     * @param text
     * @return
     */
    public boolean search(char[] text) {
        TrieNode p = root;

        for (char ch : text) {
            int i = ch - 'a';
            if (p.childrens[i] == null) {
                return false;
            }

            p = p.childrens[i];
        }

        if (p.isEndingChar) {
            return true;
        }

        return false;
    }

    public static class TrieNode {
        public char data;
        public TrieNode[] childrens = new TrieNode[26];
        public boolean isEndingChar;

        public TrieNode(char data) {
            this.data = data;
        }
    }    


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcd".toCharArray());
        trie.insert("bfa".toCharArray());
        trie.insert("cbn".toCharArray());

        System.out.println(trie.search("das".toCharArray()));
        System.out.println(trie.search("abcd".toCharArray()));
        System.out.println(trie.search("cb".toCharArray()));
    }
}