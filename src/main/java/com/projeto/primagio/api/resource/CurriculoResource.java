package com.projeto.primagio.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projeto.primagio.api.model.Curriculo;
import com.projeto.primagio.api.repository.CurriculoRepository;
import com.projeto.primagio.api.service.AmazonClient;
import com.projeto.primagio.api.service.CurriculoService;

@RestController
@RequestMapping("/curriculo")
public class CurriculoResource {
	private AmazonClient amazonClient;
	
	@Autowired
	private CurriculoRepository curriculoRepository;
	
	@Autowired
	private CurriculoService curriculoService;

    @Autowired
    CurriculoResource(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/upload/{codigo}")
    public Curriculo uploadFile(@RequestPart(value = "file") MultipartFile file, @PathVariable Long codigo) {
        return this.amazonClient.uploadFile(file, codigo);
    }

    @DeleteMapping("/delete")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }
    
    @GetMapping("/{codigo}")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long codigo) {
		Curriculo curriculoSalvo = curriculoService.buscarCurriculoPeloCodigo(codigo);
		
		return ResponseEntity.ok(curriculoSalvo);
	}
    
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		curriculoRepository.delete(codigo);
	}
}

