package org.kly.infrastructure.utils;

import org.apache.commons.lang3.StringUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用了这个CF页面上的算法
 * Murmur哈希sh是一种非加密性的哈希函数 对规律性较强的key 随机分布（离散性）更好，redis sharding使用
 * Murmur哈希是一种非加密散列函数，适用于一般的基于散列的查找。它在2008年由Austin Appleby创建，在Github上托管，
 * 名为“SMHasher” 的测试套件。 它也存在许多变种，所有这些变种都已经被公开。 该名称来自两个基本操作，乘法（MU）和旋转（R），在其内部循环中使用。
 * 与加密散列函数不同，它不是专门设计为难以被对手逆转，因此不适用于加密目的。
 */
public class HashUtils {


    static public int hash(String data, int seed, boolean i) {
        if (StringUtils.isBlank(data)) {
            return 0;
        }

        byte[] dataBytes = data.getBytes();

        return hash(dataBytes, 0, dataBytes.length, seed);
    }

    static public int hash(String data, int range) {
        if (StringUtils.isBlank(data)) {
            return 0;
        }
        if (range == 0) {
            return 0;
        }
        int seed = 31;          // never change
        byte[] dataBytes = data.getBytes();

        int hash = hash(dataBytes, 0, dataBytes.length, seed);
        return Math.abs(hash % range);
    }

    /**
     * murmurHash 的32位有符号实现，返回的hash值有符号 seed只支持int
     * 不知道摘抄自那个博客了
     */
    private static int hash(byte[] data, int offset, int length, int seed) {
        int m = 0x5bd1e995;      // never change
        int r = 24;
        int h = seed ^ length;
        int len_4 = length >> 2;

        for (int i = 0; i < len_4; i++) {
            int i_4 = (i << 2) + offset;
            int k = data[i_4 + 3];
            k = k << 8;
            k = k | (data[i_4 + 2] & 0xff);
            k = k << 8;
            k = k | (data[i_4 + 1] & 0xff);
            k = k << 8;
            //noinspection PointlessArithmeticExpression
            k = k | (data[i_4 + 0] & 0xff);
            k *= m;
            k ^= k >>> r;
            k *= m;
            h *= m;
            h ^= k;
        }
        // avoid calculating modulo
        int len_m = len_4 << 2;
        int left = length - len_m;
        int i_m = len_m + offset;

        if (left != 0) {
            if (left >= 3) {
                h ^= data[i_m + 2] << 16;
            }
            if (left >= 2) {
                h ^= data[i_m + 1] << 8;
            }
            if (left >= 1) {
                h ^= data[i_m];
            }

            h *= m;
        }

        h ^= h >>> 13;
        h *= m;
        h ^= h >>> 15;

        return h;
    }

    /**
     * 32位MurmurHash算法
     *
     * @param key 待哈希的字符串
     * @return 哈希结果
     */
    public static int hash32(String key, int seed) {
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        buf.order(ByteOrder.LITTLE_ENDIAN);
        int m = 0x5bd1e995;
        int r = 24;
        int h = seed ^ buf.remaining();
        while (buf.remaining() >= 4) {
            int k = buf.getInt();
            k = k * m;
            k ^= k >>> r;
            k *= m;
            h *= m;
            h ^= k;
        }
        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            while (buf.remaining() > 0) {
                finish.put(buf.get());
            }
            finish.position(0);
            int k = finish.getInt();
            k *= m;
            k ^= k >>> r;
            k *= m;
            h *= m;
            h ^= k;
        }
        h ^= h >>> 13;
        h *= m;
        h ^= h >>> 15;
        return h;
    }


    /**
     * 64位MurmurHash算法
     *
     * @param key 待哈希的字符串
     * @return 哈希结果
     */
    public static long hash64(String key, int seed) {
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        buf.order(ByteOrder.LITTLE_ENDIAN);
        long m = 0xc6a4a7935bd1e995L;
        int r = 47;
        long h = seed ^ (buf.remaining() * m);
        while (buf.remaining() >= 8) {
            long k = buf.getLong();
            k *= m;
            k ^= k >>> r;
            k *= m;
            h ^= k;
            h *= m;
        }
        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
            while (buf.remaining() > 0) {
                finish.put(buf.get());
            }
            finish.position(0);
            long k = finish.getLong();
            k *= m;
            k ^= k >>> r;
            k *= m;
            h ^= k;
            h *= m;
        }
        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;
        return h;
    }

    /**
     * 64位MurmurHash算法
     *
     * @param key 待哈希的字符串
     * @return 哈希结果
     */
    public static long hash64(String key, long seed) {
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        buf.order(ByteOrder.LITTLE_ENDIAN);
        long m = 0xc6a4a7935bd1e995L;
        int r = 47;
        long h = seed ^ (buf.remaining() * m);
        while (buf.remaining() >= 8) {
            long k = buf.getLong();
            k *= m;
            k ^= k >>> r;
            k *= m;
            h ^= k;
            h *= m;
        }
        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
            while (buf.remaining() > 0) {
                finish.put(buf.get());
            }
            finish.position(0);
            long k = finish.getLong();
            k *= m;
            k ^= k >>> r;
            k *= m;
            h ^= k;
            h *= m;
        }
        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;
        return h;
    }


    /**
     * Long转换成无符号长整型
     * Java的数据类型long与C语言中无符号长整型uint64_t有区别，导致Java输出版本存在负数
     * @param value long
     * @return Long
     */
    public static Long readUnsignedLong(long value) {
        if (value >= 0){
            return value;
        }
        return value & Long.MAX_VALUE;
    }


    public static void main(String[] args) {
        String key = "hello world!1";
        System.out.println(hash32(key, 123));        // 输出32位哈希值
        System.out.println(hash32(key, 123));        // 输出32位哈希值

        System.out.println(hash64(key, 123));      // 输出64位哈希值
        System.out.println(hash64(key, 123));      // 输出64位哈希值
        System.out.println(readUnsignedLong(hash64(key, 123)));      // 输出64位哈希值
        System.out.println(hash64(key, 123L));      // 输出64位哈希值
    }
}
