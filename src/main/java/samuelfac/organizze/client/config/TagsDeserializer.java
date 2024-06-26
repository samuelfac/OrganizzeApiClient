package samuelfac.organizze.client.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import samuelfac.organizze.client.dto.Tags;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagsDeserializer extends JsonDeserializer<List<Tags>> {


    @Override
    public List<Tags> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String commaSeparatedString = node.asText();


        return Arrays.stream(commaSeparatedString.split(","))
                .map(tag -> {
                    try {
                        return new Tags(tag);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());

    }
}
