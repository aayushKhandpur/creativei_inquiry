package creativei.service;

import creativei.entity.Locality;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DataUploadService {
    boolean uploadLoaclityData(File localityCsv) throws IOException;
}
