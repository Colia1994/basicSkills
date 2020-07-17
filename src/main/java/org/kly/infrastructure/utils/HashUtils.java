package org.kly.infrastructure.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 用了这个CF页面上的算法
 */
public class HashUtils {
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
}
