package com.velvol.hr.web.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.velvol.hr.domain.Material;
import com.velvol.hr.domain.Materialmodel;
import com.velvol.hr.service.IPreworkerService;
import com.velvol.hr.utils.MatResult;
import com.velvol.hr.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class MatModAction extends BaseAction<Materialmodel>{
   
	@Autowired
	private IPreworkerService preworkerService;	
    public String material(){	
		
		String stkputdate = model.getStkputdate();
		String ssyputdate = model.getSsyputdate();
		String sgpputdate = model.getSgpputdate();
		String spxputdate = model.getSpxputdate();
		//System.out.println(ssyputdate);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
		    if(StringUtils.isNotBlank(stkputdate)){					
				Date date = sdf.parse(stkputdate);							
				model.setTkputdate(date);	
		    }
		    if(StringUtils.isNotBlank(ssyputdate)){						
				Date date = sdf.parse(ssyputdate);							
				model.setSyputdate(date);	
		    }
		    if(StringUtils.isNotBlank(sgpputdate)){					
				Date date = sdf.parse(sgpputdate);							
				model.setGpputdate(date);	
		    }
		    if(StringUtils.isNotBlank(spxputdate)){						
				Date date = sdf.parse(spxputdate);							
				model.setPxputdate(date);	
		    }
		} catch (ParseException e) {		
			e.printStackTrace();
		}	
		
		try {
			if(model.getTksort() !=null)
			   model.setTksort(URLDecoder.decode(model.getTksort() , "UTF-8"));
			if(model.getTknewold() !=null)
			   model.setTknewold(URLDecoder.decode(model.getTknewold() , "UTF-8"));
			if(model.getTkremark() !=null)
			   model.setTkremark(URLDecoder.decode(model.getTkremark() , "UTF-8"));
			
			if(model.getSysort() !=null)
			   model.setSysort(URLDecoder.decode(model.getSysort() , "UTF-8"));
			if(model.getSynewold() !=null)
			   model.setSynewold(URLDecoder.decode(model.getSynewold() , "UTF-8"));
			if(model.getSyremark() !=null)
			   model.setSyremark(URLDecoder.decode(model.getSyremark() , "UTF-8"));
			
			if(model.getGpremark() !=null)
				   model.setGpremark(URLDecoder.decode(model.getGpremark() , "UTF-8"));
			if(model.getPxremark() !=null)
				   model.setPxremark(URLDecoder.decode(model.getPxremark() , "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
        preworkerService.putMaterial(model);
        
        MatResult result = new MatResult(true,"提交成功！");
        this.java2Json(result, new String[]{});
    			
		return NONE;
	
      }
 
    //人事提交时，判断头盔和上衣是否发放
    public String matcheck(){
    	
    	boolean b = preworkerService.matcheck(model.getId());
    	MatResult result = new MatResult(b, "");
    	this.java2Json(result, new String[]{});
    	return NONE;
    }
    
    //站长提交。判断外卖箱是否发放
      public String matcheckwmx(){
    	System.out.println("model.getId():"+model.getId());
    	boolean b = preworkerService.matcheckwmx(model.getId());
    	System.out.println("结果："+b);
    	MatResult result = new MatResult(b, "");
    	this.java2Json(result, new String[]{});
    	return NONE;
    }
    //站长补充发放物料
public String stationmaterial(){	
		
		String swmxputdate = model.getSwmxputdate();
		String sddcputdate = model.getSddcputdate();
		String sbxputdate = model.getSbxputdate();
		String shtputdate = model.getShtputdate();
		System.out.println("保险:"+sbxputdate);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
		    if(StringUtils.isNotBlank(swmxputdate)){					
				Date date = sdf.parse(swmxputdate);							
				model.setWmxputdate(date);	
		    }
		    if(StringUtils.isNotBlank(sddcputdate)){						
				Date date = sdf.parse(sddcputdate);							
				model.setDdcputdate(date);	
		    }
		    if(StringUtils.isNotBlank(sbxputdate)){					
				Date date = sdf.parse(sbxputdate);							
				model.setBxputdate(date);	
		    }
		    if(StringUtils.isNotBlank(shtputdate)){						
				Date date = sdf.parse(shtputdate);							
				model.setHtputdate(date);	
		    }
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		try {
			if(model.getWmxsort() !=null)
			   model.setWmxsort(URLDecoder.decode(model.getWmxsort() , "UTF-8"));
			if(model.getWmxnewold() !=null)
			   model.setWmxnewold(URLDecoder.decode(model.getWmxnewold() , "UTF-8"));
			if(model.getWmxremark() !=null)
			   model.setWmxremark(URLDecoder.decode(model.getWmxremark() , "UTF-8"));
			
			if(model.getDdcsort() !=null)
			   model.setDdcsort(URLDecoder.decode(model.getDdcsort() , "UTF-8"));
			if(model.getDdcnewold() !=null)
			   model.setDdcnewold(URLDecoder.decode(model.getDdcnewold() , "UTF-8"));
			if(model.getDdcremark() !=null)
			   model.setDdcremark(URLDecoder.decode(model.getDdcremark() , "UTF-8"));
			
			if(model.getBxremark() !=null)
				   model.setBxremark(URLDecoder.decode(model.getBxremark() , "UTF-8"));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        preworkerService.putMaterial(model);
        MatResult result = new MatResult(true,"提交成功！");
        this.java2Json(result, new String[]{});
    					
		return NONE;
	
      }

    //属性封装的方式获取传递过来的工地地图
	private File image; //用来接收上传文件的参数，注意该参数名称用同jsp页面的文件输入框的参数名称一致
	private String imageFileName; //用来接收上传文件的文件名，注意格式必须这样写
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}	
	public void setImage(File image) {
		this.image = image;
	}
    //上传健康证
	public String uploadjkz() throws IOException{
		
		if(image !=null&&imageFileName!=null&&!"".equals(imageFileName)){
		     			
			//获取健康证存放目录
			String realpath = ServletActionContext.getServletContext().getRealPath("/");
			System.out.println(realpath);			
			File file = new File(realpath+"\\jkzimage");
		     if(!file.exists())
			    file.mkdirs();
			    
		     //生成一个随机唯一的文件名
		     String newFilename = UUID.randomUUID() + imageFileName.substring(imageFileName.lastIndexOf("."));
		     //通过commons-io包里的FileUtils，把接收到的源文件image，复制到指定的目录下的文件名为imageFileName
		    FileUtils.copyFile(image, new File(file,newFilename));
		  
		    System.out.println(newFilename);
		    
		    preworkerService.updatejkz(model,newFilename);
			
			//重新设置下session
		//	session.setAttribute("user", userService.getUserById(sUser.getId()));
		    
		}
		return "dbdlist";
	}
}
