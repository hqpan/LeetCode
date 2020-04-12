[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 65
- 考察内容：字符串模式匹配；
- 相同问题：剑指 Offer 20；
- 字符串模式匹配：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；



# 2. 字符串模式匹配
- 解题思路：
  - 由题意可知，待匹配字符串内容由`.`、`E or e`分割为3部分；
    - 有符号整型数：整数部分；
    - 无符号整型数：小数部分；
    - 有符号整型数：指数部分；
  - 字符合法性判断：
    - 字符串前后空格不影响数值表示：将字符串去除首尾空格后处理；
    - 若存在`.`，则整数部分、小数部分二者有其一即可；
    - 若存在`E or e`，则底数部分、指数部分必须都存在；
  - 代码复用：判断有符号整型数的处理过程，可视为在判断无符号整型数的基础上，额外判断正负号；
- 程序实现细节：
  - 在`UnsignedInt`、`isUnsignedInt`函数中的 if 语句中判断`index < str.length()`，避免访问字符串越界；
  - 在`UnsignedInt`、`isUnsignedInt`函数中，用 index 的前后变化判断该部分数值是否存在；
  - 能否将 Solution 中的第11行替换为`ans = ans || isUnsignedInt();`？
    - A：不能，由于短路逻辑，若`ans = true`，将不再执行`isUnsignedInt`函数，小数部分的检测将无法执行；
  - 主函数中返回`ans && (index == str.length())`，确保字符串检测结束，即字符串尾部不含其它未检测的字符；

```java
class Solution {
    private String str;
    private int index = 0;
    public boolean isNumber(String s) {
        if (s == null)
            return false;
        this.str = s.trim();
        boolean ans = isSignedInt();
        if (index < str.length() && str.charAt(index) == '.') {
            ++index;
            ans = isUnsignedInt() || ans;
        }
        if (index < str.length() && (str.charAt(index) == 'e' || str.charAt(index) == 'E')) {
            ++index;
            ans = ans && isSignedInt();
        }
        return ans && (index == str.length());
    }

    public boolean isUnsignedInt() {
        int indexOriginal = index;
        while (index < str.length() && '0' <= str.charAt(index) && str.charAt(index) <= '9')
            ++index;
        return indexOriginal < index;
    }

    public boolean isSignedInt() {
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-'))
            ++index;
        return isUnsignedInt();
    }
}
```



# 3. Summary

## 3.1 Java 语法

- `&&`的优先级高于`||`，若两者并用，需考虑短路逻辑对运算结果的影响；



## 3.2 算法设计

- 将待匹配字符串一分为三的解决方案，详见上文；



# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.