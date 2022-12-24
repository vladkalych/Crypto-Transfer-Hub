package com.rebalcomb.mapper;

import com.rebalcomb.model.dto.auth.LoginRequestDto;
import com.rebalcomb.model.dto.auth.SignUpRequestDto;
import com.rebalcomb.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(SignUpRequestDto signUpRequestDto);

    User toUser(LoginRequestDto loginRequestDto);

}
