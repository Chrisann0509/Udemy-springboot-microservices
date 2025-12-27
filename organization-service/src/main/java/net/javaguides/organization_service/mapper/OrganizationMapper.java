package net.javaguides.organization_service.mapper;

import net.javaguides.organization_service.dto.OrganizationDto;
import net.javaguides.organization_service.entity.Organization;
import org.mapstruct.factory.Mappers;

public interface OrganizationMapper {
    OrganizationMapper MAPPER = Mappers.getMapper(OrganizationMapper.class);

    OrganizationDto mapToOrganizationDto(Organization organization);
    Organization mapToOrganization(OrganizationDto organizationDto);
}
