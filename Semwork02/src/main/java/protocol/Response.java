package protocol;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Changes;
import model.Payload;

public class Response<T> {
    private T data;
    private Payload payload;

    public Response(T data) {
        this.data = data;
        buildPayload();
    }

    private void buildPayload() {
        payload = new Payload();
        payload.setPayload(data);
        if (data instanceof Changes) {
            payload.setHeader("changes");
        }
    }

    public static <T> Response<T> build(T data) {
        return new Response<>(data);
    }

    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
