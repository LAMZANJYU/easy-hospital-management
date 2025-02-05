package com.easy.hospital.dto;

import com.easy.hospital.dao.model.Doctor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RecommendDoctorVO {
    private Long id;
    private String name;
    private String imageUrl;
    private String hospital;
    private String department;
    private String title;
    private Double star;
    private String description;

    public static RecommendDoctorVO ofDoctor(Doctor doctor) {
        return new RecommendDoctorVO()
                .setId(doctor.getId())
                .setName(doctor.getDoctorName())
                .setImageUrl(doctor.getImageUrl())
                .setHospital(doctor.getHospitalName())
                .setDepartment(doctor.getDepartmentName())
                .setTitle(doctor.getTitle())
                .setStar(doctor.getStar())
                .setDescription(doctor.getDoctorIntroduction());
    }
}
