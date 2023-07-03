package com.keremturak.repository.entitiy;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tblrandevu")
@Entity
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String randevuSahibi;
    private String tc;
    private Integer ay;
    private Integer gun;
    private Integer saat;
    private String randevuSebebi;
    private Boolean durum;


}
