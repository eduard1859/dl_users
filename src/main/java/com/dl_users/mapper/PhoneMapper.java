package com.dl_users.mapper;

import com.dl_users.dto.PhoneDto;
import com.dl_users.entity.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneMapper {
    PhoneMapper INSTANCE = Mappers.getMapper( PhoneMapper.class );
    Phone phoneDtoToPhone(PhoneDto phoneDto);
    PhoneDto phoneToPhoneDto(Phone phone);
}
