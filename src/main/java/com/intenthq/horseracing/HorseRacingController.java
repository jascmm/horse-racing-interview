package com.intenthq.horseracing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HorseRacingController {

    public static final String INPUT_ATT = "input";
    public static final String OUTPUT_ATT = "output";

    @RequestMapping("/horse-racing")
    public String horseRacing(ModelMap model) {
        return "horse-racing";
    }

    @RequestMapping("/horse-racing/exercise")
    public String exercise(@RequestParam(value="input", required=false) String input, ModelMap model) {
		if (!StringUtils.isEmpty(input)) {
            model.addAttribute(INPUT_ATT, input); 
            
            Track track = new Track(220);
            track.ingestInput(input);
            
            model.addAttribute(OUTPUT_ATT, track.getRaceResults());
         
            
		}
        return "exercise";
    }

}
