package jjgg.bnymellondemo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Complaints")
public class Complaint {
    @Id
    private String id;
    private String product;
    private String company;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int totalCount;
    private String response;
    private int outcomeCount;


    public Complaint(String product, String company, int totalCount, String response, int outcomeCount) {
        this.product = product;
        this.company = company;
        this.totalCount = totalCount;
        this.response = response;
        this.outcomeCount=outcomeCount;
    }

    public String getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public String getCompany() {
        return company;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public String getResponse() {
        return response;
    }

    public int getOutcomeCount() {
        return outcomeCount;
    }
}
