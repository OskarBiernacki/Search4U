import java.net.*;

public class Analiser {
    public static String ScopeURL="";
    private static String output="Nothing done";
    Analiser (String url){
        ScopeURL=url;
    }

    public void StartAllScanners() throws Exception{
        
        //Check that server exist
        String locUrl = ScopeURL;
        if(!ScopeURL.startsWith("http://") &&  !ScopeURL.startsWith("https://"))
            locUrl="https://"+ScopeURL;
        URL url = new URL(locUrl);

        HttpURLConnection hConnection = null;
        int code=0;

        try{
            hConnection = (HttpURLConnection) url.openConnection();
            hConnection.setRequestMethod("GET");
            code = hConnection.getResponseCode();
            output = String.valueOf(code);
        }catch(Exception ex){code=0;}

        if(code!=200){
            try{
                locUrl = "http://"+ScopeURL;
                url = new URL(locUrl);
                code = hConnection.getResponseCode();
            }catch(Exception ex){code=0;}
        }
        if(code==0){
            output = "{\"error\":\"can't connect host\"}";
            return;
        }

        //Modules Starter
        Analiser_URL analiser_URL;
        Analiser_NetKnower analiser_NetKnower;

        try{analiser_URL = new Analiser_URL(locUrl);}catch(Exception ex)
        {System.out.println("ERROR Analiser_URL Modue: " + ex.getLocalizedMessage());} //Score: 10%
        try{analiser_NetKnower = new Analiser_NetKnower(locUrl);}catch(Exception ex)
        {System.out.println("ERROR Analiser_NetKnower Module:  "+ex.getLocalizedMessage());} //Score: 30%

        output = "{\"phising_estimate\": \"0\"}";
    }

    public String getStatus(){
        return output;
    }
}
