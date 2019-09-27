[TOC]



# 1. LeetCode 1184

- 遍历数组求和；



# 2. 遍历数组求和

- 遍历数组求和：
  - 比较`start`和`destination`的大小，若后者小于前者，则交换两者的数值；
  - 分两部分求和：
    - Part 1：对`start`-`destination`之间的所有元素求和；
    - Part 2：对`0`-`start`和`destination`-`distance.length`之间的元素求和；