package samuelfac.organizze.client.dto.transaction;

import samuelfac.organizze.client.dto.common.Tags;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.core.ObjectReadContext;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles inconsistent Organizze payloads where "tags" can be either an array or an empty string.
 */
public class TagsListDeserializer extends ValueDeserializer<List<Tags>> {

    private static final TypeReference<List<Tags>> TAGS_LIST_TYPE = new TypeReference<List<Tags>>() {};

    @Override
    public List<Tags> deserialize(JsonParser parser, DeserializationContext ctxt) throws JacksonException {
        JsonNode node = parser.readValueAsTree();

        if (node == null || node.isNull()) {
            return null;
        }

        if (node.isString()) {
            String value = node.asString();
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
            ObjectReadContext codec = parser.objectReadContext();
            return codec.readValue(node.traverse(codec), TAGS_LIST_TYPE);
        }

        throw new RuntimeException("Unsupported JSON type for tags", ctxt.reportInputMismatch(List.class, "Unsupported JSON type for tags: %s", node.getNodeType()));
    }


}
