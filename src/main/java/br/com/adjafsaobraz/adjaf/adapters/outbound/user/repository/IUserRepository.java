package br.com.adjafsaobraz.adjaf.adapters.outbound.user.repository;

import br.com.adjafsaobraz.adjaf.adapters.outbound.user.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByMail(String mail);
}
