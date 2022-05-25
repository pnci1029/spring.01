package HCHH.Spring.controller;

import HCHH.Spring.DTO.contentdto;
import HCHH.Spring.Entity.contententity;
import HCHH.Spring.Repository.ContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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

        return "redirect:/content/"+saved.getID();
    }

    @GetMapping("/content")
    public String maincontent(Model model){
        List<contententity> listcontent = contentRepository.findAll();

        model.addAttribute("main", listcontent);

        return "article/main";
    }

    @GetMapping("/content/{id}")
    public String numbercontent(@PathVariable Long id, Model model){
        contententity findid= contentRepository.findById(id).orElse(null);
        model.addAttribute("find", findid);
     return "article/id";
    }

    @GetMapping("/content/{id}/edit")
    public String editcotent(@PathVariable Long id, Model model){
        contententity edit= contentRepository.findById(id).orElse(null);
        model.addAttribute("edit", edit);
        return "article/edit";
    }

    @PostMapping("/content/{id}/update")
    public String updatecontent(@PathVariable Long id, contentdto dto, Model model){
        log.info(dto.toString());
        contententity entity = dto.toEntity();

        contententity target = contentRepository.findById(entity.getID()).orElse(null);

        if(target != null){
            contentRepository.save(entity);
        }

        model.addAttribute(entity);
        return "redirect:/content/"+entity.getID();
    }

    @GetMapping("/content/{id}/delete")
    public String deletecontent(@PathVariable Long id){
        contententity targetid = contentRepository.findById(id).orElse(null);

        if(targetid != null){
            contentRepository.delete(targetid);
        }

        return "redirect:/content/";
    }

}
