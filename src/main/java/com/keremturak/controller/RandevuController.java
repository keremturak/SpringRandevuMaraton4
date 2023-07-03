package com.keremturak.controller;

import com.keremturak.dto.request.RandevuRandevuIptalRequestDto;
import com.keremturak.dto.request.RandevuRequestDto;
import com.keremturak.dto.response.RandevuResponseDto;
import com.keremturak.service.RandevuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.keremturak.constants.RestApiList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RANDEVU)
public class RandevuController {
    private final RandevuService randevuService;

    @PostMapping(SAVE)
    public ResponseEntity<RandevuResponseDto> saveRandevu(@RequestBody @Valid RandevuRequestDto dto) {
        return ResponseEntity.ok(randevuService.saveRandevu(dto));
    }
    @GetMapping(AKTIFRANDEVULAR)
    public List<RandevuResponseDto> aktifRandevular() {
        return randevuService.aktifRandevular();
    }

    @PostMapping(RANDEVUIPTAL)
    public ResponseEntity<RandevuResponseDto> randevuIptal(String tc, int ay, int gun, int saat) {
        return ResponseEntity.ok( randevuService.randevuIptal(tc, ay, gun, saat));
    }

    @GetMapping(FINDBYAD)
    public ResponseEntity<List<RandevuResponseDto>> findByAd(String isim) {
        return ResponseEntity.ok(randevuService.findByAd(isim));
    }
    @GetMapping(BOSSAATLER)
    public ResponseEntity<List<Integer>> findByBosSaatler(int gun) {
        return ResponseEntity.ok(randevuService.findByBosSaatler(gun));
    }
    @GetMapping(DOLUSAATLER)
    public ResponseEntity<List<Integer>> findByDoluSaatler(int gun) {
        return ResponseEntity.ok(randevuService.findByDoluSaatler(gun));
    }

}
