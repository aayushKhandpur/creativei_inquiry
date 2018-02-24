package creativei.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import creativei.entity.Reminder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8100")
@RestController

public class ReminderController {
    private static final Logger logger = LoggerFactory.getLogger(ReminderController.class);
    private final ObjectMapper mapper = new ObjectMapper();


}
