package HCHH.Spring.controller;

import HCHH.Spring.DTO.contentdto;
import HCHH.Spring.Entity.contententity;
import HCHH.Spring.Repository.ContentRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class contentController {

    @Autowired
    private ContentRepository contentRepository;

    @GetMapping("/content/new")
    public String newcontent(){  return "article/new";}

    @PostMapping("/content/create")
    public String createcontent(contentdto dto){
        // dto에 저장된 데이터 투스트링으로 출력
        log.info(dto.toString());

        //dto데이터 -> 엔티티로 변환
        contententity entity = dto.toEntity();
        log.info(entity.toString());

        //엔티티로 변환된 데이터를 리파지터리에 저장
        contententity saved = contentRepository.save(entity);
        log.info(saved.toString());

        return "article/main";
    }

   @GetMapping("/content/{id}")
    public String idcontent(@PathVariable  Long id, Model model){
       contententity findid = contentRepository.findById(id).orElse(null);

       model.addAttribute("id", findid);

        return "article/id";
   }

   @GetMapping("/content")
    public String maincontent(Model model){
        List<contententity> savedList = contentRepository.findAll();

        model.addAttribute("List", savedList);

        return "article/main";
   }

}