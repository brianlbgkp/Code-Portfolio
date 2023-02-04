import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.io.File;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class Assignment3{
	public static void main(String[] args) throws IOException{
		File input = new File("/home/bsalina3/DistributedSystems/listOfSolarSysObjectsBySize.html");
		Document doc = Jsoup.parse(input, null);

		ArrayList<String> thList = new ArrayList<>();
		ArrayList<String> tdList = new ArrayList<>();

		Element table = doc.select("table").get(1);
		Elements rows = table.select("tr");
		Elements ol = doc.select("ol.references");


		for(int i = 2; i < rows.size(); i++){
			Element row = rows.get(i);
			Elements td = row.select("td");
			Elements th = row.select("th");
			String href1;
			String href2;
			

				for(Element element : td){

					if(element.select("sup.reference>a").size() > 0){
					Elements sup1 = td.select("sup.reference");
					Elements link1 = sup1.select("a");

					href1 = link1.attr("href");
					href1 = href1.substring(1);
				
					//System.out.println(href1);
					
					if(element.select("span").size() > 0){	
						System.out.println("Data: " + element.select("span").text() + " Ref: "); // + href1);
					} else {

						System.out.println("Data: " + element.ownText() + " Ref: "); // + href1);
					}

						Elements li1 = ol.select("li");
						for(Element element2 : li1){
							String id1 = element2.attr("id");

						//	System.out.println(id1);
						
							if(id1.contains(href1)){
							//	System.out.println("true");
								System.out.println("[" + element2.select("span.reference-text").text()+ "]");
								
								System.out.println("");
								break;
								
							}

						}	
					}

				}
				
				for(Element element : th){
			
					if(element.select("sup.reference>a").size() > 0){
	
					Elements sup2 = th.select("sup.reference");

					Elements link2 = sup2.select("a");

					href2 = link2.attr("href");
					href2 = href2.substring(1);

					if(element.select("span").size() > 0){	
						System.out.println("Data: " + element.select("span").text() + " Ref: "); // + href2);
					} else {
						System.out.println("Data: " + element.ownText() + " Ref: "); // + href2);
					}

					//for(int x = 0; x < ol.size(); x++){
						Elements li2 = ol.select("li");
						for(Element element3 : li2){
							String id2 = element3.attr("id");
							
							if(id2.contains(href2)){
								System.out.println("[" +element3.select("span.reference-text").text() + "]");
								
								System.out.println("");
								break;
							}
						}

				}

			}
					
		}

	}
}

