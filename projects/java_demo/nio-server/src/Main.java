import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Main {
    private static final int BUFFER_SIZE = 1024;
    private static Selector selector = null;

    public static void main(String[] args) {
        logger("Starting MySelectorExample...");
        try {
            InetAddress hostIP = InetAddress.getLocalHost();
            int port = 9999;

            logger(String.format("Trying to accept connections on %s:%d...",
                    hostIP.getHostAddress(), port));
            selector = Selector.open();
            ServerSocketChannel mySocket = ServerSocketChannel.open();
            ServerSocket serverSocket = mySocket.socket();
            InetSocketAddress address = new InetSocketAddress(hostIP, port);
            serverSocket.bind(address);

            mySocket.configureBlocking(false);
            int ops = mySocket.validOps();
            mySocket.register(selector, ops, null);
            while (true) {

                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> i = selectedKeys.iterator();

                while (i.hasNext()) {
                    SelectionKey key = i.next();

                    if (key.isAcceptable()) {
                        processAcceptEvent(mySocket, key);
                    } else if (key.isReadable()) {
                        processReadEvent(key);
                    }
                    i.remove();
                }
            }
        } catch (IOException e) {
            logger(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void processAcceptEvent(ServerSocketChannel mySocket,
                                           SelectionKey key) throws IOException {

        logger("Connection Accepted...");

        // Accept the connection and make it non-blocking
        SocketChannel myClient = mySocket.accept();
        myClient.configureBlocking(false);

        // Register interest in reading this channel
        myClient.register(selector, SelectionKey.OP_READ);
    }

    private static void processReadEvent(SelectionKey key)
            throws IOException {
        logger("Inside processReadEvent...");
        // create a ServerSocketChannel to read the request
        SocketChannel myClient = (SocketChannel) key.channel();

        // Set up out 1k buffer to read data into
        ByteBuffer myBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        myClient.read(myBuffer);
        String data = new String(myBuffer.array()).trim();
        if (data.length() > 0) {
            logger(String.format("Message Received.....: %s\n", data));
            if (data.equalsIgnoreCase("*exit*")) {
                myClient.close();
                logger("Closing Server Connection...");
            }
        }
    }

    public static void logger(String msg) {
        System.out.println(msg);
    }
}
