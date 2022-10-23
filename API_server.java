import java.net.*;
import java.io.*;
import org.json.*;


public class API_server
{
    public static int PORT=444;
    public static boolean isServerRunning = true;

    public static String JsonParser_(String input)
    {
        JSONObject jsonObject = new JSONObject(input);
        return jsonObject.getString("url");
    }

    static void INT_Server() throws IOException
    {  
        ServerSocket serverSocket = new ServerSocket(PORT);
        do{
            Socket socket = serverSocket.accept();
            InputStream stream_input = socket.getInputStream();
            OutputStream stream_output = socket.getOutputStream();
            String to_json_text = new BufferedReader(new InputStreamReader(stream_input)).readLine();
            
            System.out.println(to_json_text);
            String url = JsonParser_(to_json_text);
        
            try{
                Analiser analiser = new Analiser(url);
                analiser.StartAllScanners();
                stream_output.write(analiser.getStatus().getBytes());
            }catch(Exception ex)
            {
                System.out.println("Error Analiser for " + to_json_text + " " + ex.getLocalizedMessage());
            }
            socket.close();
        }while(isServerRunning);
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException
    {
        System.out.println("Starting API server...");
        try
        {
            INT_Server();
        }catch (Exception ex){
            System.out.println("FATAL on INI_SERVER");
        }
    }
}