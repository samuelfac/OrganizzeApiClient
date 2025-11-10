package samuelfac.organizze.client.dto.transaction;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import samuelfac.organizze.client.dto.common.Tags;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles inconsistent Organizze payloads where "tags" can be either an array or an empty string.
 */
public class TagsListDeserializer extends JsonDeserializer<List<Tags>> {

    private static final TypeReference<List<Tags>> TAGS_LIST_TYPE = new TypeReference<List<Tags>>() {};

    @Override
    public List<Tags> deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);

        if (node == null || node.isNull()) {
            return null;
        }

        if (node.isTextual()) {
            String value = node.asText();
            if (value == null || value.isBlank()) {
                return Collections.emptyList();
            }

            List<Tags> parsed = Arrays.stream(value.split(","))
                    .map(String::trim)
                    .filter(token -> !token.isEmpty())
                    .map(Tags::new)
                    .collect(Collectors.toList());

            return parsed.isEmpty() ? Collections.emptyList() : parsed;
        }

        if (node.isArray()) {
            ObjectCodec codec = parser.getCodec();
            return codec.readValue(node.traverse(codec), TAGS_LIST_TYPE);
        }

        throw new IOException("Unsupported JSON type for tags",ctxt.reportInputMismatch(List.class, "Unsupported JSON type for tags: %s", node.getNodeType()));
    }
}
