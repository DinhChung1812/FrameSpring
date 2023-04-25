package doan.middle_project.serviceImpl;

import doan.middle_project.dto.Responds.MaterialDto;
import doan.middle_project.entities.Material;
import doan.middle_project.repositories.MaterialRepository;
import doan.middle_project.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    @Override
    public List<MaterialDto> getListMaterial() {
        List<Material> materialList = materialRepository.findAll();
        List<MaterialDto> materialDtoList = new ArrayList<>();

        for (Material m: materialList) {
            MaterialDto materialDto = new MaterialDto();
            materialDto.setMaterialId(m.getMaterialId());
            materialDto.setMaterialDescription(m.getMaterialDescription());
            materialDto.setAuthor(m.getAuthor());
            materialDto.setPublisher(m.getPublisher());
            materialDto.setPublishedDate(m.getPublishedDate());
            materialDto.setEdition(m.getEdition());
            materialDto.setIsbn(m.getIsbn());
            materialDto.setMainMaterial(m.isMainMaterial());
            materialDto.setHardCopy(m.isHardCopy());
            materialDto.setOnline(m.isOnline());
            materialDto.setNote(m.getNote());

            materialDtoList.add(materialDto);
        }
        return materialDtoList;
    }

    @Override
    public MaterialDto getMaterialDetail(Integer materialId) {
        Material m = materialRepository.getById(materialId);
        MaterialDto materialDto = new MaterialDto();
        materialDto.setMaterialId(m.getMaterialId());
        materialDto.setMaterialDescription(m.getMaterialDescription());
        materialDto.setAuthor(m.getAuthor());
        materialDto.setPublisher(m.getPublisher());
        materialDto.setPublishedDate(m.getPublishedDate());
        materialDto.setEdition(m.getEdition());
        materialDto.setIsbn(m.getIsbn());
        materialDto.setMainMaterial(m.isMainMaterial());
        materialDto.setHardCopy(m.isHardCopy());
        materialDto.setOnline(m.isOnline());
        materialDto.setNote(m.getNote());
        return materialDto;
    }
}
