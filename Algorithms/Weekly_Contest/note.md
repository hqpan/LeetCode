[TOC]



# 1. Background

- 



# 2. 边界条件

- E.g. 现有数组`arr = [1, 2, 2, 3, 3, 3, ...]`，统计每个数值出现的次数；
  - 若以“数组中前后两个数值是否相等”作为判断出现次数的依据，则需要对数组中的最后一个元素设置额外的判定条件；
    - `E.g. arr = [1, 2, 2, 3]`，若该数值为数组中的最后一个元素，且与数组中的前一个数值不相等，则该数值的出现次数为1；
    - `E.g. arr = [1, 2, 2, 3, 3]`，若该数值为数组中的最后一个元素，且与数组中的前一个数值相等，则该数值的出现次数为当前索引减去上一个数值的索引；



# 3. Java 中常用的方法

- `substring()`：从某个字符串中取子字符串；

```java
substring(int beginIndex, int endIndex)
```

- `Math.min()`：仅能接受两个参数；



# 4. Java 中常用的类

- List：对于`List`可使用`get(index)`方法，按索引返回`List`的对应元素；

```java
List<List<Integer>> list = new ArrayList<List<>>();
```

- Queue:

```java
Queue<Integer> queue = new LinkedList<>();
```

