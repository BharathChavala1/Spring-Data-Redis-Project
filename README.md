# Spring Boot Redis Example Project

This project demonstrates a simple Spring Boot application that uses Redis as a data source for storing and managing product information. Below are some snapshots of the key components and configurations of the project.

## 1. Product Controller

The `ProductController.java` manages HTTP requests to perform CRUD operations on `Product` entities. It includes methods for saving, finding, updating, and deleting products.

![Product Controller](https://github.com/BharathChavala1/Spring-Data-Redis-Project/blob/main/Images/Controller.png)

In the above code, `@RequestMapping` annotations are used to map web requests to specific handler methods in the `ProductController`. You can perform operations like `save`, `find`, and `update` products using HTTP methods such as `GET`, `POST`, `PUT`, and `DELETE`.

## 2. Redis Configuration

The `RedisConfiguration.java` sets up the Redis connection using `JedisConnectionFactory` and defines a `RedisTemplate` for serializing and deserializing Redis data.

![Redis Configuration](./path_to_image/Screenshot_2024-10-23_at_9.51.51_PM.png)

Here, the configuration connects to Redis running locally on port `6379`. The `RedisTemplate` provides a convenient way to interact with Redis data structures like hashes.

## 3. Product DAO

The `ProductDAO.java` interacts with Redis using the `RedisTemplate` to store and retrieve `Product` entities. The CRUD operations are executed on the Redis hash for efficient access.

![Product DAO](./path_to_image/Screenshot_2024-10-23_at_9.52.03_PM.png)

The `ProductDAO` class is responsible for interacting with Redis for performing CRUD operations. It uses the `RedisTemplate` to save and retrieve `Product` objects, which are stored in a Redis hash with a key of `"Product"`.

## 4. Maven Dependencies

The `pom.xml` includes all necessary dependencies for Spring Boot, Redis, and Jedis, ensuring smooth integration between Spring and Redis.

![Maven Dependencies](./path_to_image/Screenshot_2024-10-23_at_9.52.55_PM.png)

The `pom.xml` file includes dependencies such as:
- `spring-boot-starter-data-redis`: Provides Redis integration with Spring Boot.
- `spring-boot-starter-web`: Supports web-based RESTful services.
- `jedis`: A Redis client library for connecting and executing commands to Redis.

---

This project demonstrates basic Redis usage in a Spring Boot application, and can be extended to support advanced caching strategies, pub/sub messaging, and much more.
