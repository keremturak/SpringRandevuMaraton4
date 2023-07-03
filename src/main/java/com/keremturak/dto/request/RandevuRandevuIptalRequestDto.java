package com.keremturak.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RandevuRandevuIptalRequestDto {
    String tc;
    int ay;
    int gun;
    int saat;
    Boolean durum;
}
