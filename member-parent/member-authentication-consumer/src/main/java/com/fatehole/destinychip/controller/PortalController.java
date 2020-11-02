package com.fatehole.destinychip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/11/02/15:02
 */
@Controller
public class PortalController {

    @RequestMapping("/")
    public String showPortalPage() {

        // 省略中间加载数据的步骤

        return "portal";
    }
}
