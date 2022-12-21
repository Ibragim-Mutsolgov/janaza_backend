package vip.redcode.janaza.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.redcode.janaza.core.entity.Groups;

import java.util.UUID;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, UUID> {
}
