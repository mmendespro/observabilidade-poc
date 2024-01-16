package net.local.poc.organization.service.application.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Organization {
    private String organizationId;
    private String organizationName;
}
