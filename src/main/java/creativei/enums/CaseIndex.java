package creativei.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import creativei.controller.InquiryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CaseIndex {

    UNLIKELY("Unlikely",1),
    INTERESTED("Intersted",2),
    LIKELY("Likely",3),
    HOT_LEAD("Hot Lead",4);

    private static final Logger logger = LoggerFactory.getLogger(CaseIndex.class);
    private int index;
    private String value;
    private CaseIndex(String value,int index){
        this.value=value;
        this.index=index;
    }

    public int getIndex() {
        return index;
    }

    public String getValue(){return value;}


    public void setIndex(int index) {
        this.index = index;
    }

    public void setValue(String value) {
        this.value = value;
    }
    static List<String> list = new ArrayList<>();
    static {
        for (CaseIndex caseIndex : CaseIndex.values()) {
            try {
                list.add(new ObjectMapper().writeValueAsString(caseIndex));
            } catch (JsonProcessingException e) {
                logger.error("JSON content can not be processed");
                e.printStackTrace();
            }
        }
    }

    public static List<String> getAllEnum() {
        return list;
    }

}
