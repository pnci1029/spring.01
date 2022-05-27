package HCHH.Spring.Service;

import HCHH.Spring.DTO.contentdto;
import HCHH.Spring.Entity.contententity;
import HCHH.Spring.Repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;


    public List<contententity> getall() {
     return contentRepository.findAll();
    }

    public contententity getid(Long id) {
      return contentRepository.findById(id).orElse(null);
    }

    public contententity post(contentdto dto) {
        contententity entity =  dto.toEntity();
        if(entity.getID() != null){
            return null;
        }
        return contentRepository.save(entity);
    }

    public contententity patch(contentdto dto, Long id) {
        contententity entity = dto.toEntity();
        contententity findid = contentRepository.findById(id).orElse(null);
        if(findid == null || id != dto.getId()){
            return null;
        }
        return contentRepository.save(entity);
    }

    public contententity delete(Long id) {
        contententity entity = contentRepository.findById(id).orElse(null);
        if(entity == null) {
            return null;
        }
        contentRepository.delete(entity);
        return entity;
    }
}
