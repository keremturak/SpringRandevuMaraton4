package com.keremturak.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_SERVER_ERROR(1000,"Sunucuda Bilinmeyen bir hata oluştu", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(1001,"İstek formatı hatalı",HttpStatus.BAD_REQUEST),
    REGISTER_KULLANICIADI_KAYITLI(1001,"Kullanıcı adı kayıtlı",HttpStatus.BAD_REQUEST),
    NAME_IS_NULL(1001,"Name alanı boş geçilemez",HttpStatus.BAD_REQUEST),
    BU_TARIH_DOLU(1001,"Bu tarih dolu. Lütfen boş taihlere bakınız",HttpStatus.BAD_REQUEST),
    DOKTOR_BULUNAMADI(3001,"Doktor bulunamadı",HttpStatus.BAD_REQUEST),
    HASTA_BULUNAMADI(4001,"Hasta bulunamadı",HttpStatus.BAD_REQUEST),
    TCYE_KAYITLI_BOYLE_BIR_RANDEVU_YOK(4001,"Tc ye kayıtlı randevu bulunamadı",HttpStatus.BAD_REQUEST),

    ID_NOT_FOUND(1001,"Aradığınız id ya ait kayıt bulunamamıştır.",HttpStatus.BAD_REQUEST),
    BRANS_ZATEN_KAYITLI(2001,"Bu Branş Zaten Kayıtlıdır",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(1002,"Geçersiz token",HttpStatus.BAD_REQUEST);
    int code;
    String message;
    HttpStatus httpStatus;
}
