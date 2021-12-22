package org.wecancoeit.reviews;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class KdramaController {

    @Resource
    private KdramaReviewsRepository kdramaRepo;

    @RequestMapping("/kdramas")
    public String findAllKdramas(Model model){
        model.addAttribute("kdramasModel", kdramaRepo.findAll());
        return "kdramasTemplate";
    }

    @RequestMapping("/kdrama")
    public String findOneKdrama(@RequestParam(value="id") Long id, Model model){
        model.addAttribute("kdramaModel", kdramaRepo.findOne(id));
        return "kdramaTemplate";
    }
}

