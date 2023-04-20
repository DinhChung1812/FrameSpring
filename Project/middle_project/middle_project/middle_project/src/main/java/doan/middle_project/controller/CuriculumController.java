package doan.middle_project.controller;

import doan.middle_project.common.vo.CuriculumVo;
import doan.middle_project.common.vo.MessageVo;
import doan.middle_project.common.vo.PLOVo;
import doan.middle_project.common.vo.POVo;
import doan.middle_project.dto.Requests.CuriculumEditRequest;
import doan.middle_project.dto.Requests.CurriculumRequest;
import doan.middle_project.service.CuriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import doan.middle_project.service.CuriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public ResponseEntity<?> createCurriculum(@RequestParam(required = false) Integer decisionId, @RequestBody CurriculumRequest curriculumRequest){
       return curriculumService.createCurriculum(decisionId, curriculumRequest);
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

    @GetMapping("/get_all_plo")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllPlo(@RequestParam(required = false) String code) {
        List<PLOVo> listPlo = curiculumService.getAllPLO(code);
        if (listPlo == null){
            return ResponseEntity.ok(new MessageVo("Không tồn tại plo nào!!!", "Infor"));
        }
        return ResponseEntity.ok(listPlo);
    }

    @GetMapping("/get_all_po")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> getAllPo (@RequestParam(required = false) String code) {
        List<POVo> listPo = curiculumService.getAllPO(code);
        if (listPo == null){
            return ResponseEntity.ok(new MessageVo("Không tồn tại po nào!!!", "Infor"));
        }
        return ResponseEntity.ok(listPo);
    }

}
