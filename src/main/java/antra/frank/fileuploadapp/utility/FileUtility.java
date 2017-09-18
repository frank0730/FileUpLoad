package antra.frank.fileuploadapp.utility;


import antra.frank.fileuploadapp.entity.MetaData;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

public class FileUtility {

    static final String ROOT_FOLDER = "uploadedfiles/";

    public static MetaData convertToMetaData(MultipartFile file) {
        MetaData metaData = new MetaData();
        metaData.setSize(file.getSize());
        metaData.setFileName(file.getOriginalFilename());
        metaData.setPath((new File(ROOT_FOLDER)).getAbsolutePath() + "/" + file.getOriginalFilename());
        metaData.setUploadDate(new Date());
        return metaData;
    }
}
