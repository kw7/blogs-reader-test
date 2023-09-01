package testmaven.bandesal.gob.sv.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "READERS", schema = "public")
public class Readers {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbreades_id_seq")
	@javax.persistence.SequenceGenerator(name = "tbreades_id_seq", sequenceName = "tbreades_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false, length = 8)
	private Long id;
	@Column(name = "name",length = 8)
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "blogs_readers", joinColumns = { @JoinColumn(name = "r_id") }, inverseJoinColumns = {
			@JoinColumn(name = "b_id") })
	private List<Blogs> blogs=new ArrayList<>();
}
