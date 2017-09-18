package antra.frank.fileuploadapp.service;

import antra.frank.fileuploadapp.entity.MetaData;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService{

    public MetaData uploadFile(MultipartFile file);

    public MetaData getFileInfoById(long id);

    public List<MetaData> getAllFileInfo();

}
