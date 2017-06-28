package com.example.android.discoverourense;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationCategoryFragment extends Fragment {


    public LocationCategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Constructor method which allows to pass information in the construction, in order to create
     * and specific LocationCategoryFragment for each tab.
     * https://stackoverflow.com/questions/29731038/passing-data-beetwen-fragments-in-viewpager
     * @param position is the index of the tab using the fragment
     * @return a {@link LocationCategoryFragment} object
     */
    public static LocationCategoryFragment getInstance(int position)
    {
        LocationCategoryFragment object = new LocationCategoryFragment();
        Bundle bundle =  new Bundle();
        bundle.putInt("position", position);
        object.setArguments(bundle);

        return object;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list_fragment, container, false);
        // Get the index of the tab using the fragment
        int position = getArguments().getInt("position");

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<>();
        switch (position){
            case 0:
                locations.add(new Location(getString(R.string.do_title_trekking_1),
                        getString(R.string.do_short_trekking_1),
                        getString(R.string.do_long_trekking_1), R.drawable.do_trekking_1));
                locations.add(new Location(getString(R.string.do_title_thermal_2),
                        getString(R.string.do_short_thermal_2),
                        getString(R.string.do_long_thermal_2), R.drawable.do_thermal_2));
                locations.add(new Location(getString(R.string.do_title_rural_3),
                        getString(R.string.do_short_rural_3),
                        getString(R.string.do_long_rural_3), R.drawable.do_rural_3));
                locations.add(new Location(getString(R.string.do_title_btt_4),
                        getString(R.string.do_short_btt_4), getString(R.string.do_long_btt_4),
                        R.drawable.do_btt_4));
                locations.add(new Location(getString(R.string.do_title_theatre_5),
                        getString(R.string.do_short_theatre_5),
                        getString(R.string.do_long_theatre_5), R.drawable.do_teatro_5));
                locations.add(new Location(getString(R.string.do_title_music_6),
                        getString(R.string.do_short_music_6),
                        getString(R.string.do_long_music_6), R.drawable.do_music_6));
                locations.add(new Location(getString(R.string.do_title_museums_7),
                        getString(R.string.do_short_museums_7),
                        getString(R.string.do_long_museums_7), R.drawable.do_museums_7));
                locations.add(new Location(getString(R.string.do_title_routes_8),
                        getString(R.string.do_short_routes_8),
                        getString(R.string.do_long_routes_8), R.drawable.do_routes_8));
                locations.add(new Location(getString(R.string.do_title_santiago_9),
                        getString(R.string.do_short_santiago_9),
                        getString(R.string.do_long_santiago_9), R.drawable.do_santiago_9));
                locations.add(new Location(getString(R.string.do_title_catamaran_10),
                        getString(R.string.do_short_catamaran_10),
                        getString(R.string.do_long_catamaran_10), R.drawable.do_catamaran_10));
                locations.add(new Location(getString(R.string.do_title_train_11),
                        getString(R.string.do_short_train_11), getString(R.string.do_long_train_11),
                        R.drawable.do_train_11));
                locations.add(new Location(getString(R.string.do_title_familiar_12),
                        getString(R.string.do_short_familiar_12),
                        getString(R.string.do_long_familiar_12), R.drawable.do_familiar_12));
                locations.add(new Location(getString(R.string.do_title_entroido_13),
                        getString(R.string.do_short_entroido_13),
                        getString(R.string.do_long_entroido_13), R.drawable.do_entroido_13));
                locations.add(new Location(getString(R.string.do_title_maios_14),
                        getString(R.string.do_short_maios_14), getString(R.string.do_long_maios_14),
                        R.drawable.do_maios_14));
                locations.add(new Location(getString(R.string.do_title_magosto_15),
                        getString(R.string.do_short_magosto_15),
                        getString(R.string.do_long_magosto_15), R.drawable.do_magosto_15));
                locations.add(new Location(getString(R.string.do_title_samhain_16),
                        getString(R.string.do_short_samhain_16),
                        getString(R.string.do_long_samhain_16), R.drawable.do_samain_16));
                locations.add(new Location(getString(R.string.do_title_festivities_17),
                        getString(R.string.do_short_festivities_17),
                        getString(R.string.do_long_festivities_17), R.drawable.do_festivities_17));
                locations.add(new Location(getString(R.string.do_title_wine_18),
                        getString(R.string.do_short_wine_18), getString(R.string.do_long_wine_18),
                        R.drawable.do_wine_18));
                locations.add(new Location(getString(R.string.do_title_gastronomy_19),
                        getString(R.string.do_short_gastronomy_19),
                        getString(R.string.do_long_gastronomy_19), R.drawable.do_gastronomy_19));
                locations.add(new Location(getString(R.string.do_title_night_20),
                        getString(R.string.do_short_night_20), getString(R.string.do_long_night_20),
                        R.drawable.do_nightlife_20));
                break;
            case 1:
                locations.add(new Location(getString(R.string.see_title_cathedral_1),
                        getString(R.string.see_address_cathedral_1),
                        getString(R.string.see_short_cathedral_1),
                        getString(R.string.see_long_cathedral_1), R.drawable.see_cathedral_1));
                locations.add(new Location(getString(R.string.see_title_bridge_2),
                        getString(R.string.see_address_bridge_2),
                        getString(R.string.see_short_bridge_2),
                        getString(R.string.see_long_bridge_2), R.drawable.see_ponte_2));
                locations.add(new Location(getString(R.string.see_title_burgas_3),
                        getString(R.string.see_address_burgas_3),
                        getString(R.string.see_short_burgas_3),
                        getString(R.string.see_long_burgas_3), R.drawable.see_burgas_3));
                locations.add(new Location(getString(R.string.see_title_main_square_4),
                        getString(R.string.see_address_main_square_4),
                        getString(R.string.see_short_main_square_4),
                        getString(R.string.see_long_main_square_4), R.drawable.see_prazamaior_4));
                locations.add(new Location(getString(R.string.see_title_millennium_5),
                        getString(R.string.see_address_millennium_5),
                        getString(R.string.see_short_millennium_5),
                        getString(R.string.see_long_millennium_5), R.drawable.see_milenio_5));
                locations.add(new Location(getString(R.string.see_title_old_town_6),
                        getString(R.string.see_address_old_town_6),
                        getString(R.string.see_short_old_town_6),
                        getString(R.string.see_long_old_town_6), R.drawable.see_casco_6));
                locations.add(new Location(getString(R.string.see_title_ferro_7),
                        getString(R.string.see_address_ferro_7),
                        getString(R.string.see_short_ferro_7), getString(R.string.see_long_ferro_7),
                        R.drawable.see_ferro_7));
                locations.add(new Location(getString(R.string.see_title_eufemia_8),
                        getString(R.string.see_address_eufemia_8),
                        getString(R.string.see_short_eufemia_8),
                        getString(R.string.see_long_eufemia_8), R.drawable.see_santaeufemia_8));
                locations.add(new Location(getString(R.string.see_title_praza_9),
                        getString(R.string.see_address_praza_9),
                        getString(R.string.see_short_praza_9),
                        getString(R.string.see_long_praza_9), R.drawable.see_plaza_9));
                locations.add(new Location(getString(R.string.see_title_cosme_10),
                        getString(R.string.see_address_cosme_10),
                        getString(R.string.see_short_cosme_10),
                        getString(R.string.see_long_cosme_10), R.drawable.see_sancosme_10));
                locations.add(new Location(getString(R.string.see_title_cloister_11),
                        getString(R.string.see_address_cloister_11),
                        getString(R.string.see_short_cloister_11),
                        getString(R.string.see_long_cloister_11), R.drawable.see_claustro_11));
                locations.add(new Location(getString(R.string.see_title_alameda_12),
                        getString(R.string.see_address_alameda_12),
                        getString(R.string.see_short_alameda_12),
                        getString(R.string.see_long_alameda_12), R.drawable.see_alameda_12));
                locations.add(new Location(getString(R.string.see_title_posio_13),
                        getString(R.string.see_address_posio_13),
                        getString(R.string.see_short_posio_13),
                        getString(R.string.see_long_posio_13), R.drawable.see_posio_13));
                locations.add(new Location(getString(R.string.see_title_santa_maria_14),
                        getString(R.string.see_address_santa_maria_14),
                        getString(R.string.see_short_santa_maria_14),
                        getString(R.string.see_long_santa_maria_14), R.drawable.see_santamaria_14));
                locations.add(new Location(getString(R.string.see_title_paradise_15),
                        getString(R.string.see_address_paradise_15),
                        getString(R.string.see_short_paradise_15),
                        getString(R.string.see_long_paradise_15), R.drawable.see_portico_15));
                locations.add(new Location(getString(R.string.see_title_theatre_16),
                        getString(R.string.see_address_theatre_16),
                        getString(R.string.see_short_theatre_16),
                        getString(R.string.see_long_theatre_16), R.drawable.see_teatro_16));
                locations.add(new Location(getString(R.string.see_title_auditorium_17),
                        getString(R.string.see_address_auditorium_17),
                        getString(R.string.see_short_auditorium_17),
                        getString(R.string.see_long_auditorium_17), R.drawable.see_auditorio_17));
                locations.add(new Location(getString(R.string.see_title_sil_18),
                        getString(R.string.see_address_sil_18),
                        getString(R.string.see_short_sil_18), getString(R.string.see_long_sil_18),
                        R.drawable.see_sil_18));
                locations.add(new Location(getString(R.string.see_title_pedro_19),
                        getString(R.string.see_address_pedro_19),
                        getString(R.string.see_short_pedro_19),
                        getString(R.string.see_long_pedro_19), R.drawable.see_sanpedro_19));
                locations.add(new Location(getString(R.string.see_title_waterfalls_20),
                        getString(R.string.see_address_waterfalls_20),
                        getString(R.string.see_short_waterfalls_20),
                        getString(R.string.see_long_waterfalls_20), R.drawable.see_toxa_20));
                locations.add(new Location(getString(R.string.see_title_castro_21),
                        getString(R.string.see_address_castro_21),
                        getString(R.string.see_short_castro_21),
                        getString(R.string.see_long_castro_21), R.drawable.see_castro_21));
                locations.add(new Location(getString(R.string.see_title_velle_22),
                        getString(R.string.see_address_velle_22),
                        getString(R.string.see_short_velle_22),
                        getString(R.string.see_long_velle_22), R.drawable.see_velle_22));
                break;
            case 2:
                locations.add(new Location(getString(R.string.eat_title_pingallo_1),
                        getString(R.string.eat_address_pingallo_1),
                        getString(R.string.eat_short_pingallo_1),
                        getString(R.string.eat_phone_pingallo_1),
                        getString(R.string.eat_web_pingallo_1),
                        getString(R.string.eat_timetable_pingallo_1),
                        getString(R.string.eat_type_pingallo_1), R.drawable.eat_pingallo_1));
                locations.add(new Location(getString(R.string.eat_title_sanmiguel_2),
                        getString(R.string.eat_address_sanmiguel_2),
                        getString(R.string.eat_short_sanmiguel_2),
                        getString(R.string.eat_phone_sanmiguel_2),
                        getString(R.string.eat_web_sanmiguel_2),
                        getString(R.string.eat_timetable_sanmiguel_2),
                        getString(R.string.eat_type_sanmiguel_2), R.drawable.eat_sanmiguel_2));
                locations.add(new Location(getString(R.string.eat_title_acubillo_3),
                        getString(R.string.eat_address_acubillo_3),
                        getString(R.string.eat_short_acubillo_3),
                        getString(R.string.eat_phone_acubillo_3),
                        getString(R.string.eat_web_acubillo_3),
                        getString(R.string.eat_timetable_acubillo_3),
                        getString(R.string.eat_type_acubillo_3), R.drawable.eat_acubillo_3));
                locations.add(new Location(getString(R.string.eat_title_kyoto_4),
                        getString(R.string.eat_address_kyoto_4),
                        getString(R.string.eat_short_kyoto_4),
                        getString(R.string.eat_phone_kyoto_4),
                        getString(R.string.eat_web_kyoto_4),
                        getString(R.string.eat_timetable_kyoto_4),
                        getString(R.string.eat_type_kyoto_4), R.drawable.eat_kyoto_4));
                locations.add(new Location(getString(R.string.eat_title_parrillada_5),
                        getString(R.string.eat_address_parrillada_5),
                        getString(R.string.eat_short_parrillada_5),
                        getString(R.string.eat_phone_parrillada_5),
                        getString(R.string.eat_web_parrillada_5),
                        getString(R.string.eat_timetable_parrillada_5),
                        getString(R.string.eat_type_parrillada_5), R.drawable.eat_parrillada_5));
                locations.add(new Location(getString(R.string.eat_title_orellas_6),
                        getString(R.string.eat_address_orellas_6),
                        getString(R.string.eat_short_orellas_6),
                        getString(R.string.eat_phone_orellas_6),
                        getString(R.string.eat_web_orellas_6),
                        getString(R.string.eat_timetable_orellas_6),
                        getString(R.string.eat_type_orellas_6), R.drawable.eat_orellas_6));
                locations.add(new Location(getString(R.string.eat_title_dos_puertas_7),
                        getString(R.string.eat_address_dos_puertas_7),
                        getString(R.string.eat_short_dos_puertas_7),
                        getString(R.string.eat_phone_dos_puertas_7),
                        getString(R.string.eat_web_dos_puertas_7),
                        getString(R.string.eat_timetable_dos_puertas_7),
                        getString(R.string.eat_type_dos_puertas_7), R.drawable.eat_dospuertas_7));
                locations.add(new Location(getString(R.string.eat_title_arcodavella_8),
                        getString(R.string.eat_address_arcodavella_8),
                        getString(R.string.eat_short_arcodavella_8),
                        getString(R.string.eat_phone_arcodavella_8),
                        getString(R.string.eat_web_arcodavella_8),
                        getString(R.string.eat_timetable_arcodavella_8),
                        getString(R.string.eat_type_arcodavella_8), R.drawable.eat_arcovella_8));
                locations.add(new Location(getString(R.string.eat_title_catorce_9),
                        getString(R.string.eat_address_catorce_9),
                        getString(R.string.eat_short_catorce_9),
                        getString(R.string.eat_phone_catorce_9),
                        getString(R.string.eat_web_catorce_9),
                        getString(R.string.eat_timetable_catorce_9),
                        getString(R.string.eat_type_catorce_9), R.drawable.eat_catorce_9));
                locations.add(new Location(getString(R.string.eat_title_tapa_negra_10),
                        getString(R.string.eat_address_tapa_negra_10),
                        getString(R.string.eat_short_tapa_negra_10),
                        getString(R.string.eat_phone_tapa_negra_10),
                        getString(R.string.eat_web_tapa_negra_10),
                        getString(R.string.eat_timetable_tapa_negra_10),
                        getString(R.string.eat_type_tapa_negra_10), R.drawable.eat_tapanegra_10));
                locations.add(new Location(getString(R.string.eat_title_meigallo_11),
                        getString(R.string.eat_address_meigallo_11),
                        getString(R.string.eat_short_meigallo_11),
                        getString(R.string.eat_phone_meigallo_11),
                        getString(R.string.eat_web_meigallo_11),
                        getString(R.string.eat_timetable_meigallo_11),
                        getString(R.string.eat_type_meigallo_11), R.drawable.eat_meigallo_11));
                locations.add(new Location(getString(R.string.eat_title_sabela_12),
                        getString(R.string.eat_address_sabela_12),
                        getString(R.string.eat_short_sabela_12),
                        getString(R.string.eat_phone_sabela_12),
                        getString(R.string.eat_web_sabela_12),
                        getString(R.string.eat_timetable_sabela_12),
                        getString(R.string.eat_type_sabela_12), R.drawable.eat_sabela_12));
                locations.add(new Location(getString(R.string.eat_title_pulpo_13),
                        getString(R.string.eat_address_pulpo_13),
                        getString(R.string.eat_short_pulpo_13),
                        getString(R.string.eat_phone_pulpo_13),
                        getString(R.string.eat_web_pulpo_13),
                        getString(R.string.eat_timetable_pulpo_13),
                        getString(R.string.eat_type_pulpo_13), R.drawable.eat_pulpo_13));
                locations.add(new Location(getString(R.string.eat_title_tixola_14),
                        getString(R.string.eat_address_tixola_14),
                        getString(R.string.eat_short_tixola_14),
                        getString(R.string.eat_phone_tixola_14),
                        getString(R.string.eat_web_tixola_14),
                        getString(R.string.eat_timetable_tixola_14),
                        getString(R.string.eat_type_tixola_14), R.drawable.eat_tixola_14));
                locations.add(new Location(getString(R.string.eat_title_gula_15),
                        getString(R.string.eat_address_gula_15),
                        getString(R.string.eat_short_gula_15),
                        getString(R.string.eat_phone_gula_15),
                        getString(R.string.eat_web_gula_15),
                        getString(R.string.eat_timetable_gula_15),
                        getString(R.string.eat_type_gula_15), R.drawable.eat_gula_15));
                locations.add(new Location(getString(R.string.eat_title_tarazana_16),
                        getString(R.string.eat_address_tarazana_16),
                        getString(R.string.eat_short_tarazana_16),
                        getString(R.string.eat_phone_tarazana_16),
                        getString(R.string.eat_web_tarazana_16),
                        getString(R.string.eat_timetable_tarazana_16),
                        getString(R.string.eat_type_tarazana_16), R.drawable.eat_tarazana_16));
                locations.add(new Location(getString(R.string.eat_title_barallete_17),
                        getString(R.string.eat_address_barallete_17),
                        getString(R.string.eat_short_barallete_17),
                        getString(R.string.eat_phone_barallete_17),
                        getString(R.string.eat_web_barallete_17),
                        getString(R.string.eat_timetable_barallete_17),
                        getString(R.string.eat_type_barallete_17), R.drawable.eat_barallete_17));
                locations.add(new Location(getString(R.string.eat_title_cogumelo_18),
                        getString(R.string.eat_address_cogumelo_18),
                        getString(R.string.eat_short_cogumelo_18),
                        getString(R.string.eat_phone_cogumelo_18),
                        getString(R.string.eat_web_cogumelo_18),
                        getString(R.string.eat_timetable_cogumelo_18),
                        getString(R.string.eat_type_cogumelo_18), R.drawable.eat_cogumelo_18));
                locations.add(new Location(getString(R.string.eat_title_candido_19),
                        getString(R.string.eat_address_candido_19),
                        getString(R.string.eat_short_candido_19),
                        getString(R.string.eat_phone_candido_19),
                        getString(R.string.eat_web_candido_19),
                        getString(R.string.eat_timetable_candido_19),
                        getString(R.string.eat_type_candido_19), R.drawable.eat_candido_19));
                locations.add(new Location(getString(R.string.eat_title_pontevella_20),
                        getString(R.string.eat_address_pontevella_20),
                        getString(R.string.eat_short_pontevella_20),
                        getString(R.string.eat_phone_pontevella_20),
                        getString(R.string.eat_web_pontevella_20),
                        getString(R.string.eat_timetable_pontevella_20),
                        getString(R.string.eat_type_pontevella_20), R.drawable.eat_pontevella_20));
                locations.add(new Location(getString(R.string.eat_title_portovello_21),
                        getString(R.string.eat_address_portovello_21),
                        getString(R.string.eat_short_portovello_21),
                        getString(R.string.eat_phone_portovello_21),
                        getString(R.string.eat_web_portovello_21),
                        getString(R.string.eat_timetable_portovello_21),
                        getString(R.string.eat_type_portovello_21), R.drawable.eat_portovello_21));
                locations.add(new Location(getString(R.string.eat_title_coto_22),
                        getString(R.string.eat_address_coto_22),
                        getString(R.string.eat_short_coto_22),
                        getString(R.string.eat_phone_coto_22),
                        getString(R.string.eat_web_coto_22),
                        getString(R.string.eat_timetable_coto_22),
                        getString(R.string.eat_type_coto_22), R.drawable.eat_coto_22));
                locations.add(new Location(getString(R.string.eat_title_jamon_23),
                        getString(R.string.eat_address_jamon_23),
                        getString(R.string.eat_short_jamon_23),
                        getString(R.string.eat_phone_jamon_23),
                        getString(R.string.eat_web_jamon_23),
                        getString(R.string.eat_timetable_jamon_23),
                        getString(R.string.eat_type_jamon_23), R.drawable.eat_jamon_23));
                locations.add(new Location(getString(R.string.eat_title_sanxes_24),
                        getString(R.string.eat_address_sanxes_24),
                        getString(R.string.eat_short_sanxes_24),
                        getString(R.string.eat_phone_sanxes_24),
                        getString(R.string.eat_web_sanxes_24),
                        getString(R.string.eat_timetable_sanxes_24),
                        getString(R.string.eat_type_sanxes_24), R.drawable.eat_sanxes_24));
                locations.add(new Location(getString(R.string.eat_title_alpendre_25),
                        getString(R.string.eat_address_alpendre_25),
                        getString(R.string.eat_short_alpendre_25),
                        getString(R.string.eat_phone_alpendre_25),
                        getString(R.string.eat_web_alpendre_25),
                        getString(R.string.eat_timetable_alpendre_25),
                        getString(R.string.eat_type_alpendre_25), R.drawable.eat_alpendre_25));
                locations.add(new Location(getString(R.string.eat_title_duque_26),
                        getString(R.string.eat_address_duque_26),
                        getString(R.string.eat_short_duque_26),
                        getString(R.string.eat_phone_duque_26),
                        getString(R.string.eat_web_duque_26),
                        getString(R.string.eat_timetable_duque_26),
                        getString(R.string.eat_type_duque_26), R.drawable.eat_duque_26));
                locations.add(new Location(getString(R.string.eat_title_souto_27),
                        getString(R.string.eat_address_souto_27),
                        getString(R.string.eat_short_souto_27),
                        getString(R.string.eat_phone_souto_27),
                        getString(R.string.eat_web_souto_27),
                        getString(R.string.eat_timetable_souto_27),
                        getString(R.string.eat_type_souto_27), R.drawable.eat_souto_27));
                locations.add(new Location(getString(R.string.eat_title_pepita_28),
                        getString(R.string.eat_address_pepita_28),
                        getString(R.string.eat_short_pepita_28),
                        getString(R.string.eat_phone_pepita_28),
                        getString(R.string.eat_web_pepita_28),
                        getString(R.string.eat_timetable_pepita_28),
                        getString(R.string.eat_type_pepita_28), R.drawable.eat_pepita_28));
                break;
            case 3:
                locations.add(new Location(getString(R.string.sleep_title_princess_1),
                        getString(R.string.sleep_address_princess_1),
                        getString(R.string.sleep_short_princess_1),
                        getString(R.string.sleep_long_princess_1),
                        getString(R.string.sleep_phone_princess_1),
                        getString(R.string.sleep_mail_princess_1),
                        getString(R.string.sleep_web_princess_1),
                        getString(R.string.sleep_stars_princess_1), R.drawable.sleep_princess_1));
                locations.add(new Location(getString(R.string.sleep_title_auriense_2),
                        getString(R.string.sleep_address_auriense_2),
                        getString(R.string.sleep_short_auriense_2),
                        getString(R.string.sleep_long_auriense_2),
                        getString(R.string.sleep_phone_auriense_2),
                        getString(R.string.sleep_mail_auriense_2),
                        getString(R.string.sleep_web_auriense_2),
                        getString(R.string.sleep_stars_auriense_2), R.drawable.sleep_auriense_2));
                locations.add(new Location(getString(R.string.sleep_title_irixo_3),
                        getString(R.string.sleep_address_irixo_3),
                        getString(R.string.sleep_short_irixo_3),
                        getString(R.string.sleep_long_irixo_3),
                        getString(R.string.sleep_phone_irixo_3),
                        getString(R.string.sleep_mail_irixo_3),
                        getString(R.string.sleep_web_irixo_3),
                        getString(R.string.sleep_stars_irixo_3), R.drawable.sleep_irixo_3));
                locations.add(new Location(getString(R.string.sleep_title_nh_4),
                        getString(R.string.sleep_address_nh_4),
                        getString(R.string.sleep_short_nh_4),
                        getString(R.string.sleep_long_nh_4),
                        getString(R.string.sleep_phone_nh_4),
                        getString(R.string.sleep_mail_nh_4),
                        getString(R.string.sleep_web_nh_4),
                        getString(R.string.sleep_stars_nh_4), R.drawable.sleep_nh_4));
                locations.add(new Location(getString(R.string.sleep_title_sanmartin_5),
                        getString(R.string.sleep_address_sanmartin_5),
                        getString(R.string.sleep_short_sanmartin_5),
                        getString(R.string.sleep_long_sanmartin_5),
                        getString(R.string.sleep_phone_sanmartin_5),
                        getString(R.string.sleep_mail_sanmartin_5),
                        getString(R.string.sleep_web_sanmartin_5),
                        getString(R.string.sleep_stars_sanmartin_5), R.drawable.sleep_sanmartin_5));
                locations.add(new Location(getString(R.string.sleep_title_francisco_6),
                        getString(R.string.sleep_address_francisco_6),
                        getString(R.string.sleep_short_francisco_6),
                        getString(R.string.sleep_long_francisco_6),
                        getString(R.string.sleep_phone_francisco_6),
                        getString(R.string.sleep_mail_francisco_6),
                        getString(R.string.sleep_web_francisco_6),
                        getString(R.string.sleep_stars_francisco_6), R.drawable.sleep_francisco_6));
                locations.add(new Location(getString(R.string.sleep_title_minho_7),
                        getString(R.string.sleep_address_minho_7),
                        getString(R.string.sleep_short_minho_7),
                        getString(R.string.sleep_long_minho_7),
                        getString(R.string.sleep_phone_minho_7),
                        getString(R.string.sleep_mail_minho_7),
                        getString(R.string.sleep_web_minho_7),
                        getString(R.string.sleep_stars_minho_7), R.drawable.sleep_minho_7));
                locations.add(new Location(getString(R.string.sleep_title_zarampallo_8),
                        getString(R.string.sleep_address_zarampallo_8),
                        getString(R.string.sleep_short_zarampallo_8),
                        getString(R.string.sleep_long_zarampallo_8),
                        getString(R.string.sleep_phone_zarampallo_8),
                        getString(R.string.sleep_mail_zarampallo_8),
                        getString(R.string.sleep_web_zarampallo_8),
                        getString(R.string.sleep_stars_zarampallo_8), R.drawable.sleep_zarampallo_8));
                locations.add(new Location(getString(R.string.sleep_title_carris_9),
                        getString(R.string.sleep_address_carris_9),
                        getString(R.string.sleep_short_carris_9),
                        getString(R.string.sleep_long_carris_9),
                        getString(R.string.sleep_phone_carris_9),
                        getString(R.string.sleep_mail_carris_9),
                        getString(R.string.sleep_web_carris_9),
                        getString(R.string.sleep_stars_carris_9), R.drawable.sleep_carris_9));
                locations.add(new Location(getString(R.string.sleep_title_altiana_10),
                        getString(R.string.sleep_address_altiana_10),
                        getString(R.string.sleep_short_altiana_10),
                        getString(R.string.sleep_long_altiana_10),
                        getString(R.string.sleep_phone_altiana_10),
                        getString(R.string.sleep_mail_altiana_10),
                        getString(R.string.sleep_web_altiana_10),
                        getString(R.string.sleep_stars_altiana_10), R.drawable.sleep_altiana_10));
                locations.add(new Location(getString(R.string.sleep_title_ponte_11),
                        getString(R.string.sleep_address_ponte_11),
                        getString(R.string.sleep_short_ponte_11),
                        getString(R.string.sleep_long_ponte_11),
                        getString(R.string.sleep_phone_ponte_11),
                        getString(R.string.sleep_mail_ponte_11),
                        getString(R.string.sleep_web_ponte_11),
                        getString(R.string.sleep_stars_ponte_11), R.drawable.sleep_romana_11));
                locations.add(new Location(getString(R.string.sleep_title_mabu_12),
                        getString(R.string.sleep_address_mabu_12),
                        getString(R.string.sleep_short_mabu_12),
                        getString(R.string.sleep_long_mabu_12),
                        getString(R.string.sleep_phone_mabu_12),
                        getString(R.string.sleep_mail_mabu_12),
                        getString(R.string.sleep_web_mabu_12),
                        getString(R.string.sleep_stars_mabu_12), R.drawable.sleep_mabu_12));
                locations.add(new Location(getString(R.string.sleep_title_rotonda_13),
                        getString(R.string.sleep_address_rotonda_13),
                        getString(R.string.sleep_short_rotonda_13),
                        getString(R.string.sleep_long_rotonda_13),
                        getString(R.string.sleep_phone_rotonda_13),
                        getString(R.string.sleep_mail_rotonda_13),
                        getString(R.string.sleep_web_rotonda_13),
                        getString(R.string.sleep_stars_rotonda_13), R.drawable.sleep_rotonda_13));
                locations.add(new Location(getString(R.string.sleep_title_grelo_14),
                        getString(R.string.sleep_address_grelo_14),
                        getString(R.string.sleep_short_grelo_14),
                        getString(R.string.sleep_long_grelo_14),
                        getString(R.string.sleep_phone_grelo_14),
                        getString(R.string.sleep_mail_grelo_14),
                        getString(R.string.sleep_web_grelo_14),
                        getString(R.string.sleep_stars_grelo_14), R.drawable.sleep_grelo_14));
        }


        // Create a {@link LocationAdapter}, whose data source is a list of {@link Location}s.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open activity detail when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openActivityDetail = new Intent(getContext(), DetailLocationActivity.class);
                openActivityDetail.putExtra("location", locations.get(position));
                startActivity(openActivityDetail);
            }
        });

        return rootView;
    }
}
