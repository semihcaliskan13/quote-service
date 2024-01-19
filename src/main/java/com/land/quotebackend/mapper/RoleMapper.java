package com.land.quotebackend.mapper;

import com.land.quotebackend.dto.request.role.RoleCreateRequest;
import com.land.quotebackend.dto.request.role.RoleUpdateRequest;
import com.land.quotebackend.dto.response.role.RoleGetAllResponse;
import com.land.quotebackend.dto.response.role.RoleGetByIdResponse;
import com.land.quotebackend.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleMapper INIT = Mappers.getMapper(RoleMapper.class);

    List<RoleGetAllResponse> roleToGetAllResponse(List<Role> roles);
    RoleGetByIdResponse roleToGetByIdResponse(Role role);
    Role roleCreateRequestToRole(RoleCreateRequest request);
    Role roleUpdateRequestToRole(RoleUpdateRequest request);
}
