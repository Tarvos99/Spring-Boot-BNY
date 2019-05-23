package jjgg.bnymellondemo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

public class AngRequest {

    private String id;
    private String title;

    public AngRequest(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    }

