package io.github.devclubspb.companybranch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "branch")
public class BranchEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

}
