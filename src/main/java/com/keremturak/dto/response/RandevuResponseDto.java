package com.keremturak.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RandevuResponseDto {

    String randevuSahibi;
    int ay;
    int gun;
    int saat;
    String randevuSebebi;
    Boolean durum;
}
