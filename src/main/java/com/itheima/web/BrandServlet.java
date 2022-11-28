package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Brand> brands = brandService.selectAll();
        String jsonString = JSON.toJSONString(brands);

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        Brand brand = JSON.parseObject(params,Brand.class);
        brandService.add(brand);
        resp.getWriter().write("success");
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        Brand brand = JSON.parseObject(params,Brand.class);
        brandService.update(brand);
        resp.getWriter().write("success");
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        int id = JSON.parseObject(params, int.class);
        brandService.delete(id);
        resp.getWriter().write("success");
    }
    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        Integer[] ids = JSON.parseObject(params, Integer[].class);
        brandService.deleteByIds(ids);
        resp.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Integer currentPage = Integer.parseInt(req.getParameter("currentPage"));
        Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));
        PageBean<Brand> brandPageBean = brandService.selectByPage(currentPage, pageSize);

        String jsonString = JSON.toJSONString(brandPageBean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);

    }
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Integer currentPage = Integer.parseInt(req.getParameter("currentPage"));
        Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        Brand brand = JSON.parseObject(params,Brand.class);


        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);

        String jsonString = JSON.toJSONString(brandPageBean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);

    }



}
