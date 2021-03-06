package com.mindia.pedidos_online.pedidos_online_back.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.pedidos_online.pedidos_online_back.persistence.model.SectionBase;
import com.mindia.pedidos_online.pedidos_online_back.persistence.model.SectionMultipleCategories;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"name",
	"image",
	"type",
	"categories"
})
public class PojoSection {
	@JsonProperty("name")
	String name;
	@JsonProperty("image")
	String image;
	@JsonProperty("type")
	int type;
	@JsonProperty("categories")
	List<String> categories;
	
	public PojoSection(SectionBase section) {
		this.name = section.getName();
		this.image = section.getImage();
		
		if(section instanceof SectionMultipleCategories) {
			type = ((SectionMultipleCategories)section).getType();
			categories = ((SectionMultipleCategories)section).getCategories();
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

}
