package testmaven.bandesal.gob.sv.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
@Table(name = "BLOGS", schema = "public")
public class Blogs {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbblogs_id_seq")
	@javax.persistence.SequenceGenerator(name = "tbblogs_id_seq", sequenceName = "tbblogs_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false, length = 8)
	private Long id;
	@Column(name = "title", length = 50)
	private String title;
	@Column(name = "description", length = 4000)
	private String description;
	
}
