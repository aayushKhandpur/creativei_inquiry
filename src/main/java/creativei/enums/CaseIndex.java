package creativei.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import creativei.controller.InquiryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CaseIndex {

    UNLIKELY("Unlikely", 1),
    INTERESTED("Intersted", 2),
    LIKELY("Likely", 3),
    HOT_LEAD("Hot Lead", 4);

    private static final Logger logger = LoggerFactory.getLogger(CaseIndex.class);
    private static Map<String, CaseIndex> lookup = new HashMap<>();
    private static List<JsonNode> list = new ArrayList<>();

    static {
        ObjectMapper mapper = new ObjectMapper();
        for (CaseIndex caseIndex : CaseIndex.values()) {
            try {

                ObjectNode jNode = mapper.createObjectNode();
                jNode.put("index", caseIndex.getIndex());
                jNode.put("value", caseIndex.getValue());
                list.add(jNode);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            lookup.put(caseIndex.getValue().toLowerCase(), caseIndex);
        }

    }

    private int index;
    private String value;

    private CaseIndex(String value, int index) {
        this.value = value;
        this.index = index;
    }

    public static List<JsonNode> getAllEnum() {
        return list;
    }

    public static String enumToString(CaseIndex caseIndex) {
        if (caseIndex.value == null)
            return null;
        return caseIndex.value;
    }

    public static CaseIndex stringToEnum(String value) {
        if (value == null)
            return null;
        return lookup.get(value.toLowerCase());
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
