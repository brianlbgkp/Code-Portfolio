import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.io.File;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class FinalProject {

    static String cookie = "";

    static Connection.Response response = null;

    public static String getKbIntFromInitQuery(String url) throws IOException{
        Document doc = Jsoup.connect(url).ignoreContentType(true).post();
        //return doc;
        String json = String.valueOf(doc.getElementsByTag("body"));
        String kbIndex = "";
        System.out.println(json);

        if(json.contains("kbNum")){
            int start = json.indexOf("kbNum");
            int end = json.indexOf(":", start);
            kbIndex = json.substring(end + 1, json.indexOf(",", end));
        }

        return kbIndex;
    }

    public static String getKbIntFromKbLogin(String url) throws IOException{
        //Connection.Response
                response	= Jsoup.connect(url)
                .method(Connection.Method.GET)
                .execute();
        String	newUrl		= response.url().toString();
        cookie		= response.cookie("session");

        return newUrl;
    }

    public static void printProperties(String url) throws IOException{
        Document document	= Jsoup.connect(url)
                .cookie("session",cookie)
                .get();
        //String theBoat = String.valueOf(document.getElementsByTag("body"));

        ArrayList<String> thList = new ArrayList<>();
        ArrayList<String> tdList = new ArrayList<>();

        Element table = document.select("table").get(0);
        Elements rows = table.select("tr");

        System.out.println(url);

        int count = 0;

        for(int i = 0; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements th = row.select("th");
            Elements td = row.select("td");

            for (Element element : th) {
                System.out.print(element.ownText());
                System.out.print(": ");
            }
            System.out.println(" ");

            for (Element element : td) {

                if(count % 2 == 0){
                    System.out.print(element.ownText());
                    System.out.print(" ");
                    count++;
                } else {
                    System.out.println(element.ownText());
                    count++;
                }
            }
        }

        //return theBoat;
    }

    public static void logout(String url) throws IOException{
        response	= Jsoup.connect(url)
                .cookie("session",cookie)
                .method(Connection.Method.GET)
                .execute();
        System.out.println("logout => " + response.statusMessage().toString());
    }

    public static void main(String[] args) throws IOException{
            String kbIndex = getKbIntFromInitQuery("http://scienceomatic.com:8080/kbList?keywords=base");
            //String kbIndex = "2";

            //String json = String.valueOf(doc.getElementsByTag("body"));

            String url = getKbIntFromKbLogin("http://scienceomatic.com:8080/kb/" + kbIndex);
            //String url = "http://scienceomatic.com:8080/kb/" + kbIndex;

            //String url = "http://scienceomatic.com:8080/kb/1477";
            String newKbId = url.substring(url.lastIndexOf("/") + 1, url.length());

            //String properties = printProperties(url + "/props/theBoat");

            System.out.println("http://scienceomatic.com:8080/kbList?keywords=base => " + kbIndex);
            System.out.print(url + " => ");
            System.out.println(newKbId);
            printProperties(url + "/props/theBoat");
            logout(url + "/noSaveClose?name=BrianSalinas");

    }
}
