package com.altrh.multimedia.models;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
@NamedQuery(name="User.findByEmailId", query = "select u from User u where u.email=:email")
@NamedQuery(name="User.getAllUser", query = "select new com.altrh.multimedia.wrapper.UserWrapper(u.id,u.name,u.email, u.contactNumber,u.status) from User u where u.role='user'")
@NamedQuery(name="User.updateStatus", query = "update User u set u.status=:status where u.id=:id")
@NamedQuery(name="User.getAllAdmin", query = "select u.email from User u where u.role='admin'")


@Data //Pour créer des constructeurs par defaut
@Entity // représente une entité persistante dans une base de données relationnelle
@DynamicUpdate //Hibernate génère des requêtes de mise à jour qui ne mettent à jour que les colonnes ayant réellement changé
@DynamicInsert //Hibernate génère des requêtes d'insertion qui n'incluent que les colonnes avec des valeurs non nulles,
@Table(name="user")//spécifier le nom de la table à laquelle une entité est mappée dans la base de données
public class User implements Serializable { // Pour convertir un objet Java en une séquence d'octets
    private static final long serialVersionUID = 1L; //stock un numéro de version ne peut pas être modifiée une fois qu'elle a été initialisée
    // assurer que la version de sérialisation reste constante pendant toute la durée de vie de la classe.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Pour l'auto incrémentation
    @Column(name="id")
    private Integer id;//clé primaire
    @Column(name="name")
    private String name;
    @Column(name="contactNumber")
    private String contactNumber;
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="status")
    private String status;

    @Column(name="role")
    private String role;

}
