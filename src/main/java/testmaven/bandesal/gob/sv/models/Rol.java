package testmaven.bandesal.gob.sv.models;
// Generated 25/08/2016 02:27:39 AM by Hibernate Tools 5.1.0.Beta1

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "ROL", schema = "public")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbrol_idrol_seq")
    @javax.persistence.SequenceGenerator(
            name = "tbrol_idrol_seq",
            sequenceName = "tbrol_idrol_seq",
            allocationSize = 1
    )
    @Column(name = "id_rol", nullable = false)
    private Long id;
        
    @Column(name="descripcion")
    private String descripcion;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="rol")
    private Set<Usuario> usuarios = new HashSet<Usuario>(0);

   
}
