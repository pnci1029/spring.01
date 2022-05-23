package HCHH.Spring.repository;

import HCHH.Spring.Entity.EntityContent;
import org.springframework.data.repository.CrudRepository;

public interface ContentRepository extends CrudRepository<EntityContent, Long> {
}
