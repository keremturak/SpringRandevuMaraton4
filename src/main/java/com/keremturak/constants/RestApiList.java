package com.keremturak.constants;

public class RestApiList {
    /**
     * Projeler genellikle belli sunucular ve belli portlar üzerinde çalışırlar.
     * büyük projelerde ekipler ayrışır ve farklı ekipler farklı end pointler ile
     * istek atarlar. Bu ayrışmayı daha kontrollü yapmak için sabitleri yönetmek
     * iyi bir fikirdir.
     */
    public static final String API = "/api";
    public static final String TEST = "/test";
    public static final String PROD = "/prod";

    public static final String VERSION = "/v1";

    public static final String RANDEVU = API+VERSION+"/randevu";


    public static final String SAVE = "/save";

    public static final String RANDEVUIPTAL = "/randevuiptal";
    public static final String DELETE = "/delete";
    public static final String AKTIFRANDEVULAR = "/aktifRandevular";
    public static final String FINDBYAD = "/findbyad";
    public static final String BOSSAATLER = "/bossaatler";
    public static final String DOLUSAATLER = "/dolusaatler";






}
