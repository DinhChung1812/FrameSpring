package doan.middle_project.service;

import doan.middle_project.dto.Responds.MaterialDto;

import java.util.List;

public interface MaterialService {
    List<MaterialDto> getListMaterial();

    MaterialDto getMaterialDetail(Integer materialId);
}
