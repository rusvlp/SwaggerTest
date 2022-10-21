package com.example.swaggertest_init.controllers;

import com.example.swaggertest_init.entites.Product;
import com.example.swaggertest_init.services.ProductService;
import com.example.swaggertest_init.swaggerUtil.ErrorDescription;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@Tag(name = "Product", description = "The API for working with Product entity")
public class ProductController {
    private final ProductService productService;

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = Product.class)
                                    )
                            )
                    )
            }
    )
    @Operation(summary = "Gets all products",
            description = "Gets list of all products, stored in database",
            tags = "Product")
    @GetMapping(value = "/all", produces = "application/json", consumes = "application/json")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "success",
                            content = @Content(
                                    schema = @Schema(implementation = Product.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Can't find product",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDescription.class)
                            )
                    )
            }
    )
    @Operation(summary = "Get specific product by id",
            description = "Gets the specific product",
            tags = "Product")
    @GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public Product getProduct(@PathVariable long id){
        return productService.getProduct(id);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "success",
                            content = @Content(
                                    schema = @Schema(implementation = Product.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Product is already exits",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDescription.class)
                            )
                    )
            }
    )
    @Operation(summary = "Adds new product",
            description = "Adds a new product to database",
            tags = "Product")
    @PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
    public void addProduct(@RequestBody Product p){
        productService.createProduct(p);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "success",
                            content = @Content(
                                    schema = @Schema(implementation = Product.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Can't find product",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDescription.class)
                            )
                    )
            }
    )
    @Operation(
            summary = "This request allows to edit the specific product",
            description = "You can modify the specific product using this request",
            tags = "Product")
    @PutMapping(value = "/edit/{id}", produces = "application/json", consumes = "application/json")
    public void editProduct(@PathVariable long id, @RequestBody Product p){
        productService.updateProduct(id, p);
    }
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "success",
                            content = @Content(
                                    schema = @Schema(implementation = Product.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Can't find product",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDescription.class)
                            )
                    )
            }
    )
    @Operation(
            summary = "Removes the specific product",
            description = "You can remove the specifitc product from database using this request",
            tags = "Product")
    @DeleteMapping(value = "/delete/{id}", produces = "application/json", consumes = "application/json")
    public void deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
    }
    @Operation(
            summary = "This is a demonstration of deprecated method",
            tags = "Product",
            deprecated = true
    )
    @GetMapping("/deprecated")
    public void deprecatedRequestExample(){

    }

    @GetMapping("/hidden")
    public void hiddenExample(){

    }
}
