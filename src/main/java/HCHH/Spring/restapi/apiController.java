package HCHH.Spring.restapi;


import HCHH.Spring.DTO.contentdto;
import HCHH.Spring.Entity.contententity;
import HCHH.Spring.Repository.ContentRepository;
import HCHH.Spring.Service.ContentService;
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
    private ContentService contentService;

    @GetMapping("/api/get")
    public List<contententity> getapi(){
        return contentService.getall();
    }
    @GetMapping("/api/get/{id}")
    public contententity getid(@PathVariable Long id){
        return contentService.getid(id);
    }

    @PostMapping("/api/post")
    public ResponseEntity<contententity> postapi(@RequestBody contentdto dto){
        contententity target = contentService.post(dto);
        return (target != null) ?
                ResponseEntity.status(HttpStatus.OK).body(target):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/api/patch/{id}")
    public ResponseEntity<contententity> patchapi(@RequestBody contentdto dto, @PathVariable Long id){
        contententity result = contentService.patch(dto, id);
        return (result!=null)?
                ResponseEntity.status(HttpStatus.OK).body(result):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity<contententity> deleteapi(@PathVariable Long id){
        contententity target = contentService.delete(id);

        return (target != null)?
                ResponseEntity.status(HttpStatus.OK).body(null):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}