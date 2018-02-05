/**
 * Copyright 2018 Alfatec Sistemas.
 */

package com.natslash.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 */

@Controller
public class IndexController {
  @RequestMapping("/")
  String index() {
    return "index";
  }
}
