package io.github.devclubspb.companybranch.controller;

import io.github.devclubspb.companybranch.domain.Branch;
import io.github.devclubspb.companybranch.domain.NewBranch;
import io.github.devclubspb.companybranch.payload.BranchRequest;
import io.github.devclubspb.companybranch.payload.BranchResponse;
import io.github.devclubspb.companybranch.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/branches")
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    public BranchResponse createBranch(@RequestBody BranchRequest request) {
        NewBranch newBranch = NewBranch.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
        Branch createdBranch = branchService.createBranch(newBranch);
        return mapDomain2Response(createdBranch);
    }

    @GetMapping
    public List<BranchResponse> getBranches() {
        return branchService.getAllBranches().stream()
                .map(this::mapDomain2Response)
                .toList();
    }

    private BranchResponse mapDomain2Response(Branch domain) {
        return BranchResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .address(domain.getAddress())
                .build();
    }

}
