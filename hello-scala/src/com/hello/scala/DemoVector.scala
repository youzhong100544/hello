package com.hello.scala

/**
  * Vector内部结构与内存共享原理
  *
  *
  * Scala不可变集合
  * Scala不可变集合的设计目标是提供高效又安全的实现。这些集合中的大部分都是用高级技巧来在集合的不同版本之间“共享”内存。其中较长使用到的是Vector和List。
  * 在一般的编程任务中，不可变集合有很多超出可变集合的优点。尤其重要的一点是不可变集合可以在多线程之中共享而无需加锁。
  *
  * Vector内部结构
  * Scala的Vector实现为一组嵌套数组，在分割和连接时非常有效率。适用于大部分通用算法，因为它有高效的下标计算能力，以及能够在使用像+:和++方法时共享大部分内部结构的能力。
  * Vector采用分支系数为32的树状数据结构，分支因子是每个父节点允许拥有的最大子节点的数目。其随机访问（搜索或修改）复杂度是log_32(N)，使用32位整数下标时在JVM上是个效率不错的小常量，即使对很大的N来说都近似一个常量。
  * Vector是个由元素的下标组成的前缀树（trie），前缀树是给定路径上的所有子节点功用某种形式的公共键值。我们可以根据任何下标的二进制形式得到查找路径，实现高效的元素查找。
  *
  * Vector复制过程中的结构共享原理
  * 在实际应用中，为了保持变量的不可变性，对有用的集合进行复制通常是必要的。假设有一个包含100 000个元素的Vector，需要得到一个副本，并替换掉原Vector的第8个元素，此时如果构造一个全新的100 000个元素的Vector将会是极其低效的。
  * 为了兼顾高效和不可变性，可以通过共享原始Vector中的不变部分，而以某种方式表示变化部分，那么就可以高效地“创建”新Vector了。这种思想称之为结构共享。
  *
  * 如果其他线程中的代码正在对原始Vector做其他不同的操作，对原始的Vector的复制不会影响该操作，因为原Vector没有被修改。这样，只要对旧版本有一个或多个引用，就可以创建一个Vector的“历史”版本。直到对旧版本的引用消失为止，旧版本才会被垃圾回收。
  *
  *
  * Vector查找原理
  * Scala的Vector集合非常类似于一个分支系数为32的下标前缀树。关键区别在于Vector用一个数组来表示分支。这使整个结构变成数组的数组（嵌套数组）。
  * 下图是分支系数为2的二进制Vector：
  *
  * 其中有三个基本素组：display0、display1和display2.这些数组代表原始前缀树的深度。每个显示元素（display element）都是一个更深一层的的嵌套数组（display0是元素的数组，display1是数组的数组，display2是数组的数组的数组）。查找集合元素的步骤是先判断其深度，然后用跟前缀树一样的方式确定元素所在的数组。比如找数字4，其深度为2，所以先选择display2数组，4的二进制形式100，所以外层数组是下标为1的位置上，中层数组下标为0，最后4就位于结果数组的下标0的位置上。
  *
  * 二进制前缀树根据下标随机取值的复杂度是log_2(n)，Scala的Vector的分支系数为32，那么访问任何元素的时间复杂度是log_32(n)，对32位的下标也就大约是7，对64位大约是13.而对于较小的集合，排序的开销也会降低，所以访问速度会更快。所以随机访问的时间复杂度与前缀树的大小成正比。
  *
  * 小结
  * Scala的Vector为32分支，这除了带来查找时间和修改时间可以随集合大小伸缩外，它还提供了不错的缓存一致性，因为集合里相近的元素有很大可能位于同一个内存数组里。其高效结合不可变所带来的线程安全使之成为库里最强大的有序集合。
  * Scala的序列类型中Vector和List数据结构都是很常用的，Vector的所有操作都是O(1)（常数时间），而List对于那些需要访问头部以为元素的操作都需要O(n)操作，所以只在频繁执行头尾分解的情况下，推荐使用List。
  *
  *
  */
object DemoVector {

  def main(args: Array[String]): Unit = {

    // 创建 Vector
    var v = Vector(4, 1, 2, 3);
    println(v)
    // Vector 索引下标
    println(v(0))
    println(v(1))

    // Vector 的遍历
    v.foreach(print)
    println()
    // Vector 的遍历
    for (e <- v){
      print(e)
    }
    println()


    // 倒转 Vector
    // 使用 reverse 之后只是产生了一个新的Vector， 原 Vector 并不会改变
    var v2 = v.reverse
    v2.foreach(print)
    println()

    // Vector 排序
    v.sorted.foreach(print)
    println()


  }

}