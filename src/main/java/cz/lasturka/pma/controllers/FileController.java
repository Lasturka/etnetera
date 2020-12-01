package cz.lasturka.pma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Controller
public class FileController {

    @GetMapping("/imports")
    public String productImports(Model model) {

        return "main/imports";
    }

    @GetMapping("/exports")
    public String productExports(Model model) {

        return "main/exports";
    }

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        try {
            InputStream stream = file.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(stream, "UTF-8");
            BufferedReader br = new BufferedReader(streamReader);

            String firstLine = br.readLine().substring(0, 25);

            redirectAttributes.addFlashAttribute("message", "file header: " + firstLine);

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:imports";
    }

}
