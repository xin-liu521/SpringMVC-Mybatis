package com.velvol.hr.web.action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.velvol.hr.utils.DateUtil;
import com.velvol.hr.utils.UploadFileUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
 * <dl>
 * <dt>ClassName: UploadController </dt>
 * <dd>CreateDate: 2017-08-29 14:02 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Description:       附件上传     </dd>
 * </dl>
 *
 * @author wangjun
 */

@Controller
public class UploadAction extends ActionSupport implements ModelDriven {

    private File[] file;
    private String[] fileFileName;
    private String[] fileContentType;

    //    private MultipartFile[] file;
//    public void setFile(MultipartFile[] file) {
//        this.file = file;
//    }
    /**
     * 上传图片()
     * @throws Exception
     */
//    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    public void insertFile() throws Exception{

        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        String filePath = request.getParameter("file");
        if(file!=null&&file.length>0){
            //组合image名称，“;隔开”
            List<Map> fileName =new ArrayList<>();
            Map<String, Object> params = null;
            try {
                for (int i = 0; i < file.length; i++) {
                    params = new HashMap<>();
                    if (file[i] != null) {
                        //上传文件，随机名称，";"分号隔开
                        String  fileUrl = UploadFileUtils.uploadImage(request, "/uploadFloder/"+ DateUtil.formatDate(new Date(), "yyyy-MM-dd")+"/", file[i], true,fileFileName[i]);
                        String origName = fileFileName[i];// 文件原名称
                        params.put("docUrl", fileUrl);
                        params.put("docName", origName);
                        fileName.add(params);
                    }
                }

                //上传成功
                if(fileName!=null&&fileName.size()>0){
                    System.out.println("上传成功！");
                    printJson(response, JSONArray.fromObject(fileName) ,0);
                }else {
                    printJson(response, "上传失败！文件格式错误！",1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                printJson(response, "上传出现异常！",1);
            }
        }else {
            printJson(response, "没有检测到文件！",1);
        }
    }


    /**
     * 上传附件(目前用户自定义表单中的 File Upload控件(目前仅限图片，后期可以更改方法逻辑))
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/uploadControl",method = RequestMethod.POST)
    public void uploadControl(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //将request变成多部分request
        MultipartHttpServletRequest multipartHttpServletRequest= (MultipartHttpServletRequest) request;
        //获取multiRequest 中所有的文件名
        Iterator iter=multipartHttpServletRequest.getFileNames();
        List<String> listFileName =new ArrayList<>();
        try{
            //遍历文件
            while(iter.hasNext()){
                //一次性遍历所有文件
                MultipartFile file=multipartHttpServletRequest.getFile(iter.next().toString());
                if(file!=null){
                    listFileName.add(UploadFileUtils.uploadFile(request, "/uploadControl/"+ DateUtil.formatDate(new Date(), "yyyy-MM-dd")+"/", file, true));
                }
            }
            //上传成功
            if(listFileName!=null&&listFileName.size()>0){
                System.out.println("上传成功！");
                printJson(response,JSONObject.fromObject(listFileName) ,0);
            }else {
                printJson(response, "上传失败！文件格式错误！",1);
            }

        }catch (Exception e){
            e.printStackTrace();
            printJson(response, "上传出现异常！",1);
        }
    }

    private void printJson(HttpServletResponse response, Object msg, int code) {
        try {
            PrintWriter out = response.getWriter();
            Map<String, Object> resultObject = new HashMap<>();
            resultObject.put("msg", msg);
            resultObject.put("code", code);
            out.print(JSONArray.fromObject(resultObject));
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getModel() {
        return null;
    }


    /**
     *
     * 单个文件下载
     *
     * @param response
     * @param fileUrl 文件路径
     * @param fileName 文件名称
     * @return
     * @throws Exception
     */
//    @RequestMapping(value="/downloadFile", method = RequestMethod.GET)
//    @ResponseBody
//    public ResultObject downloadFile(HttpServletResponse response,
//                                     HttpServletRequest request,
//                                     String fileUrl,
//                                     String fileName) throws Exception {
//
//        boolean res = UploadFileUtils.downloadFile(fileUrl, fileName, response, request);
//        ResultObject result = new ResultObject();
//        result.setData(res);
//        if (res) {
//            result.setSuccess(false);
//        }
//        return result;
//    }

    public File[] getFile() {
        return file;
    }

    public void setFile(File[] file) {
        this.file = file;
    }

    public String[] getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String[] fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String[] getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String[] fileContentType) {
        this.fileContentType = fileContentType;
    }
}
