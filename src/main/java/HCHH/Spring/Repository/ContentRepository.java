package HCHH.Spring.Repository;

import HCHH.Spring.Entity.contententity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface ContentRepository extends CrudRepository<contententity, Long> {
    @Override
    ArrayList<contententity> findAll();
}
