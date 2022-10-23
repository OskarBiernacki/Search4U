import java.net.*;
import java.util.*;
import javax.lang.model.*;
import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import java.io.*;
import org.*;
import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Analiser_NetKnower {
    public String url = "";
    public int score=0;

    List<String> GetH3(String content)
    {   
        List<String> out = new ArrayList<String>();
        boolean isOpen= false;
        String segment = "";


        return out;
    }

    public String GoogleSearch(String _search) throws Exception
    {
        String google = "https://www.bing.com/search?q=";
        String search = "stackoverflow";
        String charset = "UTF-8";
        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 12.6; rv:106.0) Gecko/20100101 Firefox/106.0"; // Change this to your company's name and bot homepage!

        HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(google+search).openConnection();
        httpURLConnection.setRequestProperty("User-Agent", userAgent);
        httpURLConnection.setFollowRedirects(true);
        InputStream stream = httpURLConnection.getInputStream();
        
        String fullSource = "";
        String content;
        while((content = new BufferedReader(new InputStreamReader(stream)).readLine()) != null){
            //System.out.println(content);
            fullSource+=content;
        }

        List<String> list_content = GetH3(fullSource);
        for(int i=0;i<list_content.size();i++)
            System.out.println(list_content.get(i));
        
        return "";
    }

    Analiser_NetKnower(String _url) throws Exception
    {
        url = _url;
        GoogleSearch(_url);
    }
}
