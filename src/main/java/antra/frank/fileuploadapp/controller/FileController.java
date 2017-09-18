package antra.frank.fileuploadapp.controller;


import antra.frank.fileuploadapp.entity.MetaData;
import antra.frank.fileuploadapp.exception.FileNotFoundException;
import antra.frank.fileuploadapp.exception.UploadEmptyFileException;
import antra.frank.fileuploadapp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value="/files", method = RequestMethod.POST, produces = "application/json")
    public MetaData uploadFile(@RequestParam("file") MultipartFile file) {
        if(file.isEmpty()) throw new UploadEmptyFileException("Upload empty file...");
        else return fileService.uploadFile(file);
    }

    @RequestMapping(value="/files", method = RequestMethod.GET, produces = "application/json")
    public List<MetaData> findAll() {
        return fileService.getAllFileInfo();
    }

    @RequestMapping(value="/files/{id}", method = RequestMethod.GET, produces = "application/json")
    public MetaData findByFileId(@PathVariable long id) {
        if(fileService.getFileInfoById(id) == null) throw new FileNotFoundException("File not exist on the server...");
        else return fileService.getFileInfoById(id);
    }

    @ExceptionHandler(value = UploadEmptyFileException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String showError(UploadEmptyFileException e) {
        return e.getMessage();
    }

    @ExceptionHandler(value = FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String showError(FileNotFoundException e) {
        return e.getMessage();
    }

}
