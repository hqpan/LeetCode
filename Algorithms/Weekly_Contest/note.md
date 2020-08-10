[TOC]



# 1. Background

- Java 常用语法；

# 2. 条件判断

- switch；

```java
switch(expression){
    case value1 : expression1; break;
    case value2 : expression2; break;
    default : expression3;
}
```

# 3. 字符串处理

- 对`String`变量赋值：
  - `String`指向的内容不可变，但`String`中存储的对象引用是可变的；
  - E.g. `String str = "aaa";   str = "bbb";`；
  - 对`String`变量赋值的实质是，在内存中开辟新的空间保存新的字符串值，将`String`变量的引用指向新的内存空间；
- `java.lang.String`：
  - `java.lang.String`：`public char charAt(int index)`，索引从 0 开始；
  - `public int compareTo(String anotherString)`：比较两个字符串的字典序大小；
  - 字符串切片：
    - `public String substring(int beginIndex)`：截取起始索引至字符串结尾的字符；
    - `public String substring(int beginIndex, int endIndex)`：截取起始索引至`endIndex - 1`的字符；
    - 注意：`substring`方法的索引从0开始计数；
  - `public char[] toCharArray()`：将字符串转换为字符数组；
  - `public String trim()`：去除字符串首尾空格；
  - `public String replaceAll(String regex, String replacement)`：替换字符串中的部分字符；
    - `str.replaceAll(" ", ",");`：将字符串中所有空格替换为逗号；
  - `public static valueOf(T val)`：将 Object、boolean、char、int、long、float、double 转换为字符串；
  - `public static String valueOf(char[] data)`：将字符数组转换为字符串；
- `java.lang.StringBuilder`：
  - `public StringBuilder append(E b)`；
  - `public StringBuilder reverse()`；
  - `public String toString()`；
- 字符串长度、数组长度：
  - 字符串长度：`length()`函数；
  - 数组长度：`length`属性；

# 4. 集合类

- `foreach`语法：适用于数组和集合类；

- `java.util.List`：List 接口，`get()`和`size()`方法也可用于遍历；
  - `List<List<Integer>> list = new ArrayList<List<>>()`；
  - `E get(int index)`；
  - `E remove(int index)`；
  - `int size()`；
  - `boolean isEmpty()`；
  - `Object[] toArray()`；
  - `<T> T[] toArray(T[] a)`：将`List`中的元素，作为特定类型的数组返回；
    - E.g. `list.toArray(new String[list.size()])`；
  
- `java.util.Deque`：接口，双端队列；
  
  - `Deque<T> deque = new Deque<>();`；
  
- `java.util.LinkedList`：类；
  - `public void addFirst(E e)`：将元素逐个添加到集合首部，从而得到反序的结果；
  - `public void addLast(E e)`；
  - `public E getFirst()`；
  - `public E getLast()`；
  - `public E peekFirst()`；
  - `public E peekLast()`；
  - `public E pollFirst()`；
  - `public E pollLast()`；
  - `public int size()`；
  - `public Object[] toArray()`；
  
- `java.util.Collections`：
  
  - `public static void reverse(List<?> list)`：将`list`中所有元素反序；
  
- `java.util.Queue`：接口；
  
  - `add()`；
  - `peek()`；
  - `poll()`；
  - `remove()`；
  
  - `isEmpty`；
  - `Iterator<E> iterator()`；
  
- PriorityQueue：`java.util.PriorityQueue`；
  - 构造函数：
    - `public PriorityQueue()`：默认容量为11，不指定比较器时，默认为最小堆；
    - `public PriorityQueue(int initialCapacity)`；
    - `public PriorityQueue(Comparator<? super E> comparator)`：比较器用于确定优先队列中数值的顺序；
    - `public PriorityQueue(int initialCapacity, Comparator<? super E> comparator)`；
    - 若优先队列中存放自定义类型数据，则需提供比较器；
    - ==注意==：比较器的 lambda 表达式写法：
      - `PriorityQueue<Integer> heap = new PriorityQueue<>((val1, val2) -> val1 - val2);`：最小堆；
      - `PriorityQueue<Integer> heap = new PriorityQueue<>((val1, val2) -> val2 - val1);`：最大堆；
      - 括号中的`(val1, val2)`表示函数参数，`->`后的`val1 - val2`表示函数返回值；
      - E.g. `Queue<ListNode> heap = new PriorityQueue<>((x, y) -> x.val - y.val)`；
  - `public boolean add(E e)`：时间复杂度$O(logn)$；
  - `public E peek()`：时间复杂度$O(1)$；
  - `public E poll()`：时间复杂度$O(logn)$；
  - `public boolean remove(Object o)`：时间复杂度$O(n)$；
  - `public boolean contains(Object o)`：时间复杂度$O(n)$；
  - `public int size()`；
  - `public Object[] toArray()`；
  - `public <T> T[] toArray(T[] a)`；
    - Java 中的强制类型转换仅针对单个对象，无法对数组实现强制类型转换；
    - 该方法可将集合对象转换为特定类型的数组，E.g. String、Integer；
    - 若题目要求返回值为`int`类型，则返回`Integer`类型的数组将报错，因为无法对数组执行强制类型转换（自动拆箱）；
  
