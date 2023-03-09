/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket.programming;

/**
 *
 * @author hunnytaggy
 */
import java.net.*;
import java.io.*;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    
    public Server(int port){
        // start server and waits for a connection
        try{
            server = new ServerSocket(port);
            System.out.println("Server started");
            
            System.out.println("Waiting for a client...");
            
            socket = server.accept();
            System.out.println("Client accepted");
            
            // take input from the client socket
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
            
            String line = "";
            
            // reads message from client untill "Over is reached
            while (!line.equals("Over")){
                try{
                    line = in.readUTF();
                    System.out.println(line);
                }catch(IOException i){
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            
            // close connection
            socket.close();
            in.close();
            
        }catch(IOException i){
            System.out.println(i);
        }
    }
    
    public static void main(String [] args){
        Server server = new Server(5000);
    }
    
} 
