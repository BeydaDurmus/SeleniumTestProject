package base;

public class Helpers {
    public static String stringToPrice(String price){
        return price.replace(" TL","").replace(".","").replace(",","");
    }
}
