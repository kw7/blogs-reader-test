package testmaven.bandesal.gob.sv.models;
// Generated 25/08/2016 02:27:39 AM by Hibernate Tools 5.1.0.Beta1

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USUARIO",schema="public")
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbusuario_idusuario_seq")
    @javax.persistence.SequenceGenerator(
            name = "tbusuario_idusuario_seq",
            sequenceName = "tbusuario_idusuario_seq",
            allocationSize = 1
    )
    @Column(name = "id_usuario", nullable = false)
    private Long id;
        
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_rol")
    private Rol rol;
    
    @Column(name="usuario")
    private String usuario;
    
    @Column(name="contrasenia")
    private String contrasenia;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellidoPaterno")
    private String apellidoPaterno;
    
    @Column(name="apellidoMaterno")
    private String apellidoMaterno;
    
    @Column(name="edad")
    private short edad;
    
    @Column(name="correo")
    private String correo;
    
    @Column(name="direccion")
    private String direccion;

   

}
