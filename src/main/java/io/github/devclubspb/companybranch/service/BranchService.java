package io.github.devclubspb.companybranch.service;

import io.github.devclubspb.companybranch.domain.Branch;
import io.github.devclubspb.companybranch.domain.NewBranch;

import java.util.List;

public interface BranchService {

    List<Branch> getAllBranches();

    Branch createBranch(NewBranch newBranch);

}
