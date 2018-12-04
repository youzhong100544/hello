package com.hello.hbase.util;

import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;

public class CommonUtil {

    public static byte [] rowkeyUtil(Long currentId){

        byte [] rowkey = Bytes.add(MD5Hash.getMD5AsHex(Bytes.toBytes(currentId)).substring(0, 8).getBytes(),Bytes.toBytes(currentId));

        return rowkey;
    }

    public static byte [] rowkeyUtil(String currentId){

        byte [] rowkey = Bytes.add(MD5Hash.getMD5AsHex(Bytes.toBytes(currentId)).substring(0, 8).getBytes(),Bytes.toBytes(currentId));

        return rowkey;
    }

    public static void main(String[] args) {
        long currentId = 1L;

        System.out.println(rowkeyUtil(currentId));


        System.out.println(rowkeyUtil("asfl123"));

    }
}
