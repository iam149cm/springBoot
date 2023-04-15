package io.iam149cm.organizationservice.service.impl;

import io.iam149cm.organizationservice.dto.OrganizationDto;
import io.iam149cm.organizationservice.entity.Organization;
import io.iam149cm.organizationservice.mapper.OrganizationMapper;
import io.iam149cm.organizationservice.repository.OrganizationRepository;
import io.iam149cm.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {

            Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
            return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
