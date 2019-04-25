package ngxson.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {
    @JsonProperty("self")
    String self;

    @JsonProperty("next")
    String next;

    @JsonProperty("prev")
    String prev;

    public String getSelf() {
        return self;
    }

    public String getNext() {
        return next;
    }

    public String getPrev() {
        return prev;
    }
    
}
