package io.github.devclubspb.companybranch.repository;

import io.github.devclubspb.companybranch.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BranchRepository extends JpaRepository<BranchEntity, Long> {

    @Query("from BranchEntity order by name")
    List<BranchEntity> findAllSortedByName();

}
