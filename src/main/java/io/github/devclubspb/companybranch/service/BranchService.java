package io.github.devclubspb.companybranch.service;

import io.github.devclubspb.companybranch.domain.Branch;
import io.github.devclubspb.companybranch.domain.NewBranch;

import java.util.List;
import java.util.Optional;

public interface BranchService {

    List<Branch> getAllBranches();

    Branch createBranch(NewBranch newBranch);

    Optional<Branch> findBranchById(Long branchId);

}
