package com.keremturak.mapper;

import com.keremturak.dto.request.RandevuRequestDto;
import com.keremturak.dto.response.RandevuResponseDto;
import com.keremturak.repository.entitiy.Randevu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "string", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRandevuMapper {
    IRandevuMapper INSTANCE = Mappers.getMapper(IRandevuMapper.class);

    RandevuResponseDto dtoFromRandevu(final Randevu randevu);
    Randevu randevufromDto(final RandevuRequestDto randevuRequestDto);




}
