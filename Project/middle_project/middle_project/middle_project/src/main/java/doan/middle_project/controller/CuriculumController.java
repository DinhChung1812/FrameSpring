package doan.middle_project.controller;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.MessageVo;
import doan.middle_project.dto.Requests.CuriculumEditRequest;
import doan.middle_project.dto.Requests.CurriculumRequest;
import doan.middle_project.service.CuriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CuriculumController {
    @Autowired
    CuriculumService curiculumService;

    @Autowired
    CuriculumService curriculumService;

    @PostMapping("/createCurriculum")
    public void createCurriculum(@RequestBody CurriculumRequest curriculumRequest){
        curriculumService.createCurriculum(curriculumRequest);
    }

    @GetMapping("/get_all_curiculum")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllCuriculum(@RequestParam(required = false) String code) {
        List<CuriculumVo> listCuriculum = curiculumService.getAllCuriculum(code);
        if (listCuriculum == null){
            return ResponseEntity.ok(new MessageVo("Không tồn tại curiculum nào!!!", "Infor"));
        }
        return ResponseEntity.ok(listCuriculum);
    }

    @PutMapping("/edit_curiculum")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> editCuriculum(@RequestParam("curiculum_id") Integer curiculumId, @RequestBody CuriculumEditRequest curiculumEditRequest)  {
        return curiculumService.addOrEditCuriculum(curiculumId, curiculumEditRequest);
    }

    @PutMapping("/delete_curiculum")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> deleteCuriculum(@RequestParam("curiculum_id") Integer curiculumId){
        return curiculumService.deleteCuriculum(curiculumId);
    }

//    @PutMapping("/add_curiculum")
////    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
//    public ResponseEntity<?> addCuriculum(@Valid @RequestBody CuriculumEditRequest curiculumEditRequest)  {
//        return curiculumService.addOrEditCuriculum(-1, curiculumEditRequest);
//    }
}
