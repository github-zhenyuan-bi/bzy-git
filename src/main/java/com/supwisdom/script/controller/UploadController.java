package com.supwisdom.script.controller;

import java.awt.Image;
import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.supwisdom.framework.utils.FileUtil;
import com.supwisdom.framework.utils.PathUtil;
import com.supwisdom.framework.utils.SystemConstant;
import com.supwisdom.framework.web.controller.parent.MyAbstractController;
import com.supwisdom.framework.web.domain.bean.R;

@Controller
@RequestMapping("upload")
public class UploadController extends MyAbstractController {

    
    @PostMapping("jubenCoverImg")
    public @ResponseBody R<Object> jubenCoverImg(MultipartFile img) throws Exception {
        return uploadJubenImg(img, PathUtil.getWebappResourcePath(SystemConstant.JUBEN_UPLOAD_COVER_IMG_PATH));
    }
    
    
    
    @PostMapping("jubenCharacterImg")
    public @ResponseBody R<Object> jubenCharacterImg(MultipartFile img) throws Exception {
        return uploadJubenImg(img, PathUtil.getWebappResourcePath(SystemConstant.JUBEN_UPLOAD_CHARACTER_IMG_PATH));
    }
    
    
    
    
    private R<Object> uploadJubenImg(MultipartFile img, String uploadJubenImgPath) throws Exception {
        File uploadedImg = null;
        String thumbnailImgName = null;
        try {
            // 1. 校验是否图片文件
            Image imgObj = FileUtil.checkImg(img);
            
            // 2. 获取剧本封面上传路径
            //uploadJubenImgPath = PathUtil.getWebappResourcePath(SystemConstant.JUBEN_UPLOAD_CHARACTER_IMG_PATH);
            
            // 3. 上传图片
            uploadedImg = FileUtil.uploadImg(img, uploadJubenImgPath);
            String uploadedImgName = uploadedImg.getName();
            
            // 4. 添加水印
            //FileUtil.waterMarkForPic(uploadedImg);
            
            // 5. 生成原图的压缩图片
            thumbnailImgName = FileUtil.generateThumbnail2Directory(
                    uploadedImg, uploadJubenImgPath, FileUtil.calculateImgScale(imgObj));
            
            // 6. 返回文件在项目中的相对地址
            Object canoPath = uploadJubenImgPath + uploadedImgName;
            return R.ofSuccess(canoPath);
        } catch (Exception e) {
            // exp: 异常时将上传的文件删除
            if (uploadedImg != null && uploadedImg.exists()) 
                uploadedImg.delete();
            if (!StringUtils.isEmpty(thumbnailImgName) && !StringUtils.isEmpty(uploadJubenImgPath)) {
                File thumbnailImg = new File(uploadJubenImgPath + thumbnailImgName);
                if (thumbnailImg.exists())
                    thumbnailImg.delete();
            }
            throw new Exception("上传剧本封面图片失败，原因：" + e.getMessage());
        }
    }
}
