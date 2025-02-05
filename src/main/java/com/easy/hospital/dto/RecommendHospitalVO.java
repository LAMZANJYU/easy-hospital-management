package com.easy.hospital.dto;

import com.easy.hospital.dao.model.Hospital;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RecommendHospitalVO {
    private Long id;
    private String name;
    private String imageUrl;
    private String address;
    private Integer distance;
    private Double star;
    private String description;

    public static RecommendHospitalVO ofHospital(Hospital hospital) {
        return new RecommendHospitalVO()
                .setId(hospital.getId())
                .setName(hospital.getHospitalName())
                .setImageUrl(hospital.getImageUrl())
                .setAddress(hospital.getAddress())
                .setStar(hospital.getStar())
                .setDescription(hospital.getInfo());
    }
}
