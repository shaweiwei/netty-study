package com.imooc.netty.ch2;

import java.io.IOException;
import java.net.Socket;

/**
 * @author 闪电侠
 */
public class Client {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    private static final int SLEEP_TIME = 5000;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);

        new Thread(new Runnable() {// 为了不阻塞主线程，这边需要新开线程
            @Override
            public void run() {
                System.out.println("客户端启动成功!");
                while (true) {
                    try {
                        String message = "hello world";
                        System.out.println("客户端发送数据: " + message);
                        socket.getOutputStream().write(message.getBytes());// 写数据到服务端
                    } catch (Exception e) {
                        System.out.println("写数据出错!");
                    }
                    sleep();// 每传送一次后休眠一段时间
                }


            }
        }).start();

    }

    private static void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