- Stack：`java.util.Stack`；
  - push；
  - pop；
  - peek；
  - remove；
  - isEmpty；
  - `Iterator<E> iterator()`；
  
- Arrays：`java.util.Arrays`；
  - `public LinkedList(Collection<? extends E> c)`：将实现`Collection`接口的集合中所有元素，用于创建`LinkedList`；
  - `public static void sort(E[] arr)`；
  - `public static String toString(E[] a)`；
  - `public static T[] copyOfRange(T[] original, T from, T to)`：取子数组，含起始索引，不含终止索引，因此终止索引的值可不位于数组中；
  
- ArrayList：`java.util.ArrayList`；
  - add；
  - `public boolean contains(Object o)`；
  - `public E get(int index)`；
  - `public int indexOf(Object o)`；
  - isEmpty；
  - `Iterator<E> iterator()`；
  - remove；
  - `public Object[] toArray()`；
  - size；
  
- HashMap：`java.util.HashMap;`；
  - `public void clear()`；
  - isEmpty；
  - size；
  - `public boolean containsKey(Object key)`；
  - `public boolean containsValue(Object value)`；
  - `public V put(K key, V value)`；
  - `public V get(Object key)`：若无对应键，则返回 null；
  - `public V remove(Object key)`；
  - `public Collection<V> values()`；
  
- HashSet：`java.util.HashSet`，集合中的元素无序、不重复；
  - `public boolean add(E e)`；
  - `public boolean remove(Object o)`；
  - `public boolean contains(Object o)`；
  - `public boolean isEmpty()`；
  - `public int size()`；

# 5. 返回值

- 返回数组：

```java
return new int[] {1, 2};
return new int[0];
```

- 返回二维数组：

```java
List<int[]> res = new ArrayList<>();
res.add(row);
return res.toArray(new int[res.size()][]);
```

# 6. 输入输出

- Scanner 类；

```java
import java.util.Scanner;
Scanner in = new Scanner(System.in);
```

- `next()`、`nextLine()`方法：
  - `public String next()`：以空格为结束符；
  - `public String nextLine()`：以 Enter 为结束符；
  - `public double nextDouble()`；
  - `public float nextFloat()`；
  - `public int nextInt()`；
  - ==注意==：E.g. `1,2,3,4,5`，当处理完数值5后，检测是否还有输入值？
    - 若使用`hasNext()`则返回`false`；
    - 若使用`hasNextLine()`则返回true，因为5后面还有`\n`；
- ==注意==：使用`for`循环结合`nextInt()`，读取多个输入数据，不易出错；
- 判断是否还有输入值：
  - `public boolean hasNext()`；
  - `public boolean hasNextLine()`；
  - `public boolean hasNextDouble()`；
  - `public boolean hasNextFloat()`；
  - `public boolean hasNextInt()`；
- 类型转换：
  - `public static double parseDouble(String s)`；
    - `Double.parseDouble(String s)`；
  - `public static float parseFloat(String s)`；
    - `Float.parseFloat(String s)`；
  - `public static int parseInt(String s)`；
    - `Integer.parseInt(String s)`；
- 切分字符串：`public String[] split(String regex)`；
- 读取一行用空格分隔的数值：`String[] nums = in.nextLine().split(" ");`；

# 7. 数值计算

- 大小比较：
  - `Math.min()`：可比较`int`、`long`、`double`等类型的数据，并返回对应类型的值；
  - `Math.min()`：仅能接受两个参数，嵌套调用该函数即可实现多值比较；
- 随机数：
  - `java.util.Random`：创建`Random`对象，对其调用以下方法；
    - `public boolean nextBoolean()`；
    - `public int nextInt()`：随机返回一个整数值，$[-2^{31}, 2^{31} - 1]$；
    - `public int nextInt(int bound)`：返回`[0, bound)`之间的一个随机值；
    - `public float nextFloat()`：$[0.0, 1.0]$；
    - `public double nextDouble()`：$[0.0, 1.0]$；
  - `java.lang.Math`：`public static double random()`，$[0.0, 1.0)$；
