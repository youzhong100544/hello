package com.hello.scala.ActorDemo;

/**
Scala的Actor类似于Java中的多线程编程。
但是不同的是，Scala的Actor提供的模型与多线程有所不同。
Scala的Actor尽可能地避免锁和共享状态，从而避免多线程并发时出现资源争用的情况，进而提升多线程编程的性能。
此外，Scala Actor的这种模型还可以避免死锁等一系列传统多线程编程的问题。

Spark中使用的分布式多线程框架，是Akka。
Akka也实现了类似Scala Actor的模型，其核心概念同样也是Actor
 */
