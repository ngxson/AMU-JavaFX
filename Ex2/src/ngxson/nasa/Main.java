package ngxson.nasa;

public class Main {
    public static void main(String[] args) throws Exception {
        DataFetcher dataFetcher = new DataFetcher();
        dataFetcher.fetchToOutputStream(System.out, 1);
    }
}
