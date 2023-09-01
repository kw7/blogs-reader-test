package testmaven.bandesal.gob.sv.dto;


import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@XmlRootElement (name="BlogsDTO")
public class BlogsDTO {

	private Long id;	
	private String title;
	private String description;
}
