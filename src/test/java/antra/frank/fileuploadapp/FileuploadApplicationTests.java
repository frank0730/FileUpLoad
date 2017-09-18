package antra.frank.fileuploadapp;

import antra.frank.fileuploadapp.controller.FileController;
import antra.frank.fileuploadapp.entity.MetaData;
import antra.frank.fileuploadapp.exception.FileNotFoundException;
import antra.frank.fileuploadapp.exception.UploadEmptyFileException;
import antra.frank.fileuploadapp.repository.MetaDataRepository;
import antra.frank.fileuploadapp.service.FileService;
import antra.frank.fileuploadapp.service.FileServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FileuploadApplicationTests{


	@Mock
	MetaDataRepository daoMock;

	@InjectMocks
	FileServiceImpl fileService;



	@Mock
	FileService fileServiceMock;

	@InjectMocks
	FileController fileController;


	private MetaData metaData = new MetaData();
	private long  id = 100111;
	private String fileName = "test.txt";
	private String path = "test/file/test.txt";
	private long size = 100;
	private Date uploadDate = new Date();
	private byte[] content = "test".getBytes();
	private MockMultipartFile file = new MockMultipartFile(fileName,content);
	private MockMultipartFile emptyFile = new MockMultipartFile("empty",new byte[]{});
	private List<MetaData> testList = new ArrayList<>();


	@Before
	public void setupTest(){

		metaData.setId(id);
		metaData.setFileName(fileName);
		metaData.setUploadDate(uploadDate);
		metaData.setPath(path);
		metaData.setSize(size);
		testList.add(metaData);
		MockitoAnnotations.initMocks(this);

	}



	//Test services
	@Test
	public void testGetMetaData(){

		when(daoMock.findOne(id)).thenReturn(metaData);

		assertEquals(fileService.getFileInfoById(id).toString(), metaData.toString());

	}

	@Test
	public void testGetAllMetaData(){

		when(daoMock.findAll()).thenReturn(testList);

		assertTrue(fileService.getAllFileInfo().size() == 1 && fileService.getAllFileInfo().toString().equals(testList.toString()));

	}




	//Test controllers exception handler
	@Test(expected = FileNotFoundException.class)
	public void testGetFileInfoController(){

		when(fileServiceMock.getFileInfoById(id)).thenReturn(null);
		fileController.findByFileId(id);

	}

	@Test(expected = UploadEmptyFileException.class)
	public void testUploadFile(){
		fileController.uploadFile(emptyFile);
	}

}
