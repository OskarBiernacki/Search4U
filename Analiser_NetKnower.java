import java.net.*;
import java.util.*;
import java.util.stream.Stream;
import javax.lang.model.util.Elements;
import java.io.*;
import com.google.gson.Gson;
import java.io.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;




public class Analiser_NetKnower {
    public String url = "";
    public int score=0;

    List<String> GetH3(String content)
    {   
        List<String> out = new ArrayList<String>();
        boolean isOpen= false;
        String segment = "";
        //System.out.println(content);
        for(int i=15;i<content.length();i++){

            //System.out.println(content.substring(i-1, i));
            
            if(content.charAt(i) == '<' && isOpen){    
                isOpen=false;
                if(segment!="")
                out.add(segment);
                segment="";
            }
            if(isOpen)segment+=content.charAt(i);
            if(content.charAt(i) == '>')
            isOpen=true;
        }
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
