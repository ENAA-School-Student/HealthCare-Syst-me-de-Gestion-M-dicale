package org.example.systemedegestionmedicale.Mapper;


import org.example.systemedegestionmedicale.Dto.request.UserRequest;
import org.example.systemedegestionmedicale.Models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequest userRequest);
}
