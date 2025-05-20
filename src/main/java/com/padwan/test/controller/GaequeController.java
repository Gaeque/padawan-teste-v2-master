package com.padwan.test.controller;

import com.padwan.test.service.GaequeService;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gaeque")
public class GaequeController {

  private GaequeService gaequeService;

  public GaequeController(GaequeService gaequeService) {
    this.gaequeService = gaequeService;
  }

  @ResponseBody
  @RequestMapping(value = "/skills", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> skills() {
    try {
      JSONObject json = new JSONObject();
      json.put("Gaeque Luan", gaequeService.skills());
      return new ResponseEntity(json.toString(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
