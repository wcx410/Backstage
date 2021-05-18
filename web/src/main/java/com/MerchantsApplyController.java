package com;

import com.sun.imageio.plugins.common.ImageUtil;
import javafx.scene.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
//申请商户
@RestController
@CrossOrigin
@RequestMapping("/apply")
public class MerchantsApplyController {
    @Autowired
    MerchantsApplyService merchantsApplyService;
    @RequestMapping(value = "/addApply",produces ="application/json;charset=UTF-8")
    public String addApply(MerchantsApply apply, @RequestPart("yyzzimgFile") MultipartFile yyzzimgFile, @RequestPart("sfzzimageFile")MultipartFile sfzzimageFile, @RequestPart("sfzfimageFile")MultipartFile sfzfimageFile, HttpServletRequest request){
//        //将图片赋予该新创建的文件中
        if(yyzzimgFile!=null){
            //获取当前项目发布地址/img
            String path =  request.getServletContext().getRealPath("/img");

            try {
                yyzzimgFile.transferTo(new File(path,yyzzimgFile.getOriginalFilename()));
                sfzzimageFile.transferTo(new File(path,sfzzimageFile.getOriginalFilename()));
                sfzfimageFile.transferTo(new File(path,sfzfimageFile.getOriginalFilename()));

            }catch (IOException e){

            }

        };
        apply.setApplyTime(new Date());
        apply.setPhotos("img/"+apply.getPhotos());
        apply.setIdcardimagezheng("img/"+apply.getIdcardimagezheng());
        apply.setIdcardimagefan("img/"+apply.getIdcardimagefan());
        apply.setState(0);
//        merchantsApplyService.save(apply)?"添加成功":
        return merchantsApplyService.save(apply)?"申请成功":"申请失败";
    }
}
