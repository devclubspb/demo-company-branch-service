package io.github.devclubspb.companybranch.service;

import io.github.devclubspb.companybranch.domain.Branch;
import io.github.devclubspb.companybranch.domain.NewBranch;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BranchService {

    List<Branch> getAllBranches();

    List<Branch> findBranchesByIds(Set<Long> ids);

    Branch createBranch(NewBranch newBranch);

    Optional<Branch> findBranchById(Long branchId);

}
