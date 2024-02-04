package io.github.devclubspb.companybranch.service;

import io.github.devclubspb.companybranch.domain.Branch;
import io.github.devclubspb.companybranch.domain.NewBranch;
import io.github.devclubspb.companybranch.entity.BranchEntity;
import io.github.devclubspb.companybranch.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SimpleBranchService implements BranchService {

    private final BranchRepository branchRepository;

    @Override
    public Branch createBranch(NewBranch newBranch) {
        BranchEntity entity = BranchEntity.builder()
                .name(newBranch.getName())
                .address(newBranch.getAddress())
                .build();
        BranchEntity savedEntity = branchRepository.save(entity);
        return mapEntity2Domain(savedEntity);
    }

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAllSortedByName().stream()
                .map(this::mapEntity2Domain)
                .toList();
    }

    @Override
    public List<Branch> findBranchesByIds(Set<Long> ids) {
        return branchRepository.findAllByIds(ids).stream()
                .map(this::mapEntity2Domain)
                .toList();
    }

    @Override
    public Optional<Branch> findBranchById(Long branchId) {
        return branchRepository.findById(branchId)
                .map(this::mapEntity2Domain);
    }

    private Branch mapEntity2Domain(BranchEntity entity) {
        return Branch.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .build();
    }

}
