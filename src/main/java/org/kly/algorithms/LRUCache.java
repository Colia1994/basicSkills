package org.kly.algorithms;

import java.util.Hashtable;

/**
 * LRU
 *
 * @author colia
 * @date 2018/12/11
 */
public class LRUCache {

    private int cacheSize;//缓存大小
    private Hashtable nodes;//缓存容器
    private int currentSize;//当前缓存对象数量
    private CacheNode first;//(实现双链表)链表头
    private CacheNode last;//(实现双链表)链表尾

    class CacheNode {
        CacheNode prev;//前一节点
        CacheNode next;//后一节点
        Object value;//值
        Object key;//键

        CacheNode() {
        }
    }

    public LRUCache(int i) {
        currentSize = 0;
        cacheSize = i;
        nodes = new Hashtable(i);//缓存容器
    }

    /**
     * 获取缓存中对象
     *
     * @param key
     * @return
     */
    public Object get(Object key) {
        CacheNode node = (CacheNode) nodes.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        } else {
            return null;
        }
    }

    /**
     * 添加缓存
     *
     * @param key
     * @param value
     */
    public void put(Object key, Object value) {
        CacheNode node = (CacheNode) nodes.get(key);

        if (node == null) {
            //缓存容器是否已经超过大小.
            if (currentSize >= cacheSize) {
                if (last != null)//将最少使用的删除
                    nodes.remove(last.key);
                removeLast();
            } else {
                currentSize++;
            }

            node = new CacheNode();
        }
        node.value = value;
        node.key = key;
        //将最新使用的节点放到链表头，表示最新使用的.
        moveToHead(node);
        nodes.put(key, node);
    }

    /**
     * 将缓存删除
     *
     * @param key
     * @return
     */
    public Object remove(Object key) {
        CacheNode node = (CacheNode) nodes.get(key);
        if (node != null) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (last == node)
                last = node.prev;
            if (first == node)
                first = node.next;
        }
        return node;
    }

    public void clear() {
        first = null;
        last = null;
    }

    /**
     * 删除链表尾部节点
     * 表示 删除最少使用的缓存对象
     */
    private void removeLast() {
        //链表尾不为空,则将链表尾指向null. 删除连表尾（删除最少使用的缓存对象）
        if (last != null) {
            if (last.prev != null) {
                last.prev.next = null;
            } else {
                first = null;
            }
            last = last.prev;
        }
    }

    /**
     * 命中节点
     * 移动到链表头，表示这个节点是最新使用过的
     *
     * @param node 命中的节点
     */
    private void moveToHead(CacheNode node) {
        if (node == first)
            return;
        //更新当前节点前节点的next指针
        if (node.prev != null)
            node.prev.next = node.next;
        //更新当前节点后节点的prev指针
        if (node.next != null)
            node.next.prev = node.prev;
        //更新尾
        if (last == node) {
            last = node.prev;
        }
        //更新当前节点的next节点和之前头的prev节点
        if (first != null) {
            node.next = first;
            first.prev = node;
        }
        //更新头
        first = node;
        node.prev = null;
        if (last == null) {
            last = first;
        }
    }

}
