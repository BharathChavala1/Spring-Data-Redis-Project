package spring_data_redis_example.spring_data_redis_example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import spring_data_redis_example.spring_data_redis_example.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductDAO {
    private final String HASH_KEY = "Product";
    @Autowired
    RedisTemplate<String,Object> template;

    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,product.getProductID(),product);
        return product;
    }
    public List<Product> findAllProducts(){
        List<Object> productObject =  template.opsForHash().values(HASH_KEY);
        List<Product> products =  productObject.stream().map(Object -> (Product) Object).collect(Collectors.toList());
        return products;
    }

    public Product findById(int id){
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }

    public String updateProduct(Product product){
        Product product1 = (Product) template.opsForHash().get(HASH_KEY,product.getProductID());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setQty(product.getQty());
        save(product1);
        return  "Sucessfully Updated";
    }

    public String deleteByProductId(int id) {
         template.opsForHash().delete(HASH_KEY,id);
         return "Delete Successfully";
    }
}
