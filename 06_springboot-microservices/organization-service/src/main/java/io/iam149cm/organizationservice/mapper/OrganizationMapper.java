package io.iam149cm.organizationservice.mapper;

import io.iam149cm.organizationservice.dto.OrganizationDto;
import io.iam149cm.organizationservice.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganizationDto(Organization organization) {
        OrganizationDto organizaionDto = new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate()
        );

        return organizaionDto;
    }

    public static Organization mapToOrganization(OrganizationDto organizationDto) {
        Organization organization = new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreatedDate()
        );

        return organization;
    }
}
