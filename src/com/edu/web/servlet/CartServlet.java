package com.edu.web.servlet;

import com.edu.domain.Cart;
import com.edu.domain.CartItem;
import com.edu.domain.PageModel;
import com.edu.domain.Product;
import com.edu.service.ProductService;
import com.edu.service.imp.ProductServiceImp;
import com.edu.web.base.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartServlet extends BaseServlet {

    public String addCartItemToCart(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //从session中获取购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //如果获取不到创建购物车 放在session中
        if (cart == null){
                cart = new Cart();
                req.getSession().setAttribute("cart",cart);
        }
            //如果获取到.直接使用
            //获取商品id
            String pid = req.getParameter("pid");
            int num = Integer.parseInt(req.getParameter("quantity"));
            //查询商品对象
            ProductService productService = new ProductServiceImp();
            Product product = productService.findProductById(pid);
            //将待够买的东西加入购物车
            CartItem cartItem = new CartItem() ;
            cartItem.setNum(num);
            cartItem.setProduct(product);
            //调用购物车的方法
            cart.addCartItemToCar(cartItem);
            //重定向到cart界面
            resp.sendRedirect("/jsp/cart.jsp");

        return null;
    }
    public String removeCartItem(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取id
        String pid = req.getParameter("id");
        //获取购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //删除
        cart.removeCartItem(pid);
        resp.sendRedirect("/jsp/cart.jsp");

        return null;
    }
    public String clearCart(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //获取购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //q清空
        cart.clearCart();
        resp.sendRedirect("/jsp/cart.jsp");

        return null;
    }

}
