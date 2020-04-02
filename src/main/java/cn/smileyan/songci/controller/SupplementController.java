package cn.smileyan.songci.controller;

import cn.smileyan.songci.entity.Supplement;
import cn.smileyan.songci.service.SupplementService;
import cn.smileyan.songci.util.RestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Smileyan
 */
@CrossOrigin
@RestController
@RequestMapping("/supplement")
public class SupplementController {
    @Autowired
    private SupplementService supplementService;

    @GetMapping("/id/{id}")
    private RestBody getSupplementById(@PathVariable("id")  Long id) {
        RestBody restBody = new RestBody();
        restBody.setCode(RestBody.SUCCESS);
        restBody.setMsg("SUCCESS");
        Supplement supplementById = supplementService.getSupplementById(id);
        restBody.setData(supplementById);
        return restBody;
    }
}
