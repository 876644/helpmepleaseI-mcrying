package com.company;

import com.company.Commands.*;
import com.company.Utility.CommandsObjects;
import com.company.Utility.Creation;
import com.company.Utility.Message;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;


public class Main {

    public static AbstractCommand object;
    public static Message message;
    static DatagramChannel channel;
    public static int port = 21055;//порт сервера, к которому собирается потключится клиентский сокет
    public static InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",port);
    public static ByteBuffer newByteBuffer = ByteBuffer.allocate(16384);

    public static final Logger logger = Logger.getLogger(Main.class.getName());
    private static execute_scriptCommand execute_scriptCommand;

    public static void main(String[] args) throws IOException {

        logger.info("Program has started!");

        try {

            while (true) {
                sentObject();
                getMessage();
                channel.close();
            }
        } catch (SocketException | UnknownHostException e) {
            logger.severe("Error!");
        }
    }
    
    public static void sentObject(){
        try {
            byte[] sendingDataBuffer;
            channel = DatagramChannel.open();
            channel.configureBlocking(false);

            object = null;
            while (object == null) {
                Creation.mm();
            }
            sendingDataBuffer = serialize(object);

            ByteBuffer byteBuffer = ByteBuffer.wrap(sendingDataBuffer);
            channel.send(byteBuffer, inetSocketAddress);
            System.out.println("Команда была отправлена.");

        } catch (IOException e) {
            System.out.println("Что-то не так с отправкой...");
        }
    }
    public static void getMessage(){
        try {
            long timeStart = System.currentTimeMillis();
             SocketAddress a;
             a = channel.receive(newByteBuffer);

             while (a == null){
                 if ((System.currentTimeMillis() - timeStart) < 5000){
                     a = channel.receive(newByteBuffer);
                 }else {
                     System.out.println("Что-то с сервером... Он умер..");
                     System.exit(0);
                 }
             }

            message = (Message) deserialize(newByteBuffer.array());
            System.out.println("Сообщение от сервера: " + "\n" + message.message);
            if(message.message.equals("Замените эллемент.")){need();}
            newByteBuffer = ByteBuffer.allocate(16384);

        }catch (IOException | ClassNotFoundException e) {
             e.printStackTrace();
        }
    }
    public static byte[] serialize(Object obj) throws IOException{

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();//данные записываются в массив байтов
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);//Записывает указанный объект в ObjectOutputStream
        objectOutputStream.flush();//Сбрасывает поток
        return byteArrayOutputStream.toByteArray();

    }
    public static Object deserialize(byte[] array) throws IOException, ClassNotFoundException{

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array);
        ObjectInput objectInput = new ObjectInputStream(byteArrayInputStream);
        return objectInput.readObject();
    }
    public static void need() throws IOException, ClassNotFoundException {
        String[] ar = new String[0];
        CommandsObjects.add(ar);
        byte[] sendingDataBuffer1 = serialize(object);

        ByteBuffer byteBuffer1 = ByteBuffer.wrap(sendingDataBuffer1);
        channel.send(byteBuffer1, inetSocketAddress);
        System.out.println("Команда была отправлена.");

        ByteBuffer newByteBuffer1 = ByteBuffer.allocate(16384);

        SocketAddress an = channel.receive(newByteBuffer1);

        while (an == null) {
            an = channel.receive(newByteBuffer1);
        }
        message = (Message) deserialize(newByteBuffer1.array());
        System.out.println("Сообщение от сервера: " + "\n" + message.message);
    }
}


