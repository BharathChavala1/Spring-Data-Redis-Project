package spring_data_redis_example.spring_data_redis_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring_data_redis_example.spring_data_redis_example.entity.Product;
import spring_data_redis_example.spring_data_redis_example.repository.ProductDAO;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductDAO productDAO;

    @ResponseBody
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Product saveProduct(@RequestBody Product product){
       Product product1= productDAO.save(product);
       return product1;
    }

    @ResponseBody
    @RequestMapping(path = "/findAllProducts", method = RequestMethod.GET)
    public List<Product> findAllProducts(){
        return productDAO.findAllProducts();
    }

    @ResponseBody
    @RequestMapping(path = "/findById/{id}",method = RequestMethod.GET)
    public Product findByIdProductId(@PathVariable int id){
        return productDAO.findById(id);
    }

    @ResponseBody
    @RequestMapping(path = "/updateProduct", method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Product product){
        return productDAO.updateProduct(product);
    }

    @ResponseBody
    @RequestMapping(path = "/deleteByID/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable int id){
        return productDAO.deleteByProductId(id);
    }
}
