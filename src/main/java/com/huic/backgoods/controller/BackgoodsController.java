package com.huic.backgoods.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.huic.backcategory.entity.Backcategory;
import com.huic.backcategory.service.BackCategoryService;
import com.huic.backgoods.entity.Backgoods;
import com.huic.backgoods.entity.BackgoodsPage;
import com.huic.backgoods.service.BackgoodsService;
import com.huic.backstore.entity.Backstore;

@Controller
@RequestMapping("/back/goods")
public class BackgoodsController {

	@Resource
	private BackgoodsService service;
	
	@Resource
	private BackCategoryService cservice;
	
	//商家后台商品列表
	@RequestMapping("/list")
	public String list(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
					   @RequestParam(value="pageSize",defaultValue="2")Integer pageSize,
					   HttpSession session,ModelMap model,BackgoodsPage backgoodspage)
	{
		//模拟商家已登录,整合时删除以下代码
		Backstore store=new Backstore();
		store.setsId(1);
		session.setAttribute("store", store);
		
		//获取session中的商家bean
		Backstore backstore= (Backstore) session.getAttribute("store");
		//查询出该商家所有商品的二级分类列表
		List<Backcategory> categorys = cservice.selectAllCateinStore(backstore);
		model.put("categorys", categorys);
		//向查询条件中添加商家id
		backgoodspage.setSid(backstore.getsId());
		//将查询条件返回页面 以便分页查询
		model.put("backgoodspage", backgoodspage);
		//查询出该商家所有商品
		 PageInfo<Backgoods> pages = service.selectAll(backgoodspage,pageNum,pageSize);
		//将查询结果传到前台
		model.put("pages", pages);
		return "back/product_list";
	}

	
	//商家后台商品推荐状态更新
	@RequestMapping("/updategreat")
	public  String updategreat(Backgoods backgoods,Integer pageNum,Integer cparentid,String goodsname,ModelMap model)
	{
		//获取前端选择的商品，更新
		Integer num = service.updateGreat(backgoods);
		model.put("cparentid", cparentid);
		model.put("goodsname", goodsname);
		return "redirect:/back/goods/list?pageNum="+pageNum;
	}
	
	
	//商家后台商品状态更新
	@RequestMapping("/updatestatus")
	public String updatestatus(Backgoods backgoods,Integer pageNum,Integer cparentid,String goodsname,ModelMap model)
	{
		Integer num = service.updateStatus(backgoods);
		model.put("cparentid", cparentid);
		model.put("goodsname", goodsname);
		return "redirect:/back/goods/list?pageNum="+pageNum;
	}
	
	
	//商家后台商品删除状态更新
	@RequestMapping("/deletegoods")
	public String deletegoods(Backgoods backgoods,Integer pageNum,Integer cparentid,String goodsname,ModelMap model)
	{
		Integer num = service.deletegoods(backgoods);
		model.put("cparentid", cparentid);
		model.put("goodsname", goodsname);
		return "redirect:/back/goods/list?pageNum="+pageNum;
	}
	
	//商家后台跳转到商品详情页
	@RequestMapping("/toupdategoods")
	public String updateGoods(Backgoods backgoods,ModelMap model)
	{
		backgoods = service.selectByPrimaryKey(backgoods.getgId());
		model.put("backgoods", backgoods);
		return "back/product_detail";
	}
	
	
	//商家后台商品主图更新
	@RequestMapping("/updateimg")
	@ResponseBody
	public Map updateimg(Backgoods backgoods, MultipartFile file,HttpServletRequest request,ModelMap model)
	{
		
		String originalFilename = file.getOriginalFilename();
		String end = originalFilename.substring(originalFilename.lastIndexOf("."));
		String filename = UUID.randomUUID().toString();
		String realPath = request.getServletContext().getRealPath("goodsupload");
		File savefile=new File(realPath,filename+end);
		HashMap<String,Object> map=new HashMap<String,Object>();
		
		if(!".jpg".equals(end)&&!".jpeg".equals(end)&&!".png".equals(end))
		{
			map.put("msg","格式不正确！");
			map.put("status",0);
			return map;
		}
		
		if(!savefile.exists())
		{
			savefile.mkdirs();
		}
		
		try {
			file.transferTo(savefile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String lastpath="/goodsupload/"+filename+end;
		backgoods.setgImg(lastpath);
		
		int num = service.updateByPrimaryKeySelective(backgoods);
		System.out.println("result:"+num);
		backgoods = service.selectByPrimaryKey(backgoods.getgId());
		
		map.put("status",1);
		map.put("img",backgoods.getgImg());
		map.put("msg","上传成功！");
		return map;
	}
	
	
	@ExceptionHandler
	public ModelAndView doException(Exception e)
	{
		Map<String,Object> model=new HashMap<String,Object>();
		if(e instanceof MaxUploadSizeExceededException)
		{
			MaxUploadSizeExceededException exception=(MaxUploadSizeExceededException) e;
			long size = exception.getMaxUploadSize();
			System.out.println("文件过大，必须小于"+size+"字节");
			model.put("errorMsg", "文件过大，必须小于"+size+"字节");
		}
		else
		{
			model.put("errorMsg", "发生未知错误");
		}
		
		return null;
		
	}
	
	
	
	
}
