package io.github.zebinh.algorithmJava.algorithmBook.string;

/**
 * KMP算法 - DFA确定有限状态自动机
 * 红宝书
 */
public class KMPSearch02 {

    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int[][] dfa = new int[needle.length()+1][256];
        dfa[0][needle.charAt(0)] = 1;
        for (int i = 0, j = 1; j < needle.length(); j++) {
            for (int c = 0; c < 256; c++) {
                dfa[j][c] = dfa[i][c];
            }
            dfa[j][needle.charAt(j)] = j+1;
            i = dfa[i][needle.charAt(j)];
        }

        int j;
        int i;
        for (i = 0, j = 0; i < haystack.length() && j < needle.length(); i++) {
            j = dfa[j][haystack.charAt(i)];
        }
        if (j == needle.length()){
            return i - j;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String str = "";
        String pat = "";
        System.out.println(strStr(str, pat));
    }
}
