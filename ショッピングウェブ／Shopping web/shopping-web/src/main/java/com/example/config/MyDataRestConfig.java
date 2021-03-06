package com.example.config;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.example.entity.Product;
import com.example.entity.ProductCategory;
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
	
	
	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		HttpMethod[] theUnsuppotedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
		// disable Http methods for products : PUT, POST n DELETE
		config.getExposureConfiguration()
        .forDomainType(Product.class)
        .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsuppotedActions)))
        .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuppotedActions));
		// disable Http methods for product-category : PUT, POST n DELETE
		config.getExposureConfiguration()
        .forDomainType(ProductCategory.class)
        .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsuppotedActions)))
        .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuppotedActions));
		//call an internal helper method
		exposeIds(config);
	}
	private void exposeIds(RepositoryRestConfiguration config) {
		//expose enitity ids
		
		//get a list of all entity classes from the entity manager
		
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		
		//create an array of the entity
		List<Class> entityClasses = new ArrayList<>();
		
		//get the entity types for the entities
		for (EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}
		
		//-expose the entity ids for the array of entity/domain types
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	}
}
