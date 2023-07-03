package com.keremturak.dto.request;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RandevuRequestDto {
    String randevuSahibi;

    @NotEmpty
    @Size(min = 13, max = 13)
    String tc;

    @NotNull
    @Range(min = 1, max = 12)
    Integer ay;

    @NotNull
    @Range(min = 1, max = 30)
    Integer gun;

    @NotNull
    @Range(min = 8, max = 17)
            //@Range sayesinde min 8 değeri girilebiliyor max 17)
    Integer saat;
    String randevuSebebi;
    Boolean durum =true;
}
