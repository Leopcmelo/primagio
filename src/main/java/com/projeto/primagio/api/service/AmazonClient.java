package com.projeto.primagio.api.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.projeto.primagio.api.model.Curriculo;
import com.projeto.primagio.api.repository.CurriculoRepository;


@Service
public class AmazonClient {
	
		@Autowired
		private CurriculoRepository curriculoRepository;
	
	 	private AmazonS3 s3Client;

	    private String endpointUrl = "https://s3-sa-east-1.amazonaws.com/";
	    private String bucketName = "primagio-curriculos";
	    //private String accessKey = "AKIA3MED2ENMERXXGUPN";
	    //private String secretKey = "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";
	    
		@PostConstruct
		    private void initializeAmazon() {
			
			BasicAWSCredentials creds = new BasicAWSCredentials("AKIA3MED2ENMERXXGUPN", "UoDyA2rNfawlwEdGcKSD8548uu8tV9k1KfwGPVnK");
			s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds))
					.withRegion(Regions.SA_EAST_1)
					.build();
		}
		
		public  Curriculo uploadFile(MultipartFile multipartFile, Long codigo) {
	        String fileUrl = "";
	        try {
	            File file = convertMultiPartToFile(multipartFile);
	            String fileName = generateFileName(multipartFile);
	            fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
	            uploadFileTos3bucket(fileName, file);
	            file.delete();
	        } catch (Exception e) {
	           e.printStackTrace();
	        }

	        Curriculo curriculo = new Curriculo();
	        curriculo.setCodigo(codigo);
	        curriculo.setUrl(fileUrl);
       
	        
	        curriculoRepository.save(curriculo);
	        
	        return curriculo;
	    }

	    private File convertMultiPartToFile(MultipartFile file) throws IOException {
	        File convFile = new File(file.getOriginalFilename());
	        FileOutputStream fos = new FileOutputStream(convFile);
	        fos.write(file.getBytes());
	        fos.close();
	        return convFile;
	    }

	    private String generateFileName(MultipartFile multiPart) {
	        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	    }

	    private void uploadFileTos3bucket(String fileName, File file) {
	        s3Client.putObject(new PutObjectRequest(bucketName, fileName, file)
	                .withCannedAcl(CannedAccessControlList.PublicRead));
	    }

	    public String deleteFileFromS3Bucket(String fileUrl) {
	        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
	        s3Client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
	        return "Successfully deleted";
	    }
	
}
