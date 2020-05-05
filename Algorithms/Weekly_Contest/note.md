[TOC]



# 1. Background

- ；



# 2. 边界条件

- E.g. 现有数组`arr = [1, 2, 2, 3, 3, 3, ...]`，统计每个数值出现的次数；
  - 若以“数组中前后两个数值是否相等”作为判断出现次数的依据，则需要对数组中的最后一个元素设置额外的判定条件；
    - `E.g. arr = [1, 2, 2, 3]`，若该数值为数组中的最后一个元素，且与数组中的前一个数值不相等，则该数值的出现次数为1；
    - `E.g. arr = [1, 2, 2, 3, 3]`，若该数值为数组中的最后一个元素，且与数组中的前一个数值相等，则该数值的出现次数为当前索引减去上一个数值的索引；



# 3. 字符串处理

- `java.lang.String`：
  - `substring(int beginIndex, int endIndex)`：从某个字符串中取子字符串；
  - `public char[] toCharArray()`：将字符串转换为字符数组；
  - `public String trim()`：去除字符串首尾空格；
  - `public String replaceAll(String regex, String replacement)`：替换字符串中的部分字符；
    - `str.replaceAll(" ", ",");`：将字符串中所有空格替换为逗号；
  - `public static String valueOf(char[] data)`：将字符数组转换为字符串；
- `java.lang.StringBuilder`：
  - `public StringBuilder append(E b)`；
  - `public StringBuilder reverse()`；
  - `public String toString()`；
- 字符串长度、数组长度：
  - 字符串长度：`length()`函数；
  - 数组长度：`length`属性；

# 4. 集合类

- List：`List<List<Integer>> list = new ArrayList<List<>>()`；
  - `E get(int index)`；
  - `E remove(int index)`；
  - `Object[] toArray()`；
  - `<T> T[] toArray(T[] a)`：将`List`中的元素，作为特定类型的数组返回；
    - E.g. `list.toArray(new String[list.size()])`；
- Queue:
  - add；
  - poll；
  - peek；
  - remove；
  - isEmpty；
  - `Iterator<E> iterator()`；

```java
import java.util.Queue;
import java.util.LinkedList;
Queue<Integer> queue = new LinkedList<>();
```

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
- HashMap：`java.util.HashMap;`;
  - `public boolean containsKey(Object key)`；
  - `public boolean containsValue(Object value)`；
  - isEmpty；
  - `public V put(K key, V value)`；
  - `public V get(Object key)`；
  - `public Collection<V> values()`；
  - `public V remove(Object key)`；
  - size；
- HashSet：`java.util.HashSet`，集合中的元素无序、不重复；
  - `public boolean add(E e)`；
  - `public boolean remove(Object o)`；
  - `public boolean contains(Object o)`；
  - `public boolean isEmpty()`；
  - `public int size()`；

# 5. 返回值

- 返回数组：

```java
return int[] {1, 2};
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

- `Math.min()`：仅能接受两个参数；

# 8. 运算符

- 右移：
  - `>>`：有符号右移；
  - `>>>`：无符号右移；