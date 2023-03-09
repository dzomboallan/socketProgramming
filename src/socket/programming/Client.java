/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socket.programming;

/**
 *
 * @author hunnytaggy
 */

import java.net.*;
import java.io.*;

public class Client {

    /**
     * @param args the command line arguments
     */
    
    // initialize socket and input out stream
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    
    // constructor to put IP address and port
    public Client(String address, int port){
        //establish a connection
        try{
            socket = new Socket(address, port);
            System.out.println("Connected");
            
            // take input from terminal
            input = new DataInputStream(System.in);
            
            // sends output to the socket
            output = new DataOutputStream(socket.getOutputStream());
        }catch(UnknownHostException u){
            System.out.println(u);
        }catch(IOException i){
            System.out.println(i);
        }
        
        // String to read message from input tab
        String line = "";

        // keep reading untill "Over" is displayed on the screen
        while(!line.equals("Over")){
            try{
                line = input.readLine();
                output.writeUTF(line);
            }catch(IOException i){
                System.out.println(i);
            }
        }

        // close the connection
        try{
            input.close();
            output.close();
            socket.close();
        }catch(IOException i){
            System.out.println(i);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Client client = new Client("127.0.0.1", 5000);
    }
    
}
