package com.hello.spark.scala.util

import java.io.File

object CommomUtil {

  def deleteDir(dirPath: String): Boolean = {
    deleteDir(new File(dirPath))
  }
  /**
    * 删除一个文件夹,及其子目录
    *
    * @param dir
    *            将要删除的文件目录
    * @return
    */
  def deleteDir(dir: File): Boolean = {
    val files = dir.listFiles()
    files.foreach(f => {
      if (f.isDirectory) {
        deleteDir(f)
      } else {
        f.delete()
        println("delete file " + f.getAbsolutePath)
      }
    })
    dir.delete()
    println("delete dir " + dir.getAbsolutePath)
    true
  }
}
