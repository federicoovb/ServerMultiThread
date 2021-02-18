/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author violaboros.federico
 */
public class ServerThread implements Runnable {
    private Socket clientSocket;

    public ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
        
    @Override
    public void run() {
        System.out.println("Serverino partito");
        try {
            clientSocket.getInetAddress();
            OutputStream versoIlClient = clientSocket.getOutputStream();
            BufferedWriter scrittore = new BufferedWriter(new OutputStreamWriter(versoIlClient));
            
            scrittore.write("ciao sono il serverino");
            scrittore.close();
            clientSocket.close();
            
            System.out.println("chiusura connessione effettuata");
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
