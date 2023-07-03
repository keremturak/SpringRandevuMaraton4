package com.keremturak.service;

import com.keremturak.dto.request.RandevuRandevuIptalRequestDto;
import com.keremturak.dto.request.RandevuRequestDto;
import com.keremturak.dto.response.RandevuResponseDto;
import com.keremturak.exception.ErrorType;
import com.keremturak.exception.RandevuException;
import com.keremturak.mapper.IRandevuMapper;
import com.keremturak.repository.IRandevuRepository;
import com.keremturak.repository.entitiy.Randevu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RandevuService {
    private final IRandevuRepository randevuRepository;

    public RandevuService(IRandevuRepository randevuRepository) {
        this.randevuRepository = randevuRepository;
    }

    public RandevuResponseDto saveRandevu(RandevuRequestDto dto) {
        System.out.println("gelen gün ========"+dto.getGun());
        List<Integer> bosTarihler = findByBosSaatler(dto.getGun());
        System.out.println(bosTarihler);
        boolean durum = false;
        for (int i = 0; i < bosTarihler.size(); i++) {
            if (dto.getSaat() == bosTarihler.get(i)) {
                System.out.println(bosTarihler.get(i));
                durum = true;
            }
        }
        if (durum) {
            Randevu randevu = IRandevuMapper.INSTANCE.randevufromDto(dto);
            RandevuResponseDto randevuResponseDto = IRandevuMapper.INSTANCE.dtoFromRandevu(randevuRepository.save(randevu));
            return randevuResponseDto;
        } else {
            throw new RandevuException(ErrorType.BU_TARIH_DOLU);
        }

    }

    public List<RandevuResponseDto> aktifRandevular() {
        List<Randevu> randevuList = randevuRepository.findAllByDurum(true);
        List<RandevuResponseDto> randevuResponseDtoList = new ArrayList<>();
        randevuList.forEach(randevu -> {
            RandevuResponseDto dto = IRandevuMapper.INSTANCE.dtoFromRandevu(randevu);
            randevuResponseDtoList.add(dto);
        });
        return randevuResponseDtoList;
    }

    public RandevuResponseDto randevuIptal(String tc, int ay, int gun, int saat) {
        Optional<Randevu> optionalRandevu = randevuRepository.findOptionalByTcAndAyAndGunAndSaatAndDurum(tc, ay, gun, saat, true);
        if (optionalRandevu.isEmpty()){
            throw new RandevuException(ErrorType.TCYE_KAYITLI_BOYLE_BIR_RANDEVU_YOK);
        }
        System.out.println(optionalRandevu.get().getDurum());
        optionalRandevu.get().setDurum(false);
        Randevu randevu = randevuRepository.save(optionalRandevu.get());
        System.out.println(randevu.getDurum());
        RandevuResponseDto randevuResponseDto = IRandevuMapper.INSTANCE.dtoFromRandevu(randevu);

        return randevuResponseDto;
    }

    public List<RandevuResponseDto> findByAd(String isim) {

        List<Randevu> randevuList = randevuRepository.findAllByRandevuSahibiAndDurum(isim, true);
        List<RandevuResponseDto> randevuResponseDtoList = new ArrayList<>();
        randevuList.forEach(randevu -> {
            RandevuResponseDto dto = IRandevuMapper.INSTANCE.dtoFromRandevu(randevu);
            randevuResponseDtoList.add(dto);
        });
        return randevuResponseDtoList;
    }

    public List<Integer> findByBosSaatler(int gun) {

        List<Integer> doluSaatler = randevuRepository.guneGoreDoluSaatler(gun,true);
        System.out.println("dolu saatler == " + doluSaatler);
        List<Integer> bosSaatler = new ArrayList<>();

        for (int i = 8; i < 18; i++) {
            boolean durum = true;
            for (int j = 0; j < doluSaatler.size(); j++) {
                if (i == doluSaatler.get(j)) {
                    durum = false;
                    break;
                }
            }
            if (durum) {
                bosSaatler.add(i);
            }
        }
        return bosSaatler;
    }

    public List<Integer> findByDoluSaatler(int gun) {
        List<Integer> doluSaatler = randevuRepository.guneGoreDoluSaatler(gun,true);
        return doluSaatler;
    }
}
