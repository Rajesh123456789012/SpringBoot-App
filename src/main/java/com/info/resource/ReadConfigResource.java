package com.info.resource;

import com.info.util.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.info.util.Constant.API_EMP;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = API_EMP, produces = Constant.APP_V1_JSON)
@Slf4j
public class ReadConfigResource {

    @Value("#{${bannerMappings}}")
    private Map<String, String> mappings;

    @Value("#{'${page-source}'.split(',')}")
    private List<String> list;

    @GetMapping("/list")
    public List<String> getListInfo(){
        return list;
    }

    @GetMapping("/map")
    public Map<String, String> getMapInfo(){
        return mappings;
    }
}
