package domain.io;

import java.net.Socket;

/**
 * Created by zhou-jg on 2017/1/12.
 */
public class StreamBuffer {
    byte[] buffer = new byte[1024];
    byte[] innerBuffer = new byte[1024];
    int pos = 0;

    public read(Socket socket){
        int len = read(socket, buffer);
        reframe(len);
    }

    //TODO: 为了减少数组拷贝，可以通过引入两个代表起始和终止的位置引用来解决
    //另外，逻辑中还有些重复代码可以进行逻辑合并
    int reframe(int len){
        if (pos == 0){
            if (len >=12){
                if (len == buffer[11]){
                    //正好一帧，消费掉
                    consume(buffer);
                }else if (len > buffer[11]){
                    //多于一帧，消费掉开始的帧
                    byte[] frame = new byte[buffer[11]];
                    System.arraycopy(buffer, 0, frame, 0, buffer[11]);
                    consume(frame);
                    //将后面的帧内容前移
                    int newLen = len - buffer[11];
                    System.arraycopy(buffer, buffer[11], buffer, 0, newLen);
                    reframe(newLen);
                }else{
                    System.arraycopy(buffer, 0, innerBuffer, 0, len);
                    pos = len;
                }
            }else{
                System.arraycopy(buffer, 0, innerBuffer, 0, len);
                pos = len;
            }
        }else{
            if (pos >= 12){
                if (pos + len >= innerBuffer[11]){
                    int length = innerBuffer[11] - pos;
                    System.arraycopy(buffer, 0, innerBuffer, pos, length);
                    consume(innerBuffer);
                    pos = 0;
                    System.arraycopy(buffer, length, buffer, 0, len - length);
                    reframe(len-length);
                }
            }else{
                if(pos + len >= 12){
                    if(buffer[12-pos] <= pos + len){
                        System.arraycopy(buffer, 0, innerBuffer, pos, buffer[12-pos] - pos);
                        consume(innerBuffer);
                        System.arraycopy(buffer, buffer[12-pos] - pos, buffer, 0, len-buffer[12-pos] + pos);
                        pos = 0;
                        reframe(len-buffer[12-pos] + pos);
                    }else{
                        System.arraycopy(buffer, 0, innerBuffer, pos, len);
                        pos += len;
                    }
                }else{
                    System.arraycopy(buffer, 0, innerBuffer, pos, len);
                    pos += len;
                }
            }
        }
    }

    int read(Socket socket, byte[] buffer){
        //模拟从socket读取数据，并返回数据长度
        return (int) Math.random() * 1000;
    }

    //Mock方法
    void consume(byte[] frame){}
}
