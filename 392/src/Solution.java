package src;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        Pair[] bucket = toBucket(t);
        char[] chars = s.toCharArray();
        int idx = -1;
        for (char c : chars) {
            Pair pair = bucket[c];
            idx = pair.binaryNext(idx);
            if (idx < 0) {
                return false;
            }
        }
        return true;
    }
    private Pair[] toBucket(String t) {
        Pair[] bucket = new Pair[128];
        for (int i = 0; i < 128; i++)
            bucket[i] = new Pair();
        char[] chars = t.toCharArray();
        for (int i = 0; i < chars.length; i++)
            bucket[chars[i]].list.add(i);
        return bucket;
    }
    private static class Pair {
        private int usedIndex = -1;
        private List<Integer> list = new ArrayList<>();
        private int binaryNext(int idx) {
            if (list.isEmpty())
                return -1;
            int left = usedIndex + 1;
            int right = list.size() - 1;
            do {
                if (left > right)
                    return -1;
                int cursor = (left + right) / 2;
                if (cursor > left && cursor < right) {
                    if (list.get(cursor) < idx) {
                        left = cursor;
                    }
                    if (list.get(cursor) > idx) {
                        right = cursor;
                    }
                } else {
                    if (list.get(left) >= idx) {
                        return list.get(usedIndex = left);
                    } else if (list.get(right) >= idx) {
                        return list.get(usedIndex = right);
                    } else {
                        return -1;
                    }
                }
            } while (true);
        }
    }

    public static void main(String[] args) {
        // Pair pair = new Pair();
        // pair.list.add(1);
        // pair.list.add(3);
        // pair.list.add(8);
        // pair.list.add(9);
        // pair.list.add(15);
        // pair.list.add(20);
        // pair.list.add(30);
        // System.out.println(pair.next(7) + "->" + pair.usedIndex);
        // System.out.println(pair.next(36) + "->" + pair.usedIndex);
        Solution solution = new Solution();
        solution.isSubsequence("aaaaaa", "bbaaaa");
    }
}