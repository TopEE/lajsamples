/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj;

import java.io.IOException;
import javax.servlet.Filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author IEUser
 */
@WebFilter("/rest/*")
public class AuthFilter implements Filter{
    

        
        

    @Override
    public void init(FilterConfig filterConfig) {   }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        try{
        if(req.authenticate(resp)) {
            chain.doFilter(req, resp);
        }
        
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
            throw e;
        }
    }
    @Override
    public void destroy() {  }
}


