package com.nan.controller;

import com.nan.dao.FilesDao;
import com.nan.entity.Files;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    FilesDao filesDao;

    @RequestMapping("/files")
    public String findALl(Model model){
        List<Files> files = filesDao.queryAll();
        System.out.println("================================================================");
        model.addAttribute("files",files);
        System.out.println("查询所有");
        System.out.println(files);
        return "files/list";
    }


    @RequestMapping("/getjsondata")
    @ResponseBody
    public List<Files> getjson(Model model){
        List<Files> files = filesDao.queryAll();

        return files;
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        if(file.getSize()==0){
            return "redirect:/file/files";
        }
        String oldname=file.getOriginalFilename();

        String extension = "."+FilenameUtils.getExtension(file.getOriginalFilename());

        String newname=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+UUID.randomUUID().toString().replace("-","")+extension;

        long size = file.getSize();

        String type = file.getContentType();
        String isImg=file.getContentType().startsWith("image")?"yes":"no";

        //处理文件上传
        String realpath = ResourceUtils.getURL("classpath:").getPath() + "static/files";
        String dateFormat=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dateDirpath=realpath+"/"+dateFormat;
        File dateDir= new File(dateDirpath);
        if(!dateDir.exists()) {dateDir.mkdirs();}

        file.transferTo(new File(dateDir,newname));

        Files javafile=new Files(0,oldname,newname,extension,"/files/"+dateFormat,size,type
                ,isImg,0,new Date());

        filesDao.insert(javafile);

        return "redirect:/file/files";
    }

    @RequestMapping("delete")
    public String delete(Integer id) throws FileNotFoundException {

        Files files = filesDao.queryById(id);

        //获得绝对路径
        String realpath=ResourceUtils.getURL("classpath:").getPath()+"/static"+files.getPath();
        File file = new File(realpath, files.getNewname());
        if(file.exists()){
            file.delete();
        }

        filesDao.deleteById(id);
        return "redirect:/file/files";
    }


    @RequestMapping("/download")
    public String download(Integer id,String openstyle, HttpServletResponse response) throws IOException {

        openstyle=openstyle==null?"attachment":openstyle;
        Files files = filesDao.queryById(id);
        if("attachment".equals(openstyle)){
            files.setCount(files.getCount()+1);
        }

        filesDao.update(files);
        String realpath=ResourceUtils.getURL("classpath:").getPath()+"/static"+files.getPath();

        FileInputStream fileInputStream = new FileInputStream(new File(realpath, files.getNewname()));
        response.setHeader("content-disposition",openstyle+";fileName="+ URLEncoder.encode(files.getOldname(),"UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(fileInputStream,outputStream);
        IOUtils.closeQuietly(fileInputStream);
        IOUtils.closeQuietly(outputStream);
        return "redirect:/file/files";
    }



}
