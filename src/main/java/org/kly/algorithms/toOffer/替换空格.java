package org.kly.algorithms.toOffer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author colia
 * @date 2018/12/30 17:36
 */
public class 替换空格 {

    public String replaceSpace(StringBuffer str) {

        if (str == null) {
            return null;
        }
        return str.toString().replaceAll(" ", "%20");
    }
}
