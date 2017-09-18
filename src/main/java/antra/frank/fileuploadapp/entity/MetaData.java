package antra.frank.fileuploadapp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "META_DATA")
public class MetaData implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "file_size")
    private long size;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String path;

    @Column(name ="upload_date")
    private Date uploadDate;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "size='" + size + '\'' +
                ", fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
