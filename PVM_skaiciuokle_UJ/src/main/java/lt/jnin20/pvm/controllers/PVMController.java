package lt.jnin20.pvm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PVMController {

    @GetMapping("/")
    //@ResponseBody
    public String home(){
        return "skaiciuokle";
    }

    @PostMapping("/")
    //@ResponseBody
    public String apskaiciuoti(
            @RequestParam("PrKainaSu") Double PKSu,
            @RequestParam("PrKiekis") Integer vnt,
            Model model
    ){
        Double PKBe = Math.round(PKSu / 1.21 * 100.0) / 100.0;
        Double PVM = Math.round((PKSu - PKBe) * 100.0) / 100.0;
        Double BendraKBe = PKBe * vnt;
        Double BendrasPVM = PVM * vnt;
        Double Suma = PKSu * vnt;

        model.addAttribute("PKainaBe", PKBe);
        model.addAttribute("PVMvnt", PVM);
        model.addAttribute("PKainaSu", PKSu);
        model.addAttribute("BendraKainaBe", BendraKBe);
        model.addAttribute("BendrPVM", BendrasPVM);
        model.addAttribute("BendraSuma", Suma);

        return "rezultatai";
    }

}