- `java.math.BigInteger`：
  - 构造器：`public BigInteger(String val)`；
  - `public BigInteger add(BigInteger val)`；
  - `public BigInteger subtract(BigInteger val)`；
  - `public BigInteger multiply(BigInteger val)`；
  - `public BigInteger divide(BigInteger val)`；
  - `public String toString()`；
- `java.math.BigDecimal`：
  - 构造器：`public BigDecimal(String val)`；
  - `public BigDecimal add(BigDecimal augend)`；
  - `public BigDecimal subtract(BigDecimal subtrahend)`；
  - `public BigDecimal multiply(BigDecimal multiplicand)`；
  - `public BigDecimal divide(BigDecimal divisor)`；
  - `public String toString()`；

# 8. 运算符

- 有符号整数：Java 编译器中使用二进制补码表示有符号整数；
  - E.g. -1的二进制表示为`1111_1111_1111_1111_1111_1111_1111_1111`；
  - 若对-1执行`>>`运算，结果仍为-1；
- 常考察的符号：`==`运算符的优先级高于部分逻辑运算符和位运算符；
  - `~`：非；
  - `^`：异或，缩写：xor，abbr. 异或；
  - `<<`：左移，仅调整数值位，不改变符号位，E.g. 不影响负数的符号位；
  - `>>`：算数右移，亦称有符号右移，高位用符号位填充；
  - `>>>`：逻辑右移，亦称无符号右移：高位用0填充；

# 9. 常见算法

## 9.1 排序

### 9.1.1 快速排序

- partition 函数：快速排序算法的一部分，可用于求解数组中第 n 大的数；==应掌握该函数==

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 7, 4, 9, 2, 5, 1, 6, 8};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi)
            return;
        int index = partition(nums, lo, hi);
        sort(nums, lo, index - 1);
        sort(nums, index + 1, hi);
    }

    public static int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int base = nums[lo];
        while (true) {
            while (nums[++i] < base)
                if (i == hi)	// notes
                    break;
            while (nums[--j] > base)
                if (j == lo)	// notes
                    break;
            if (i >= j)
                break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    public static void exch(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

```

### 9.1.2 自定义比较器

-  用函数实现自定义比较器：被排序的数组必须为引用数据类型，不能为基本数据类型，参见剑指 Offer 45；

```java
Arrays.sort(strs, new Comparator<>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });
```

- 用 Lambda 表达式实现自定义比较器：被排序的数组必须为引用数据类型，不能为基本数据类型，参见剑指 Offer 45；

```java
Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
```

# 10. 基本数据类型

- 求`int`、`long`类型数值中某一位的值：
  - `public static String toString(int i)`：将整型值转换为字符串；
  - `public static String toString(long i)`：将长整型值转换为字符串；
  - `public char charAt(int index)`：以字符的形式返回某一位上的值；
  - `return ans - '0'`：即可得对应的整数值；
  - ==注意==：此处不可使用`(int) ans`，该语句将返回 ASCII 码对应的整数值，而非字符表示的整数值；

# 11. 其它语法

- `do...while`的语法格式：

```java
do {
    // ...
} while (...);
```

# 12. LeetCode & 剑指 Offer 复习计划

## 12.1 LeetCode

- LeetCode 191，231，461 & 剑指 Offer 15：
  - 汉明重量：一串符号中非零符号的个数，本题中指二进制数中各比特位上 1 的个数；
  - 汉明距离：两个相同长度的二进制数中，对应比特位不相等的数量；
  - 若一个数为 2 的幂次方，则该数的二进制表示形式中，仅有一个比特位的值为 1；
  - 去除最右侧的 1：对于数值`n`，`n&(n-1)`即可去除`n`二进制形式中，最右侧的非零比特位；
  - 保留最右侧的 1：由于负数用补码形式表示，若存在一个整数 num，则`num&(-num)`仅保留 num 二进制表示形式中最右侧的1；

## 12.2 剑指 Offer

- 剑指 Offer 3：选取原地标记数组的方式时，为什么不将对应值取反，而是减去 n？
  - 因为本题数组中元素取值范围$[0,n-1]$；
  - 若取反，则无法表示 0 已被标记过；
- 剑指 Offer 13：在 DP 解法中，对矩阵中元素位置关系的分类；
  - $i==0,j==0$；
  - $i>0$；
  - $j>0$；
  - 注意：$i>0,j>0$包含在第 2、3 种情况中，被计算 2 次；