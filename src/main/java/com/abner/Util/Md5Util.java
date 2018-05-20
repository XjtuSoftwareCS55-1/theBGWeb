package com.abner.Util;

import java.security.MessageDigest;

public class Md5Util {

    public static String md5Encode(String msg) throws Exception{

        byte[] msgBytes = msg.getBytes("utf-8");
        /**
         * 声明使用Md5算法,获得MessaDigest对象
         */
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        /**
         * 使用指定的字节更新摘要
         */
        md5.update(msgBytes);
        /**
         * 完成哈希计算,获得密文
         */
        byte[] digest = md5.digest();
        /**
         * 以上两行代码等同于 byte[] digest = md5.digest(msgBytes);
         */
        return bytesToHexString(digest);
    }
    /**
     * 将byte数组转化为16进制字符串形式
     * @param bys
     * @return
     */

    public static String bytesToHexString(byte[] bys){
        StringBuffer hexVal=new StringBuffer();
        int val=0;
        for (int i = 0; i < bys.length; i++) {
            //将byte转化为int  如果byte是一个负数就必须要和16进制的0xff做一次与运算
            val=((int)bys[i]) & 0xff;
            if(val<16){
                hexVal.append("0");
            }
            hexVal.append(Integer.toHexString(val));
        }
        return hexVal.toString();
    }

//    public static void main(String[] args) throws Exception {
//        String msg="helloworld";
//        String result=md5Encode(msg);
//        String result1=md5Encode(msg);
//        System.out.println(result);
////        System.out.println(DigestUtils.md5Hex(msg));
//        System.out.println(result1);
//    }
}
