package com.keremturak.repository;

import com.keremturak.repository.entitiy.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRandevuRepository extends JpaRepository<Randevu,Long> {
    List<Randevu> findAllByDurum(Boolean durum);
    List<Randevu> findAllByRandevuSahibiAndDurum(String isim,Boolean durum);



   // Optional<Randevu> findOptionalByTcAndGunAndAyAndSaatAndDurum(String tc, int ay, int gun,  int saat, boolean durum);

    @Query("select d.saat from Randevu d where d.gun = ?1 and d.durum= ?2")
    List<Integer> guneGoreDoluSaatler(int gun, boolean durum);

    Optional<Randevu> findOptionalByTcAndAyAndGunAndSaatAndDurum(String tc, int ay, int gun, int saat, boolean b);
}
