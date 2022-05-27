package HCHH.Spring.restapi;


import HCHH.Spring.DTO.contentdto;
import HCHH.Spring.Entity.contententity;
import HCHH.Spring.Repository.ContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class apiController {
    @Autowired
    private ContentRepository contentRepository;

    @GetMapping("/api/get")
    public List<contententity> getapi(){
        return contentRepository.findAll();
    }
    @GetMapping("/api/get/{id}")
    public contententity getid(@PathVariable Long id){
        return contentRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/post")
    public contententity postapi(@RequestBody contentdto dto){
        contententity entity = dto.toEntity();
        contententity target= contentRepository.save(entity);
        return target;
    }

    @PatchMapping("/api/patch/{id}")
    public ResponseEntity<contententity> patchapi(@RequestBody contentdto dto, @PathVariable Long id){
        contententity findid = contentRepository.findById(id).orElse(null);
        contententity target = dto.toEntity();
        contententity update = contentRepository.save(target);
        if(findid == null || id != dto.getId()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        log.info("아이디가 없읍니다.");
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity<contententity> deleteapi(@PathVariable Long id){
        contententity target = contentRepository.findById(id).orElse(null);
        if(target == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
         contentRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
