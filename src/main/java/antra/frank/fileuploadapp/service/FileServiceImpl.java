package antra.frank.fileuploadapp.service;

import antra.frank.fileuploadapp.entity.MetaData;
import antra.frank.fileuploadapp.repository.MetaDataRepository;
import antra.frank.fileuploadapp.utility.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;



@Service("fileService")
@Transactional
public class FileServiceImpl implements FileService{

    @Autowired
    MetaDataRepository dao;


    @Override
    public MetaData uploadFile(MultipartFile file) {


        MetaData fileMeta = FileUtility.convertToMetaData(file);
        try {
            file.transferTo(new File(fileMeta.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dao.save(fileMeta);
        return fileMeta;
    }

    @Override
    public MetaData getFileInfoById(long id) {
        return dao.findOne(id);
    }

    @Override
    public List<MetaData> getAllFileInfo() {
        return dao.findAll();
    }


}
