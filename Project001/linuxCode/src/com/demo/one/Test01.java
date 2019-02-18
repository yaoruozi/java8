package com.demo.one;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.InputStream;
import java.io.OutputStream;


public class Test01 {
    private static final String SSH_IP = "192.168.242.128";
    private static final String user = "root";
    private static final String password = "ZXzx1314";

    public static void main(String[] args) {

    }


    public static String exectueShellCommand(String command) {
        String executeResultString = new String();
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, SSH_IP, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");
            //create the excution channel over the session
            Channel channel = session.openChannel("exec");
            // Set the command that you want to execute
// In our case its the remote shell script
            ((ChannelExec) channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
// Gets an InputStream for this channel. All data arriving in as messages from the remote side can be
            InputStream in = channel.getInputStream();
            OutputStream out = channel.getOutputStream();
// Execute the command
            channel.connect();
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    executeResultString = new String(tmp, 0, i); //获取命令执行的返回值，结果是多行的也存在一个String中       
                }

                if (channel.isClosed()) {
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                } //让线程执行1秒 
            }
            channel.disconnect();
            session.disconnect();
            System.out.println("DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("return values is:" + executeResultString);
        return executeResultString;
    }

}
