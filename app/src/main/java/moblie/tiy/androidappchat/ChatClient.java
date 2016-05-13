package moblie.tiy.androidappchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Jaylon Breckenridge on 5/11/2016.
 */
public class ChatClient {

    String serverResponse;

    String sendMessage(String incomingString) {

        try {
            Socket clientSocket = new Socket("172.168.4.12", 8005);

            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            output.println(incomingString);

            String serverResponse;
            while (true) {
                serverResponse = input.readLine();

                if (serverResponse != null && serverResponse.equalsIgnoreCase("end-transmission")) {
                    break;
                }
                System.out.println(serverResponse);
                return serverResponse;
            }

        } catch (IOException ioexception) {

        }
        return serverResponse;
    }
}
  //  public String returnMessage (String history) {
    //    try {
      //      Socket clientSocket = new Socket("172.168.4.12", 8080);
            //BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
       // } catch (IOException ioexception) {

       // }
      //  return null;
   // }
//}
