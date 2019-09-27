[TOC]



# 1. LeetCode 9

- 逐位比较：
  - 对原数值取余后，逐位存入数组，首尾比较；
  - 对原数值首部取整，尾部取余，进行比较；
    - E.g. inputNum = 12321，对10000取整，对10取余，将两者的结果进行比较；
  - 取余的同时计算翻转后的数值；
    - `reverseNum = reverseNum * 10 + originalNum % 10`；
  - 若输入的整数位数为 n，则该方法仅需执行 n 次取余运算；
- 将整数转换为字符串；
- 反转一半数字;
  - 若输入的整数位数为 n，则该方法仅需执行$\frac{n}{2}$次取余运算；



# 2. 将整数转换为字符串

- 核心步骤：
  - `x + ""`，将整型值转换为字符串类型，添加到字符串构建器中；
  - `StringBuilder`类的`reverse()`方法可将字符串反转；
  - `toString()`方法将`StringBuilder`中的字符串赋值给某个变量；
  - 注意：对于非常见数据类型的比较，需要使用`equals()`方法而非`==`；

```java
String reverseString = (new StringBuilder(x + "")).reverse().toString();
return (x + "").equals(reverseString);
```



# 3. 反转一半的数字

- 反转后半部分的数字，判断是否与前半部分相等；
- 对特殊情况的处理：
  - 输入数据为奇数位；
    - `return (x == num) || (x == num / 10)`；
  - 若输入数值的最后一位为0，为使该数值为回文数，该值的第一位也应为0，即该值为0；
    - 易错测试用例：E.g. 10；
      - 该错误可由`return (x == num) || (x == num / 10)`引起，因此需要加入判断条件；