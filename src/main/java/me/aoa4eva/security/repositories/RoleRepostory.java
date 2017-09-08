package me.aoa4eva.security.repositories;

import me.aoa4eva.security.models.RoleClass;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepostory extends CrudRepository<RoleClass,Long> {
}
