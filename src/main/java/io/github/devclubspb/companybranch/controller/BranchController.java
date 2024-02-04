package io.github.devclubspb.companybranch.controller;

import io.github.devclubspb.companybranch.domain.Branch;
import io.github.devclubspb.companybranch.domain.NewBranch;
import io.github.devclubspb.companybranch.payload.BranchRequest;
import io.github.devclubspb.companybranch.payload.BranchResponse;
import io.github.devclubspb.companybranch.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    public List<BranchResponse> getBranches(@RequestParam(required = false) Set<Long> ids) {
        List<Branch> branches = CollectionUtils.isEmpty(ids)
                ? branchService.getAllBranches()
                : branchService.findBranchesByIds(ids);
        return branches.stream()
                .map(this::mapDomain2Response)
                .toList();
    }

    @GetMapping("/{branchId}")
    public ResponseEntity<BranchResponse> getBranch(@PathVariable Long branchId) {
        return branchService.findBranchById(branchId)
                .map(this::mapDomain2Response)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private BranchResponse mapDomain2Response(Branch domain) {
        return BranchResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .address(domain.getAddress())
                .build();
    }

}
