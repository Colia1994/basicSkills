package org.kly.netty;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @Author konglingyao
 * @Date 2023/4/19
 */
public class NIOBuffer {


    public static void main(String[] args) {
        //方式1：allocate方式直接分配，内部将隐含的创建一个数组
        ByteBuffer allocate = ByteBuffer.allocate(10);
        //方式2：通过wrap根据一个已有的数组创建
        byte[] bytes = new byte[10];
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        //方式3：通过wrap根据一个已有的数组指定区间创建
        ByteBuffer wrapoffset = ByteBuffer.wrap(bytes, 2, 5);
        //方式4：通过allocate方式创建出一个直接缓冲区
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(10);


        //打印出刚刚创建的缓冲区的相关信息
        print(allocate, wrap, wrapoffset,allocateDirect);
    }

    private static void print(Buffer... buffers) {
        for (Buffer buffer : buffers) {
            System.out.println("capacity=" + buffer.capacity()
                    + ",limit=" + buffer.limit()
                    + ",position=" + buffer.position()
                    + ",hasRemaining:" + buffer.hasArray()
                    + ",remaining=" + buffer.remaining()
                    + ",hasArray=" + buffer.hasArray()
                    + ",isReadOnly=" + buffer.isReadOnly()
                    + ",isDirect=" + buffer.isDirect());
        }
    }
}
