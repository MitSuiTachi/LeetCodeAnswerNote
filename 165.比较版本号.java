/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
public class Solution {
    // 比较 version1 和 version2
    // version1 > version2 返回1
    // version1 < version2 返回-1
    // 除此之外返回0
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int index = 0;
        while (index < s1.length && index < s2.length) {
            // Integer.valueOf(String s) 方法可以直接针对前导0做去除
            if (Integer.valueOf(s1[index]) > Integer.valueOf(s2[index])) {
                return 1;
            } else if (Integer.valueOf(s1[index]) < Integer.valueOf(s2[index])) {
                return -1;
            }
            index++;
        }
        if (s1.length == s2.length) {
            return 0;
        }
        if (index == s1.length) {
            while (index < s2.length) {
                if (Integer.valueOf(s2[index]) > 0) {
                    return -1;
                }
                index++;
            }
        } else {
            while (index < s1.length) {
                if (Integer.valueOf(s1[index]) > 0) {
                    return 1;
                }
                index++;
            }
        }
        return 0;
    }
}

/**
 * 下列方法没有通过全部测试case
 * 解决思路是对两个版本号的修订号进行依次对比
 * 只不过对比时采用charAt()方法取出修订号的每一位进行比较
 * 这种方式在对比1.5和1.10这种时会出错
 * 实际 1.5 < 1.10 如下方式会导致 1.5 > 1.10
 */
// class Solution {
//     // 比较 version1 和 version2
//     // version1 > version2 返回1
//     // version1 < version2 返回-1
//     // 除此之外返回0
//     public int compareVersion(String version1, String version2) {
//         String[] v1 = version1.split("\\.");
//         String[] v2 = version2.split("\\.");
//         int i = 0;
//         for (; i < v1.length && i < v2.length;) {
//             String s1 = v1[i];
//             String s2 = v2[i];
//             int result = compareRevision(s1, s2);
//             if (result == 0) {
//                 i++;
//             } else {
//                 return result;
//             }
//         }
//         if (i == v1.length && i == v2.length) {
//             return 0;
//         }
//         两个版本号长度不一致时需要继续往后比较
//         需要考虑 1.1 和 1.1.0.0.0 其实是相等的情况
//         if (i == v1.length) {
//             while (i < v2.length) {
//                 if (isRevisionZero(v2[i])) {
//                     i++;
//                 } else {
//                     return -1;
//                 }
//             }
//         } else {
//             while (i < v1.length) {
//                 if (isRevisionZero(v1[i])) {
//                     i++;
//                 } else {
//                     return 1;
//                 }
//             }
//         }
//         return 0;
//     }

//     private int compareRevision(String revision1, String revision2) {
//         int index1 = 0;
//         int index2 = 0;
//
//         找到第一个不为0的修正号
//         while (index1 < revision1.length() && revision1.charAt(index1) == '0') {
//             index1++;
//         }
//         while (index2 < revision2.length() && revision2.charAt(index2) == '0') {
//             index2++;
//         }
//         while(index1 < revision1.length() && index2 < revision2.length()) {
//             if (revision1.charAt(index1) > revision2.charAt(index2)) {
//                 return 1;
//             } else if (revision1.charAt(index1) < revision2.charAt(index2)) {
//                 return -1;
//             }
//             index1++;
//             index2++;
//         }
//         if (index1 == revision1.length() && index2 == revision2.length()) {
//             return 0;
//         }
//         return index1 == revision1.length() ? -1 : 1;
//     }
    
//     private boolean isRevisionZero(String revision) {
//         int index = 0;
//         while (index < revision.length() && revision.charAt(index) == '0') {
//             index++;
//         }
//         return index == revision.length() ? true : false;
//     }
// }
// @lc code=end

