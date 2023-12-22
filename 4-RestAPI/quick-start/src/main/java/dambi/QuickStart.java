package dambi;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.eqFull;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class QuickStart {
    public static void main( String[] args ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://user1:user1@cluster0.wcdu5.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> collection = database.getCollection("movies");

            Document doc = collection.find(eq("title", "Back to the Future")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }

    public static String kontsultatuPelikula(String bilagaia){
        String uri = "mongodb+srv://user1:user1@cluster0.wcdu5.mongodb.net/?retryWrites=true&w=majority";
        String result = "";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> collection = database.getCollection("movies");

            result = collection.find(eq("title", bilagaia)).first().getString("title") + "(" + collection.find(eq("title", bilagaia)).first().getString("year") + ")";
        }

        return result;
    }
}