package net.javaguides.organization_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.javaguides.organization_service.dto.OrganizationDto;
import net.javaguides.organization_service.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Service - Organization Controller",
        description = "Organization Controller Exposes APIs for Organization Service"
)
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {
    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Operation(
            summary = "Save Organization REST API",
            description = "Save Organization REST API is used to save Organization object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganizationDto = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganizationDto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Organization REST API",
            description = "Get Organization REST API is used to get Organization object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{organizationCode}")
    public ResponseEntity<OrganizationDto> findOrganizationByCode(@PathVariable String organizationCode) {
        OrganizationDto organizationDto = organizationService.findByOrganizationCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }
}
